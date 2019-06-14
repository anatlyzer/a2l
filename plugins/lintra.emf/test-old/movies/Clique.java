package movies;

import blackboard.IdentifiableElement;
import java.io.Serializable;
import movies.Enums.*;

public class Clique extends Group implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	String[] personsID;
	Boolean personsIsComposed = false;

	public Clique() {
	}

	public Clique(String id, String[] commonMoviesID, double avgRating,
			String[] personsID) {

		super(commonMoviesID, avgRating);

		this.id = id;

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

	public void setPersonsID(String[] personsID) {
		this.personsID = personsID;
	}

	public String[] getPersonsID() {
		return personsID;
	}

}
