package samworks.usermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import samworks.usermanagement.entity.UserEntity;
import samworks.usermanagement.repo.UserRepository;

@Component
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<UserEntity> getAllUsers()

	{
		return repo.findAll();
	}

	public UserEntity getUserById(int id) {
		return repo.getOne(id);
	}

	public UserEntity updateUser(UserEntity usr) {

		UserEntity savedUser= repo.save(usr);
		return savedUser;
	}
	
	public UserEntity createUser(UserEntity usr) {
		
		UserEntity createUser=  repo.save(usr);
		return createUser;
	}
	
	public void deleteUser(int id) {
		repo.deleteById(id);
	}
	
}
