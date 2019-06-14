package abc;

import blackboard.IdentifiableElement;

import java.io.Serializable;
import java.util.Arrays;

import abc.Enums.*;

public class B extends NamedElement
		implements
			Serializable,
			IdentifiableElement {

	private static final long serialVersionUID = 1L;

	String id, trgId;

	Colors

	testColor;
	Colors[] testColors;
	int

	testInteger;
	int[] testIntegers;
	double

	testDouble;
	double[] testDoubles;
	String

	testString;
	String[] testStrings;
	boolean

	testBoolean;
	boolean[] testBooleans;

	String[] csID;
	Boolean csIsComposed = true;

	public B() {
	}

	public B(String id, String name, String[] csID, Colors testColor,
			Colors[] testColors, int testInteger, int[] testIntegers,
			double testDouble, double[] testDoubles, String testString,
			String[] testStrings, boolean testBoolean, boolean[] testBooleans) {

		super(name);

		this.id = id;

		this.testColor = testColor;
		this.testColors = testColors;
		this.testInteger = testInteger;
		this.testIntegers = testIntegers;
		this.testDouble = testDouble;
		this.testDoubles = testDoubles;
		this.testString = testString;
		this.testStrings = testStrings;
		this.testBoolean = testBoolean;
		this.testBooleans = testBooleans;

		this.csID = csID;
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

	public void setTestColor(Colors testColor) {
		this.testColor = testColor;
	}

	public Colors getTestColor() {
		return testColor;
	}

	public void setTestColors(Colors[] testColors) {
		this.testColors = testColors;
	}

	public Colors[] getTestColors() {
		return testColors;
	}

	public void setTestInteger(int testInteger) {
		this.testInteger = testInteger;
	}

	public int getTestInteger() {
		return testInteger;
	}

	public void setTestIntegers(int[] testIntegers) {
		this.testIntegers = testIntegers;
	}

	public int[] getTestIntegers() {
		return testIntegers;
	}

	public void setTestDouble(double testDouble) {
		this.testDouble = testDouble;
	}

	public double getTestDouble() {
		return testDouble;
	}

	public void setTestDoubles(double[] testDoubles) {
		this.testDoubles = testDoubles;
	}

	public double[] getTestDoubles() {
		return testDoubles;
	}

	public void setTestString(String testString) {
		this.testString = testString;
	}

	public String getTestString() {
		return testString;
	}

	public void setTestStrings(String[] testStrings) {
		this.testStrings = testStrings;
	}

	public String[] getTestStrings() {
		return testStrings;
	}

	public void setTestBoolean(boolean testBoolean) {
		this.testBoolean = testBoolean;
	}

	public boolean getTestBoolean() {
		return testBoolean;
	}

	public void setTestBooleans(boolean[] testBooleans) {
		this.testBooleans = testBooleans;
	}

	public boolean[] getTestBooleans() {
		return testBooleans;
	}

	public void setCsID(String[] csID) {
		this.csID = csID;
	}

	public String[] getCsID() {
		return csID;
	}

	public Boolean getCsIsComposed() {
		return csIsComposed;
	}

	@Override
	public String toString() {
		return "B [id=" + id + ", trgId=" + trgId + ", testColor=" + testColor
				+ ", testColors=" + Arrays.toString(testColors)
				+ ", testInteger=" + testInteger + ", testIntegers="
				+ Arrays.toString(testIntegers) + ", testDouble=" + testDouble
				+ ", testDoubles=" + Arrays.toString(testDoubles)
				+ ", testString=" + testString + ", testStrings="
				+ Arrays.toString(testStrings) + ", testBoolean=" + testBoolean
				+ ", testBooleans=" + Arrays.toString(testBooleans) + ", csID="
				+ Arrays.toString(csID) + ", csIsComposed=" + csIsComposed
				+ "]";
	}

}
