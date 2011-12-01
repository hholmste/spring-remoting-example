package no.someorg.remoting.example.client;

import no.someorg.remoting.example.Service;
import no.someorg.remoting.example.circular.Person;

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

		LOG.info("Searching for Lorelai");

		Person lorelai = service.retrievePerson("Lorelai");

		LOG.info("Lorelai is {}", lorelai);

		Person mike = service.retrievePerson("Mike");

		LOG.info("Mike is {}", mike);

		LOG.info("... and this is his family:\n{}", mike.familyTree());

		Person mikesFirstSibling = mike.getSiblings().get(0);
		Person mikesSecondSibling = mike.getSiblings().get(1);

		LOG.info(
				"The family seen from the siblings's point of view:\n{}\n{}",
				mikesFirstSibling.familyTree(),
				mikesSecondSibling.familyTree());

		LOG.info("entering repeat-phase");
		foreverPoll(service);
	}

	private static void foreverPoll(Service service) {
		boolean go = true;
		while (go) {
			LOG.info("---------------------------");
			try {
				Thread.sleep(2500);
				Person mike = service.retrievePerson("Mike");
				LOG.info("Forever retrieving {}", mike);
			} catch(InterruptedException e) {
				LOG.info("Interrupted, will leave foreverloop");
				go = false;
			} catch (Exception e) {
				LOG.info("Mike failed <{}>", e.getClass().getSimpleName());
			}

		}
	}

}
