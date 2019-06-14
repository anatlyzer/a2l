package abc;

import blackboard.IdentifiableElement;
import java.io.Serializable;
import abc.Enums.*;

public class C extends NamedElement
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	public C() {
	}

	public C(String id, String name) {

		super(name);

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
