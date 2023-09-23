package edu.lab.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tb_character_class")
public class CharacterClass {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String className;
	private int health;
    private int basePhysicalDamage;
    private int baseMagicalDamage;
    private int basePhysicalDefense;
    private int baseMagicalDefense;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getBasePhysicalDamage() {
		return basePhysicalDamage;
	}

	public void setBasePhysicalDamage(int basePhysicalDamage) {
		this.basePhysicalDamage = basePhysicalDamage;
	}

	public int getBaseMagicalDamage() {
		return baseMagicalDamage;
	}

	public void setBaseMagicalDamage(int baseMagicalDamage) {
		this.baseMagicalDamage = baseMagicalDamage;
	}

	public int getBasePhysicalDefense() {
		return basePhysicalDefense;
	}

	public void setBasePhysicalDefense(int basePhysicalDefense) {
		this.basePhysicalDefense = basePhysicalDefense;
	}

	public int getBaseMagicalDefense() {
		return baseMagicalDefense;
	}

	public void setBaseMagicalDefense(int baseMagicalDefense) {
		this.baseMagicalDefense = baseMagicalDefense;
	}
}
