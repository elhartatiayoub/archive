package com.archive.spring.model;


import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Image")
public class Image implements Serializable {
	public Image() {
	}
	
	@Column(name="ID", nullable=false)	
	@Id	
	@GeneratedValue(generator="MODEL_IMAGE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="MODEL_IMAGE_ID_GENERATOR", strategy="native")	
	private int ID;
	
	@Column(name="Title", nullable=true, length=255)	
	private String title;
	
	@Column(name="`Date`", nullable=true)	
	@Temporal(TemporalType.TIMESTAMP)	
	private java.util.Date date;
	
	@Column(name="Likes", nullable=false, length=10)	
	private int likes;
	
	@Column(name="Shares", nullable=false, length=10)	
	private int shares;
	
	@Column(name="Pravacy", nullable=true, length=255)	
	private String pravacy;
	
	@Column(name="Url", nullable=true, length=255)	
	private String url;
	
	@OneToMany(mappedBy="image", targetEntity=com.archive.spring.model.Comment.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set comment = new java.util.HashSet();
	
	@ManyToMany(targetEntity=com.archive.spring.model.Category.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Category_Image", joinColumns={ @JoinColumn(name="ImageID") }, inverseJoinColumns={ @JoinColumn(name="CategoryID") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set category = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setTitle(String value) {
		this.title = value;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setDate(java.util.Date value) {
		this.date = value;
	}
	
	public java.util.Date getDate() {
		return date;
	}
	
	public void setLikes(int value) {
		this.likes = value;
	}
	
	public int getLikes() {
		return likes;
	}
	
	public void setShares(int value) {
		this.shares = value;
	}
	
	public int getShares() {
		return shares;
	}
	
	public void setPravacy(String value) {
		this.pravacy = value;
	}
	
	public String getPravacy() {
		return pravacy;
	}
	
	public void setUrl(String value) {
		this.url = value;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setComment(java.util.Set value) {
		this.comment = value;
	}
	
	public java.util.Set getComment() {
		return comment;
	}
	
	
	public void setCategory(java.util.Set value) {
		this.category = value;
	}
	
	public java.util.Set getCategory() {
		return category;
	}
	
	
	public String toString() {
		return toString(false);
	}
	
	public String toString(boolean idOnly) {
		if (idOnly) {
			return String.valueOf(getID());
		}
		else {
			StringBuffer sb = new StringBuffer();
			sb.append("Image[ ");
			sb.append("ID=").append(getID()).append(" ");
			sb.append("Title=").append(getTitle()).append(" ");
			sb.append("Date=").append(getDate()).append(" ");
			sb.append("Likes=").append(getLikes()).append(" ");
			sb.append("Shares=").append(getShares()).append(" ");
			sb.append("Pravacy=").append(getPravacy()).append(" ");
			sb.append("Url=").append(getUrl()).append(" ");
			sb.append("Comment.size=").append(getComment().size()).append(" ");
			sb.append("Category.size=").append(getCategory().size()).append(" ");
			sb.append("]");
			return sb.toString();
		}
	}
	
}
