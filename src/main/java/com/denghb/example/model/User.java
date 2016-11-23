package com.denghb.example.model;

import com.denghb.dbhelper.annotation.Column;
import com.denghb.dbhelper.annotation.Id;
import com.denghb.dbhelper.annotation.Table;

import java.util.Date;

/**
 * DDL
 * <pre>
 * CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `email` varchar(100) DEFAULT NULL COMMENT '邮件',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=329422 DEFAULT CHARSET=utf8
 * <pre>
 * @author DbHelper
 * @generateTime Sun Jul 03 21:10:35 CST 2016
 */
@Table(name="user",database="test")
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	/**  */
	@Id@Column(name="id")
	private Integer id;
	
	/** 年龄 */
	@Column(name="age")
	private Integer age;
	
	/** 姓名 */
	@Column(name="name")
	private String name;
	
	/** 邮件 */
	@Column(name="email")
	private String email;
	
	/** 手机号 */
	@Column(name="mobile")
	private String mobile;
	

	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getAge(){
		return age;
	}

	public void setAge(Integer age){
		this.age = age;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getMobile(){
		return mobile;
	}

	public void setMobile(String mobile){
		this.mobile = mobile;
	}

	@Override
	public String toString(){
		return "User [id=" + id +", age=" + age +", name=" + name +", email=" + email +", mobile=" + mobile +", ]";
	}
}