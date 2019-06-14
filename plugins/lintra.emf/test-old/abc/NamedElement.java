package abc;

import blackboard.IdentifiableElement;
import java.io.Serializable;
import abc.Enums.*;

public abstract class NamedElement implements Serializable, IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String

	name;

	public NamedElement() {
	}

	public NamedElement(String name) {

		super();

		this.name = name;

	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
