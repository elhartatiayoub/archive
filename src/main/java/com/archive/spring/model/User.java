package com.archive.spring.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="User")
public class User {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String email;
        
        private String pass;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        String original = pass;
        MessageDigest md = null;
        try{
	md = MessageDigest.getInstance("MD5");
        }catch(NoSuchAlgorithmException e){
                this.pass = pass;
                return;
                }
	md.update(original.getBytes());
	byte[] digest = md.digest();
	StringBuilder sb = new StringBuilder();
	for (byte b : digest) {
		sb.append(String.format("%02x", b & 0xff));
	}

        this.pass = sb.toString();
    }

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString(){
		return "id="+id+", name="+name+", email="+email;
	}
}
