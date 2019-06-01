package net.codejava.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "PERSON2")
public class Person2 {
	private int id;
	private String name;
	private Gender gender;
	
        
        public Person2(){
            
        }
        
	public Person2(String name, Gender gender) {
		this.name = name;
		this.gender = gender;
	}

	@Id
	@Column(name = "PERSON_ID")
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Enumerated(EnumType.STRING)//define que uma string sera escrita no banco de dados 
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}
