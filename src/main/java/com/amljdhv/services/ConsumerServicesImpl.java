package com.amljdhv.services;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.amljdhv.consumer.Consumer;
import com.amljdhv.consumer.ConsumerRepository;

@Service("consumerService")
//@Transactional
public class ConsumerServicesImpl  implements ConsumerService{
	
	@Autowired
	private ConsumerRepository consumerRepository;
	
	@Override
	public List<Consumer> findAll(){
		return consumerRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework.data.domain.Sort)
	 */
	@Override
	public List<Consumer> findAll(Sort sort){
		return consumerRepository.findAll(sort);
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#findAll(java.lang.Iterable)
	 */
	@Override
	public List<Consumer> findAllById(Iterable<Long> ids){
		return consumerRepository.findAllById(ids);
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#save(java.lang.Iterable)
	 */
	@Override
	public <S extends Consumer> List<S> saveAll(Iterable<S> entities){
		return consumerRepository.saveAll(entities);
	}

	/**
	 * Deletes the given entities in a batch which means it will create a single {@link Query}. Assume that we will clear
	 * the {@link javax.persistence.EntityManager} after the call.
	 *
	 * @param entities
	 */
	@Override
	public void deleteInBatch(Iterable<Consumer> entities) {
		consumerRepository.deleteInBatch(entities);
	}

	@Override
	public Consumer getOne(Long id) {
		return consumerRepository.getOne(id);
	}

	@Override
	public List<Consumer> findAllByUserId(Long id) {
		return consumerRepository.findAllConsumerByUserId(id);
	}
 
	@Override
	public Consumer save(Consumer consumer) {
		return consumerRepository.save(consumer);
	}

	@Override
	public void delete(Consumer consumer) {
		consumerRepository.delete(consumer);
	}

	@Override
	public List<Consumer> searchConsumer(String searchString) {
		return consumerRepository.searchConsumer(searchString);
	}
	
}
