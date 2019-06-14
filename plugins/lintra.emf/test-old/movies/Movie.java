package movies;

import blackboard.IdentifiableElement;
import java.io.Serializable;

public class Movie implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	String

	title;
	double

	rating;
	int

	year;
	movies.Enums.MovieType

	type;

	String[] personsID;
	Boolean personsIsComposed = false;

	public Movie() {
	}

	public Movie(String id, String[] personsID, String title, double rating,
			int year, movies.Enums.MovieType movie) {

		super();

		this.id = id;

		this.title = title;
		this.rating = rating;
		this.year = year;
		this.type = movie;

		this.personsID = personsID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTrgId() {
		return trgId;
	}

	public void setTrgId(String trgId) {
		this.trgId = trgId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public double getRating() {
		return rating;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getYear() {
		return year;
	}

	public void setType(movies.Enums.MovieType type) {
		this.type = type;
	}

	public movies.Enums.MovieType getType() {
		return type;
	}

	public void setPersonsID(String[] personsID) {
		this.personsID = personsID;
	}

	public String[] getPersonsID() {
		return personsID;
	}

}
