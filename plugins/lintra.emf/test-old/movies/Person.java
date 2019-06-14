package movies;

import blackboard.IdentifiableElement;
import java.io.Serializable;
import movies.Enums.*;

public abstract class Person implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String

	name;

	String[] moviesID;
	Boolean moviesIsComposed = false;

	public Person() {
	}

	public Person(String[] moviesID, String name) {

		super();

		this.name = name;

		this.moviesID = moviesID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setMoviesID(String[] moviesID) {
		this.moviesID = moviesID;
	}

	public String[] getMoviesID() {
		return moviesID;
	}

}
