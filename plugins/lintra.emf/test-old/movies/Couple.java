package movies;

import blackboard.IdentifiableElement;
import java.io.Serializable;
import movies.Enums.*;

public class Couple extends Group implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	String p1ID;
	Boolean p1IsComposed = false;

	String p2ID;
	Boolean p2IsComposed = false;

	public Couple() {
	}

	public Couple(String id, String[] commonMoviesID, double avgRating,
			String p1ID, String p2ID) {

		super(commonMoviesID, avgRating);

		this.id = id;

		this.p1ID = p1ID;
		this.p2ID = p2ID;
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

	public void setP1ID(String p1ID) {
		this.p1ID = p1ID;
	}

	public String getP1ID() {
		return p1ID;
	}

	public void setP2ID(String p2ID) {
		this.p2ID = p2ID;
	}

	public String getP2ID() {
		return p2ID;
	}

}
