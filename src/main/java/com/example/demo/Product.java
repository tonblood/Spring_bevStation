package com.example.demo;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Product {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer pid;

  private String pname,ptype;
  private int amount;
  private double price;
  
  
  
  public Product() {
	super();
}



public Product(String pname, String ptype, int amount, double price) {
	super();
	this.pname = pname;
	this.ptype = ptype;
	this.amount = amount;
	this.price = price;
}



public Integer getPid() {
	return pid;
}



public void setPid(Integer pid) {
	this.pid = pid;
}



public String getPname() {
	return pname;
}



public void setPname(String pname) {
	this.pname = pname;
}



public String getPtype() {
	return ptype;
}



public void setPtype(String ptype) {
	this.ptype = ptype;
}



public int getAmount() {
	return amount;
}



public void setAmount(int amount) {
	this.amount = amount;
}



public double getPrice() {
	return price;
}



public void setPrice(double price) {
	this.price = price;
}
  
}