package com.my.pro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User{
    private int id;//用户ID
    private String loginName;//用户名
    private String realName ;//用户姓名
    private String phone;//手机号
    private String passWord;//密码
    private int  isDelete; //0:不删除 1：删除
    
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

  
    public String getRealName() {
		return realName;
	}


	public void setRealName(String realName) {
		this.realName = realName;
	}


	public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    

	public String getPassWord() {
		return passWord;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	public String getLoginName() {
		return loginName;
	}


	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}


	public int getIsDelete() {
		return isDelete;
	}


	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}



    
   
}