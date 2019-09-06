package com.springrest.project.springrestservices;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJPAResource {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/jpa/users")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public Optional<User> getUser(@PathVariable int id) {
		Optional<User> user= userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id-"+id);
		}
		return user;
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		User saveUser=userRepository.save(user);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(saveUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/jpa/users")
	public ResponseEntity<Object> updateUser(@Valid @RequestBody User user) {
		User saveUser=userRepository.save(user);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(saveUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}
	
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> getUserPost(@PathVariable int id) {
		Optional<User> user= userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id-"+id);
		}
		return user.get().getPosts();
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> savePost(@PathVariable int id,@RequestBody Post post ) {
		Optional<User> user= userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("id-"+id);
		}
		User user1=user.get();
		post.setUser(user1);
		postRepository.save(post);
		
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(post.getId()).toUri();
		return ResponseEntity.created(location).build();
	}


}
