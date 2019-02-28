package com.vw.lead.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/v1/users")
public class UserAPI {
	
	  private final UserService userService;

	    @GetMapping
	    public ResponseEntity<List<User>> findAll() {
	        return ResponseEntity.ok(userService.findAll());
	    }

	    @GetMapping("/{userId}")
	    public ResponseEntity<User> findById(@PathVariable Long userId) {
	        Optional<User> userOptional = userService.findById(userId);
	        if (!userOptional.isPresent()) {
	            log.error("StockId " + userId + " is not existed");
	            ResponseEntity.badRequest().build();
	        }

	        return ResponseEntity.ok(userOptional.get());
	    }

	    @PostMapping
	    public ResponseEntity<User> create(@RequestBody User user) {
	        return ResponseEntity.ok(userService.save(user));
	    }

	    @PatchMapping("/{userId}")
	    public ResponseEntity<User> update(@PathVariable Long userId, @RequestBody User updatingUser) {
	        Optional<User> userOptional = userService.findById(userId);
	        if (!userOptional.isPresent()) {
	            log.error("UserID " + userId + " is not existed");
	            ResponseEntity.badRequest().build();
	        }
	        
	        User user = userOptional.get();
	        if (updatingUser.getComments() != null) updatingUser.setComments(updatingUser.getComments());

	        return ResponseEntity.ok(userService.save(user));
	    }

}
