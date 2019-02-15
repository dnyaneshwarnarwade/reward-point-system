package com.amljdhv.emailVerification;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailVerificationRepository extends JpaRepository<EmailVerification, Long>{
	public EmailVerification findByToken(String token);
}
