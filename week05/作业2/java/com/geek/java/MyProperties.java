package com.geek.java;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties
public class MyProperties {
	
	public String name="weib";

}
