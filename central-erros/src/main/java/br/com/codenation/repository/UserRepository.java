package br.com.codenation.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import br.com.codenation.entity.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	UserDetails findByEmail(String email);
	Page<User> findAll(Pageable pageable);
	boolean existsUserByEmail(String email);
}
