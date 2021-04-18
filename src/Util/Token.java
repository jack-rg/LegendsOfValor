package Util;

public class Token {
	String colorCode;
	String design;

	public Token(String design) {
		this.design = design;
	}

	public void setDesign(String d) {
		design = d;
	}

	public String getDesign() {
		return design;
	}

	public void printDesign() {
		System.out.print(design);
	}

}
