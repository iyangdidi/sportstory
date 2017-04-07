package com.sportstory.domain.response.user;

import java.util.ArrayList;
import java.util.List;

import com.sportstory.domain.bean.NeigborInfo;
import com.sportstory.domain.response.AbstractResponse;

public class ResponseNeigborList extends AbstractResponse{
	List<NeigborInfo> neigborInfoList;

	public List<NeigborInfo> getNeigborInfoList() {
		return neigborInfoList;
	}

	public void setNeigborInfoList(List<NeigborInfo> neigborInfoList) {
		this.neigborInfoList = neigborInfoList;
	}
	
}
