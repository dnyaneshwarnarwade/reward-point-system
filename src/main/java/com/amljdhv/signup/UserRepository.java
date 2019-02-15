package com.amljdhv.signup;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	
	
	 User findByEmail(String email);
	 
	 
	 /**
	  * 
	  * This method is used to get all the consumer list by `parentId` 
	  */
	 @Query(value = "select * from user u inner join user_consumer uc on uc.child_id = u.user_id where uc.parent_id =:parentId",
	            nativeQuery=true 
	   )
	 List<User> findAllConsumerById(@Param("parentId") long parentId);
	
}
