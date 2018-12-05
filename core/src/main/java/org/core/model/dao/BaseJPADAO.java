package org.core.model.dao;

import java.io.Serializable;
import java.util.Collection;

import org.core.model.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseJPADAO<E extends BaseEntity,I extends Serializable> extends BaseDAO<E,I>, JpaRepository<E, I> {

	//public E save(E entity);
	public E findByIdAndStatus(Long id, String status);
	public Collection<E> findByStatus(String status);
	
	@Modifying
	@Query(value="UPDATE #{#entityName} SET STATUS=?1 where id IN(?2)")
	public void updateByIds(String status, Collection<Long> ids);


}
	
