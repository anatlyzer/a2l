package abc;

import blackboard.IdentifiableElement;
import java.io.Serializable;
import abc.Enums.*;

public class A extends NamedElement
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	Colors

	color;

	String[] bsID;
	Boolean bsIsComposed = true;

	public A() {
	}

	public A(String id, String name, String[] bsID, Colors color) {

		super(name);

		this.id = id;

		this.color = color;

		this.bsID = bsID;
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

	public void setColor(Colors color) {
		this.color = color;
	}

	public Colors getColor() {
		return color;
	}

	public void setBsID(String[] bsID) {
		this.bsID = bsID;
	}

	public String[] getBsID() {
		return bsID;
	}

	public Boolean getBsIsComposed() {
		return bsIsComposed;
	}

}
