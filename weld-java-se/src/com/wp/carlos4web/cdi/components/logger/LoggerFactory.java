package com.wp.carlos4web.cdi.components.logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

import org.apache.log4j.Logger;

public class LoggerFactory {

	private InjectionPoint ip;

	@Inject
	public LoggerFactory(InjectionPoint ip) {
		super();
		this.ip = ip;
	}
	
	@Produces
	public Logger getLogger(){
		return Logger.getLogger(this.ip.getMember().getDeclaringClass());
	}
}
