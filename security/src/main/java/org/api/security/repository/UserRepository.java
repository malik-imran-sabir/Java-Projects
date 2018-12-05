package org.api.security.repository;

import org.api.security.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fan.jin on 2016-10-15.
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findByUsername( String username );
}

