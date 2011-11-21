package no.someorg.remoting.example;

import no.someorg.remoting.example.circular.Person;

/**
 * Stuff that should be implemented on the server and used on the client
 * 
 * Since I can't be arsed to package a separate jar that both client and server depends on, I'll simply copy-paste the interface definition.
 */
public interface Service {

	String calculateRemoteMessage();

	Person retrievePerson(String name);
	
}
