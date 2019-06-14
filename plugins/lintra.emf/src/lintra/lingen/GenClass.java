package lintra.lingen;

public class GenClass {
	private String contents;
	private String pkgName;
	private String className;

	public GenClass(String pkgName, String className, String contents) {
		this.pkgName = pkgName;
		this.className = className;
		this.contents = contents;
	}

	public String getContents() {
		return contents;
	}
	
	public String getPkgName() {
		return pkgName;
	}
	
	public String getTypeName() {
		return className;
	}
	
}