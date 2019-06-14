package movies;

import blackboard.IdentifiableElement;
import java.io.Serializable;
import movies.Enums.*;

public abstract class Group implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	double

	avgRating;

	String[] commonMoviesID;
	Boolean commonMoviesIsComposed = false;

	public Group() {
	}

	public Group(String[] commonMoviesID, double avgRating) {

		super();

		this.avgRating = avgRating;

		this.commonMoviesID = commonMoviesID;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}

	public double getAvgRating() {
		return avgRating;
	}

	public void setCommonMoviesID(String[] commonMoviesID) {
		this.commonMoviesID = commonMoviesID;
	}

	public String[] getCommonMoviesID() {
		return commonMoviesID;
	}

}
