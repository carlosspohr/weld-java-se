package com.wp.carlos4web.cdi.dao;

import com.wp.carlos4web.cdi.components.messages.Message;

public interface IGenericDAO {

	public void save(Message message);
	
	public void delete(Message message);
}
