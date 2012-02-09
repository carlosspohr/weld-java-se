package com.wp.carlos4web.cdi.dao.connection.transaction;

import java.sql.Connection;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.apache.log4j.Logger;

@Interceptor
@IConnectionTransaction
public class ConnectionInterceptor {

	@Inject
	private Connection connection;
	
	@Inject
	private Logger logger;
	
	@AroundInvoke
	public Object closeConnection (InvocationContext context) throws Exception
	{
		logger.info("Interceptando uma chamada ao banco de dados: " + this.connection.isClosed());
 
		Object object = context.proceed();
 
		if(!this.connection.isClosed()){
			this.connection.close();
		}
		
		logger.info("Connection após a saída do método: " + this.connection.isClosed());
 
		return object;
	}
}
