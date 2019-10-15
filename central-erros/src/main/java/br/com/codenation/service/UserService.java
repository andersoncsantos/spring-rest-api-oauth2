package br.com.codenation.service;

import org.springframework.data.domain.Page;

import br.com.codenation.entity.User;

public interface UserService {

	public Page<User> findAll(int page, int size);
	public User create(User user);
	public boolean delete(Long id);
	public boolean existsUserByEmail(String email);
	
}
