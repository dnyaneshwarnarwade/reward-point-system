package com.amljdhv.consumer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ConsumerRepository extends JpaRepository<Consumer, Long>{
	
	/**
	 * This parentId considered as userId belong to the admin user
	 * @param parentId
	 * @return
	 */
	List<Consumer> findAllConsumerByUserId(Long parentId);
	
	@Query("SELECT u FROM Consumer u WHERE u.searchString LIKE '%' || :searchString || '%'")
	List<Consumer> searchConsumer(String searchString);
}
