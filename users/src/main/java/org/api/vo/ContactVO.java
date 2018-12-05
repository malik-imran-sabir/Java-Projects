package org.api.vo;

import java.util.Collection;

import org.core.vo.BaseVO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ContactVO extends BaseVO{
	private long id;
	
	private String contact;
	
	private long contactTypeId;
	
	private long  userId;

	private Collection<ContactVO> contacts;
	
	
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

	public Collection<ContactVO> getContacts() {
		return contacts;
	}

	public void setContacts(Collection<ContactVO> contacts) {
		this.contacts = contacts;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
