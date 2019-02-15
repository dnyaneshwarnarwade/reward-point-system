package com.amljdhv.services;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;

import com.amljdhv.consumer.Consumer;

public interface ConsumerService {
	
	
	public List<Consumer> findAll();
	
	public Consumer save(Consumer consumer);

	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework.data.domain.Sort)
	 */
	List<Consumer> findAll(Sort sort);

	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#findAll(java.lang.Iterable)
	 */
	List<Consumer> findAllById(Iterable<Long> ids);
	
	List<Consumer> findAllByUserId(Long ids);

	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#save(java.lang.Iterable)
	 */
	<S extends Consumer> List<S> saveAll(Iterable<S> entities);

	/**
	 * Deletes the given entities in a batch which means it will create a single {@link Query}. Assume that we will clear
	 * the {@link javax.persistence.EntityManager} after the call.
	 *
	 * @param entities
	 */
	void deleteInBatch(Iterable<Consumer> entities) ;

	Consumer getOne(Long id) ;
	
	void delete(Consumer consumer);
	
	List<Consumer> searchConsumer(String searchString);

}
