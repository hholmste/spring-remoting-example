package no.someorg.remoting.example.circular;

import java.io.Serializable;
import java.util.List;

public class Person implements Serializable {

	private static final long serialVersionUID = 4719279713773850478L;

	private String name;
	private List<Person> siblings;
	private Person spouse;

	public String getName() {
		return name;
	}

	public Person withName(String name) {
		this.name = name;
		return this;
	}

	public List<Person> getSiblings() {
		return siblings;
	}

	public Person withSiblings(List<Person> siblings) {
		this.siblings = siblings;
		return this;
	}

	public Person getSpouse() {
		return spouse;
	}

	public Person withSpouse(Person spouse) {
		this.spouse = spouse;
		return this;
	}

	public String toString() {
		return name + " married to " + spouse.getName();
	}
	
	public String familyTree() {
		StringBuilder b = new StringBuilder("Name: ").append(name).append("\nSpouse: ").append(spouse);
		
		for (Person sibling: siblings) {
			b.append("\n\tSibling: ").append(sibling.getName()).append(" married to ").append(sibling.getSpouse().getName());
		}
		
		return b.toString();
	}
	
}
