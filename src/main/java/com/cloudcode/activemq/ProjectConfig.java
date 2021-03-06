package com.cloudcode.activemq;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import com.cloudcode.framework.annotation.ModuleConfig;
import com.cloudcode.framework.bean.ProjectBeanNameGenerator;

@ModuleConfig(name = ProjectConfig.NAME, domainPackages = { "com.cloudcode.activemq.model" })
@ComponentScan(basePackages = { "com.cloudcode.activemq.*" }, nameGenerator = ProjectBeanNameGenerator.class)
@PropertySource(name = "cloudcode.evn", value = { "classpath:proj.properties" })
public class ProjectConfig {
	public static final String NAME = "activemq";
	public static final String PREFIX = NAME + ".";



}
