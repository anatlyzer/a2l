package movies;

import blackboard.IdentifiableElement;
import java.io.Serializable;
import movies.Enums.*;

public class Actor extends Person implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	public Actor() {
	}

	public Actor(String id, String[] moviesID, String name) {

		super(moviesID, name);

		this.id = id;

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

}
