package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class LevelMember {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String levmem,privilage;

	 @OneToOne(mappedBy = "levelmember")
	 private Member member;
	
//	public LevelMember() {
//		super();
//	}


//	public LevelMember(String levmem, String privilage) {
//		super();
//		this.levmem = levmem;
//		this.privilage = privilage;
//	}


	public int getLmid() {
		return id;
	}


	public void setLmid(int lmid) {
		this.id = lmid;
	}


	public String getLevmem() {
		return levmem;
	}


	public void setLevmem(String levmem) {
		this.levmem = levmem;
	}


	public String getPrivilage() {
		return privilage;
	}


	public void setPrivilage(String privilage) {
		this.privilage = privilage;
	}


	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}
	
	
}
