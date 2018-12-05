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
@Table(name="usertype")
public class UserTypeEntity extends BaseEntity{
	
	@Column
	private String name;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="userType",cascade = CascadeType.ALL)
	private Collection<UserEntity> user;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Collection<UserEntity> getUser() {
		return user;
	}

	public void setUser(Collection<UserEntity> user) {
		this.user = user;
	}

}
