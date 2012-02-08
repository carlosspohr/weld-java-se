package com.wp.carlos4web.cdi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.wp.carlos4web.cdi.components.messages.Message;

public class MessageDAO implements IMessageDAO {

	@Inject
	private Logger logger;
	
	private Connection connection;
	
	@Inject 
	public MessageDAO(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public void save(Message message) {
		logger.info("Salvando a mensagem no banco de dados: " + message.getTitulo());
		
		try {
			PreparedStatement ps = this.connection.prepareStatement("INSERT INTO mensagem (descricao, titulo, tipo) VALUES(?, ?, ?)");
			ps.setString(1, message.getDescricao());
			ps.setString(2, message.getTitulo());
			ps.setInt(3, message.getTipo());
			
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Message message) {
		logger.info("Excluindo a mensagem no banco de dados com o ID: " + message.getId());
	}

	@Override
	public Collection<Message> findByMessage(Message message) {
		logger.info("Consultando mensagens do banco...");
		
		try {
			PreparedStatement ps = this.connection.prepareStatement("SELECT * FROM mensagem ORDER BY id");
			
			ResultSet result = ps.executeQuery();
			
			Collection<Message> mensagens = new ArrayList<Message>(0);
			
			while (result.next()) {
				Message m = new Message();
				
				m.setId(new Long(result.getInt("id")));
				m.setDescricao(result.getString("descricao"));
				m.setTitulo(result.getString("titulo"));
				m.setTipo(result.getInt("tipo"));
				
				mensagens.add(m);
			}
			
			return mensagens;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
