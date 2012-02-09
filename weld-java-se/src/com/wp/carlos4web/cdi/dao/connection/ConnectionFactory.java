package com.wp.carlos4web.cdi.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.log4j.Logger;

@Singleton
public class ConnectionFactory{

	@Inject
	private Logger logger;
	
	private Connection connection = null;

	@Produces
	public Connection getConnection() throws SQLException{
		if(this.connection == null || this.connection.isClosed()){
			logger.info("Abrindo uma conexão com o banco de dados...");
			
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost/gp", "root", "123");
		}
		
		return this.connection;
	}
}
