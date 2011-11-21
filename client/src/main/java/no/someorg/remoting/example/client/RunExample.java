package no.someorg.remoting.example.client;

import no.someorg.remoting.example.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunExample {

	private static final Logger LOG = LoggerFactory.getLogger(RunExample.class);
	
	public static void main(String[] args) {
		LOG.info("Running remoting example.");
		
		LOG.info("Loading application context.");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		
		LOG.info("Retrieving remote bean.");
		
		Service service = (Service) context.getBean("remoteService", Service.class);
		
		LOG.info("Calculating remote value.");
		
		String value = service.calculateRemoteMessage();
		
		LOG.info("Got '{}' from the remote bean.", value);
	}
	
}
