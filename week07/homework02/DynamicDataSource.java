package com.geek.homework;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends  AbstractRoutingDataSource{
	
	 @Override
	    protected Object determineCurrentLookupKey() {
	        // 此处暂时返回固定 master 数据源, 后面按动态策略修改
	        return DynamicDataSourceContextHolder.getContextKey();
	    }
}
