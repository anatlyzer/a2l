package abc;
public class Enums {

	public static enum Colors {
		lit0("red"), lit1("blue"), lit2("<=");

		private final String name;

		private Colors(String s) {
			name = s;
		}

		public boolean equalsName(String otherName) {
			return (otherName == null) ? false : name.equals(otherName);
		}

		public String toString() {
			return this.name;
		}
	}

}
