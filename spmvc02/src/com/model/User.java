package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

@Entity  
@Table(name = "user")  
public class User {  
    /** 
     * 用户id 必须有 无参数构造函数
     */  
    @Id  
    @Column(name = "id")  
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    private int id;  
      
    /** 
     * 用户名 (账户名)
     */  
    @NotEmpty
    @Column(name = "name", length = 50)  
    private String name;  
      
    /** 
     * 用户登录密码 
     */  
    @Column(name = "password", length = 50)  
    private String password;  
    /** 
     * 用户昵称
     */  
    @Column(name = "uname", length = 50)  
    private String uname; 
    /** 
     * 用户类型
     */  
    @Column(name = "utype", length = 50)  
    private String utype; 
    /** 
     * 用户权限
     */  
    @Column(name = "urole", length = 50)  
    private String urole; 
  



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




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getUname() {
		return uname;
	}




	public void setUname(String uname) {
		this.uname = uname;
	}




	public String getUtype() {
		return utype;
	}




	public void setUtype(String utype) {
		this.utype = utype;
	}




	public String getUrole() {
		return urole;
	}




	public void setUrole(String urole) {
		this.urole = urole;
	}




	public User(int id, String name, String password, String uname,
			String utype, String urole) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.uname = uname;
		this.utype = utype;
		this.urole = urole;
	}




	public User() {
	}
   
}
