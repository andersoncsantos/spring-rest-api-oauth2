package br.com.codenation.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.codenation.entity.User;
import br.com.codenation.service.UserServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@PostMapping("/users")
	@ApiOperation("create a new user")
	@ResponseBody
	public User create(@RequestBody User user) throws Exception{
		boolean userExists = this.userServiceImpl.existsUserByEmail(user.getEmail());
		if (userExists) {
			throw new Exception("user already exists!");
		}
		return this.userServiceImpl.create(user);
	}
	
	@GetMapping("/users")
    @ApiOperation("user list view")
	@ResponseBody
	public Page<User> findAll(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		return userServiceImpl.findAll(page, size);
	}

	@DeleteMapping("/users/{id}")
	@ApiOperation("user delete by id")
	public boolean delete(@PathVariable(value = "id") Long id) {
		return this.userServiceImpl.delete(id);
	}

}
