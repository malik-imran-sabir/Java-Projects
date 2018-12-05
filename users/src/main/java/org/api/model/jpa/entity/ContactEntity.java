package org.api.model.jpa.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.core.model.entity.BaseEntity;

@Entity
@Table(name="contact")
public class ContactEntity extends BaseEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;

	@Column
	private long contactTypeId;
	
	@Column
	private long  userId;
	
	@Column
	private String contact;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="contact",cascade = CascadeType.ALL)
	private Collection<ContactTypeEntity> contactTypes;

	
	public Collection<ContactTypeEntity> getContactTypes() {
		return contactTypes;
	}

	public void setContactTypes(Collection<ContactTypeEntity> contactTypes) {
		this.contactTypes = contactTypes;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public long getContactTypeId() {
		return contactTypeId;
	}

	public void setContactTypeId(long contactTypeId) {
		this.contactTypeId = contactTypeId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
}
