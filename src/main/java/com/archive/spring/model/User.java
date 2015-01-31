
package com.archive.spring.model;


import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="`User`")
@IdClass(UserPK.class)
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
		if (getID() != user.getID())
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (getEmail() == null ? 0 : getEmail().hashCode());
		hashcode = hashcode + (int) getID();
		return hashcode;
	}
	
	@Column(name="Email", nullable=false)	
	@Id	
	private String email;
	
	@Column(name="ID", nullable=false)	
	@Id	
	@GeneratedValue(generator="MODEL_USER_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODEL_USER_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@ManyToOne(targetEntity=com.archive.spring.model.Role.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="RoleID", referencedColumnName="ID", nullable=false) })	
	private com.archive.spring.model.Role role;
	
	@Column(name="Name", nullable=true, length=255)	
	private String name;
	
	@Column(name="PassHash", nullable=true, length=255)	
	private String password;
	
	@Column(name="Website", nullable=true, length=255)	
	private String website;
	
	@Column(name="Avatar", nullable=true, length=255)	
	private String avatar;
	
	@Column(name="Description", nullable=true, length=255)	
	private String description;
	
	@OneToMany(targetEntity=com.archive.spring.model.Image.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="UserEmail", nullable=false), @JoinColumn(name="UserID", nullable=false) })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.EXTRA)	
	private java.util.Set images = new java.util.HashSet();
	
	@OneToMany(mappedBy="user", targetEntity=com.archive.spring.model.Comment.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.EXTRA)	
	private java.util.Set comment = new java.util.HashSet();
	
	public void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
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
	
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setWebsite(String value) {
		this.website = value;
	}
	
	public String getWebsite() {
		return website;
	}
	
	public void setAvatar(String value) {
		this.avatar = value;
	}
	
	public String getAvatar() {
		return avatar;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
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
			return String.valueOf(getEmail() + " " + getID());
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("User[ ");
			sb.append("Email=").append(getEmail()).append(" ");
			sb.append("ID=").append(getID()).append(" ");
			if (getRole() != null)
				sb.append("Role.Persist_ID=").append(getRole().toString(true)).append(" ");
			else
				sb.append("Role=null ");
			sb.append("Name=").append(getName()).append(" ");
			sb.append("PassHash=").append(getPassword()).append(" ");
			sb.append("Website=").append(getWebsite()).append(" ");
			sb.append("Avatar=").append(getAvatar()).append(" ");
			sb.append("Description=").append(getDescription()).append(" ");
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
}
