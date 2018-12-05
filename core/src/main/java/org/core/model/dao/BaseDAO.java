package org.core.model.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import org.core.model.entity.BaseEntity;

@NoRepositoryBean
public interface BaseDAO<E extends BaseEntity,I extends Serializable> {
	public E saveBaseDAO(E entity);
	public E findByIdAndStatus(Long id, String status);
	public Collection<E> findByStatus(String status);
	public void updateByIds(String status, Collection<Long> ids);
	public E findById(Long id);

}
