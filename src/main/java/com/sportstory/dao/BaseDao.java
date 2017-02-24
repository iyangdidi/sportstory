package com.sportstory.dao;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sportstory.util.QueryResult;

import java.lang.reflect.Type;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class BaseDao<T> {

	private Class<T> entityClass;
	
	private String entityName;
	private String entityColums;
	
	@PersistenceContext 
	protected EntityManager em;

	// 通过反射获得子类确定的泛型
	public BaseDao() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class) params[0];
		
		entityName = getEntityName(entityClass);
		entityColums = getCountField(entityClass);
	}
	
	public void clear(){  
        em.clear();  
    }
	
	//通过ID,删除一个PO
	public void deleteById(Object entityid) {  
		deleteByIds(new Object[]{entityid});  
    }
	
	//通过ID,批量删除PO
	public void deleteByIds(Object[] entityids) {  
        for(Object id : entityids){  
            em.remove(em.getReference(entityClass, id));  
        }  
    } 
	
	//获得记录数目
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)  
    public long getCount() {  
        return (Long)em.createQuery("select count("+ getCountField(entityClass) +") from "+ getEntityName(entityClass)+ " o").getSingleResult();  
    }
  
	//更新PO
	public void update(T entity) {  
        em.merge(entity);  
    }	
	
	//通过ID获得PO
	public T getObjectById(Serializable id){
		return em.find(entityClass, id);
	}	
	
	//添加一个PO
	public void add(T entity){
		em.persist(entity);
	}
	
    @Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)  
    public <T> QueryResult<T> getScrollData(int firstindex, int maxresult, LinkedHashMap<String, String> orderby) {  
        return getScrollData(firstindex,maxresult,null,null,orderby);  
    }  
      
    @Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)  
    public <T> QueryResult<T> getScrollData(int firstindex, int maxresult, String wherejpql, Object[] queryParams) {  
        return getScrollData(firstindex,maxresult,wherejpql,queryParams,null);  
    }  
      
    @Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)  
    public <T> QueryResult<T> getScrollData(int firstindex, int maxresult) {  
        return getScrollData(firstindex,maxresult,null,null,null);  
    }  
      
    @Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)  
    public <T> QueryResult<T> getScrollData() {  
        return getScrollData(-1, -1);  
    }  
    @SuppressWarnings("unchecked")  
    @Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)  
    public <T> QueryResult<T> getScrollData(int firstindex, int maxresult, String wherejpql, Object[] queryParams,LinkedHashMap<String, String> orderby) {  
        QueryResult qr = new QueryResult<T>();  
        String entityname = getEntityName(entityClass);  
        Query query = em.createQuery("select o from "+ entityname+ " o "+(wherejpql==null? "": "where "+ wherejpql)+ buildOrderby(orderby));  
        setQueryParams(query, queryParams);  
        if(firstindex!=-1 && maxresult!=-1) query.setFirstResult(firstindex).setMaxResults(maxresult);  
        qr.setResultList(query.getResultList());  
        query = em.createQuery("select count("+ getCountField(entityClass)+ ") from "+ entityname+ " o "+(wherejpql==null? "": "where "+ wherejpql));  
        setQueryParams(query, queryParams);  
        qr.setTotalrecord((Long)query.getSingleResult());  
        return qr;  
    }  
      
    protected void setQueryParams(Query query, Object[] queryParams){  
        if(queryParams!=null && queryParams.length>0){  
            for(int i=0; i<queryParams.length; i++){  
                query.setParameter(i+1, queryParams[i]);  
            }  
        }  
    }  
    /** 
     * 组装order by语句 
     * @param orderby 
     * @return 
     */  
    protected String buildOrderby(LinkedHashMap<String, String> orderby){  
        StringBuffer orderbyql = new StringBuffer("");  
        if(orderby!=null && orderby.size()>0){  
            orderbyql.append(" order by ");  
            for(String key : orderby.keySet()){  
                orderbyql.append("o.").append(key).append(" ").append(orderby.get(key)).append(",");  
            }  
            orderbyql.deleteCharAt(orderbyql.length()-1);  
        }  
        return orderbyql.toString();  
    }  

	//获得表字段
	protected String getCountField(Class<T> entityClass){  
        String out = "o";  
        try {  
            PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(entityClass).getPropertyDescriptors();  
            for(PropertyDescriptor propertydesc : propertyDescriptors){  
                Method method = propertydesc.getReadMethod();  
                if(method!=null && method.isAnnotationPresent(EmbeddedId.class)){                     
                    PropertyDescriptor[] ps = Introspector.getBeanInfo(propertydesc.getPropertyType()).getPropertyDescriptors();  
                    out = "o."+ propertydesc.getName()+ "." + (!ps[1].getName().equals("class")? ps[1].getName(): ps[0].getName());  
                    break;  
                }  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return out;  
    }  
	//获得实体名
    protected <T> String getEntityName(Class<T> entityClass){  
        String entityname = entityClass.getSimpleName();  
        Entity entity = entityClass.getAnnotation(Entity.class);  
        if(entity.name()!=null && !"".equals(entity.name())){  
            entityname = entity.name();  
        }  
        return entityname;  
    } 
    
    /**
     * 
     * @param wheresql where查询语句
     * @param queryParams where占位符参数
     * @param ordersql	排序方式
     * @return
     */
    public List selectQuery(String wheresql, Object[] queryParams, String ordersql){
    	String entityname = getEntityName(entityClass);
    	String jsql = " select o " +
    			      " from "+ entityname + " o "
    			      + wheresql
    			      + ordersql;
    	Query query = em.createQuery(jsql);
    	setQueryParams(query, queryParams); 
    	return query.getResultList();
    }
    public List selectQuery(String wheresql, Object[] queryParams){
    	return selectQuery(wheresql, queryParams, "");
    }

}
