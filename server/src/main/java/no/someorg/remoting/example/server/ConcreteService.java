package no.someorg.remoting.example.server;

import java.io.Serializable;

import no.someorg.remoting.example.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConcreteService implements Service, Serializable {

	private static final long serialVersionUID = 7395905762639568516L;
	private static final Logger LOG = LoggerFactory.getLogger(ConcreteService.class);
	
	public String calculateRemoteMessage() {
		LOG.info("Concrete Service calculating remote message");
		
		return "Hi! This is a message from a remote Spring Bean";
	}

}
