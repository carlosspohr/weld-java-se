package com.wp.carlos4web.cdi;

import java.util.Collection;
import java.util.List;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.jboss.weld.environment.se.bindings.Parameters;
import org.jboss.weld.environment.se.events.ContainerInitialized;

import com.wp.carlos4web.cdi.components.messages.IMessageComponent;
import com.wp.carlos4web.cdi.components.messages.Message;
import com.wp.carlos4web.cdi.dao.IMessageDAO;
import com.wp.carlos4web.cdi.dao.connection.transaction.IConnectionTransaction;

public class Executa {
	
	@Inject
	private Logger logger;
	
	@Inject
	private IMessageComponent messageComponent;
	
	@Inject
	private IMessageDAO dao;
	
	@Inject
	private IMessageDAO daoConsulta;

	@IConnectionTransaction
	public void main(@Observes ContainerInitialized container, @Parameters List<String> parameters) {
		
		for (int i = 0; i < 2; i++) {
			Message m = new Message();
			
			m.setDescricao("Descrição n: "+ i);
			m.setTitulo("Título n: "+ i);
			m.setId(new Long(i));
			
			messageComponent.addMessage(m);
			
			this.dao.save(m);
		}
		
		Collection<Message> mensagens = this.daoConsulta.findByMessage(null);
		for (Message message : mensagens) {
			logger.info("Mensagem ID: " + message.getId());
		}
	}
}
