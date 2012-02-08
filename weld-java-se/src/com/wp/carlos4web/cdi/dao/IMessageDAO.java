package com.wp.carlos4web.cdi.dao;

import java.util.Collection;

import com.wp.carlos4web.cdi.components.messages.Message;

public interface IMessageDAO extends IGenericDAO {
	
	public Collection<Message> findByMessage(Message message);
}
