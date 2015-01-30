
package com.archive.spring.model;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="`User`")
public class User implements Serializable {
	public User() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof User))
			return false;
		User user = (User)aObj;
		if ((getEmail() != null && !getEmail().equals(user.getEmail())) || (getEmail() == null && user.getEmail() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (getEmail() == null ? 0 : getEmail().hashCode());
		return hashcode;
	}
	
	@Column(name="Email", nullable=false)	
	@Id	
	private String email;
	
	@ManyToOne(targetEntity=com.archive.spring.model.Role.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="RoleID", referencedColumnName="ID", nullable=false) })	
	private com.archive.spring.model.Role role;
	
	@Column(name="Name", nullable=true, length=255)	
	private String name;
	
	@Column(name="PassHash", nullable=true, length=255)	
	private String passHash;
	
	@OneToMany(targetEntity=com.archive.spring.model.Image.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="UserEmail", nullable=false) })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set images = new java.util.HashSet();
	
	@OneToMany(mappedBy="user", targetEntity=com.archive.spring.model.Comment.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set comment = new java.util.HashSet();
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getORMID() {
		return getEmail();
	}
	
	public void setPassHash(String value) {
		this.passHash = value;
	}
	
	public String getPassHash() {
		return passHash;
	}
	
	public void setRole(com.archive.spring.model.Role value) {
		this.role = value;
	}
	
	public com.archive.spring.model.Role getRole() {
		return role;
	}
	
	public void setImages(java.util.Set value) {
		this.images = value;
	}
	
	public java.util.Set getImages() {
		return images;
	}
	
	
	public void setComment(java.util.Set value) {
		this.comment = value;
	}
	
	public java.util.Set getComment() {
		return comment;
	}
	
	
	public String toString() {
		return toString(false);
	}
	
	public String toString(boolean idOnly) {
		if (idOnly) {
			return String.valueOf(getEmail());
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("User[ ");
			sb.append("Email=").append(getEmail()).append(" ");
			if (getRole() != null)
				sb.append("Role.Persist_ID=").append(getRole().toString(true)).append(" ");
			else
				sb.append("Role=null ");
			sb.append("Name=").append(getName()).append(" ");
			sb.append("PassHash=").append(getPassHash()).append(" ");
			sb.append("Images.size=").append(getImages().size()).append(" ");
			sb.append("Comment.size=").append(getComment().size()).append(" ");
			sb.append("]");
			return sb.toString();
		}
	}
	
	@Transient	
	private boolean _saved = false;
	
	public void onSave() {
		_saved=true;
	}
	
	
	public void onLoad() {
		_saved=true;
	}
	
	
	public boolean isSaved() {
		return _saved;
	}
	
	
}
