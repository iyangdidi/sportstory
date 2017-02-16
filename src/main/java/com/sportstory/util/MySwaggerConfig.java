package com.sportstory.util;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

/**
 * 项目名称：apidoc
 *
 * @description:
 * @author Wind-spg
 * @create_time：2015年2月10日 上午10:27:51
 * @version V1.0.0
 *
 */
//@WebAppConfiguration 
//@EnableSwagger
//@ComponentScan(basePackages = {"com.sportstory.util"})
//@Import(SpringSwaggerConfig.class)
 
@EnableWebMvc
@EnableSwagger
@Import(SpringSwaggerConfig.class)
@ComponentScan("com.sportstory.controller") 
@WebAppConfiguration
public class MySwaggerConfig implements ServletContextAware
{
	
	private SpringSwaggerConfig springSwaggerConfig;
	
	/**
	* Required to autowire SpringSwaggerConfig
	*/
	@Autowired
	public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
	  this.springSwaggerConfig = springSwaggerConfig;
	}
	
	/**
	* Every SwaggerSpringMvcPlugin bean is picked up by the swagger-mvc framework - allowing for multiple
	* swagger groups i.e. same code base multiple swagger resource listings.
	 */
	@Bean
	public SwaggerSpringMvcPlugin customImplementation(){
	  return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
	          .includePatterns(".*pet.*");
	}
	
	
 
//    private SpringSwaggerConfig springSwaggerConfig;
// 
//    /**
//     * Required to autowire SpringSwaggerConfig
//     */
//    @Autowired
//    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig)
//    {
//        this.springSwaggerConfig = springSwaggerConfig;
//    }
// 
//    /**
//     * Every SwaggerSpringMvcPlugin bean is picked up by the swagger-mvc
//     * framework - allowing for multiple swagger groups i.e. same code base
//     * multiple swagger resource listings.
//     */
//    @Bean
//    public SwaggerSpringMvcPlugin customImplementation()
//    {
//        return (SwaggerSpringMvcPlugin) new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(apiInfo()).includePatterns(.*?);
//    }
// 
//    private ApiInfo apiInfo()
//    {
//        ApiInfo apiInfo = new ApiInfo("sportstory","","", "","","");
//        return apiInfo;
//    }
	
	  private ApiInfo apiInfo() {
		    ApiInfo apiInfo = new ApiInfo(
		            "Demo Spring MVC swagger 1.2 api",
		            "Sample spring mvc api based on the swagger 1.2 spec",
		            "http://en.wikipedia.org/wiki/Terms_of_service",
		            "somecontact@somewhere.com",
		            "Apache 2.0",
		            "http://www.apache.org/licenses/LICENSE-2.0.html"
		    );
		    return apiInfo;
	  }

	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		
	}
}
