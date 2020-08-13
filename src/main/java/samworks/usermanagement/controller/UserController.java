package samworks.usermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import samworks.usermanagement.entity.*;
import samworks.usermanagement.service.UserService;
@RestController
@RequestMapping(value = "/User")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping(value="/getAllUsers")
	public List<UserEntity> getAll()
	{
		List<UserEntity> obj = userService.getAllUsers();
		return obj;
	}
	
	
	@PostMapping(value ="/saveUser")
	public UserEntity saveUser(@RequestBody UserEntity usr)
	{
		UserEntity obj1 = userService.createUser(usr);
		return obj1;	
	}
	
	
	@GetMapping(value = "/getUser/{id}")
	public UserEntity getUser(@PathVariable int id)
	{
		UserEntity obj2 = userService.getUserById(id);
		return obj2;
	}
	
	
	@PutMapping(value="/updateUser")
	public UserEntity updateUser( @RequestBody UserEntity usr)
	{
		UserEntity obj3 = userService.updateUser(usr);
		return obj3;
	}
	
	
	@DeleteMapping(value = "/deleteUser/{id}")
	public void deleteUser(@PathVariable int id)
	{
		userService.deleteUser(id);
	}
	
	@GetMapping(value = "/getUserNameByID/{id}")
	public String getUserNameById(@PathVariable int id)
	{
		UserEntity obj2 = userService.getUserById(id);
		return obj2.getFname() +" "+obj2.getLname();
	}
	
}
