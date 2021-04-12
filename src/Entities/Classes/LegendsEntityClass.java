package Entities.Classes;

public class LegendsEntityClass {

	private String className;

	/* =================== */
	/* Constructor Methods */
	/* =================== */

	public LegendsEntityClass(String className) {
		this.setClassName(className);
	}

	public void setClassName(String className) {
		this.className = className;
	}

	/* ===================== */
	/* Getter/Setter Methods */
	/* ===================== */

	public String getClassName() {
		return this.className;
	}

	/* =========== */
	/* Aux Methods */
	/* =========== */

	public String toString() {
		return this.getClassName();
	}
}
