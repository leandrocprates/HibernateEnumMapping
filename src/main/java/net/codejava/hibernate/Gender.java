package net.codejava.hibernate;

public enum Gender {
	MALE {
		public String toString() {
			return "male";
		}
	}
	, FEMALE {
		public String toString() {
			return "female";
		}
	};
	
	public abstract String toString();
	
}
