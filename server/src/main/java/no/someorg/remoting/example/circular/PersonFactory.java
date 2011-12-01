package no.someorg.remoting.example.circular;

import java.util.Arrays;

public class PersonFactory {

	public static final Person createMike() {
		Person bob = spouses("Bob", "Lily");
		Person kelly = spouses("Kelly", "John");

		Person mikesWife = new Person().withName("Lea");
		Person mike = new Person().withName("Mike").withSpouse(mikesWife).withSiblings(Arrays.asList(bob, kelly));
		mikesWife.withSpouse(mike);
		
		bob.withSiblings(Arrays.asList(mike, kelly));
		kelly.withSiblings(Arrays.asList(mike, bob));
		
		
		
		return mike;
	}

	private static Person spouses(String sibling, String spouse) {
		Person mikesSibling = new Person().withName(sibling);
		Person siblingsSpouse = new Person().withName(spouse).withSpouse(mikesSibling);
		mikesSibling.withSpouse(siblingsSpouse);

		return mikesSibling;
	}

}
