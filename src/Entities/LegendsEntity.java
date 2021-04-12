package Entities;

import Entities.Classes.LegendsEntityClass;
import Entities.Util.LegendsEntityStats;

public abstract class LegendsEntity {
	
	private String name;
	private int ID;
	
	/* =================== */
	/* Constructor Methods */
	/* =================== */
	
	public LegendsEntity(int ID) {
		this.setID(ID);
		this.setName("Legends Entity #" + ID);
	}
	
	public LegendsEntity(int ID, String name) {
		this.setID(ID);
		this.setName(name);
	}
	
	/* ================ */
	/* Abstract Methods */
	/* ================ */
	
	public abstract LegendsEntityClass getEntityClass();
	public abstract void setEntityClass(LegendsEntityClass eClass);
	
	public abstract LegendsEntityStats getEntityStats();
	public abstract void setLegendsEntityStats(LegendsEntityStats eStats);
	
	/* ===================== */
	/* Getter/Setter Methods */
	/* ===================== */
	
	private void setID(int ID) {
		this.ID = ID;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getID() {
		return this.ID;
	}
	
	public String getName() {
		return this.name;
	}

	/* =========== */
	/* Aux Methods */
	/* =========== */

	public boolean equals(LegendsEntity e) {
		return this.getID() == e.getID();
	}

	public String toString() {
		return this.getName();
	}
}
