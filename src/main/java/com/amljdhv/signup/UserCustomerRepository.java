package com.amljdhv.signup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userConsumerRepository")
public interface UserCustomerRepository extends JpaRepository<UserConsumer, Long>{
	
}
