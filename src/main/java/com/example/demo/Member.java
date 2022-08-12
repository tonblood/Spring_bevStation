package com.example.demo;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity // This tells Hibernate to make a table out of this class
public class Member {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String fname,lname,sex,tel;
  
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "levelid", referencedColumnName = "id")
  private LevelMember levelmember;
  
  
  public Member() {
	super();
}

public Member(String fname, String lname, String sex, String tel) {
	super();
	this.fname = fname;
	this.lname = lname;
	this.sex = sex;
	this.tel = tel;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getFname() {
	return fname;
}

public void setFname(String fname) {
	this.fname = fname;
}

public String getLname() {
	return lname;
}

public void setLname(String lname) {
	this.lname = lname;
}

public String getSex() {
	return sex;
}

public void setSex(String sex) {
	this.sex = sex;
}

public String getTel() {
	return tel;
}

public void setTel(String tel) {
	this.tel = tel;
}

public LevelMember getLevelmember() {
	return levelmember;
}

public void setLevelmember(LevelMember levelmember) {
	this.levelmember = levelmember;
}


  
}