//package com.bookstore.repository;
//
//import java.util.List;
//
//import org.springframework.data.repository.CrudRepository;
//
//import com.bookstore.domain.User;
//
//public interface UserRepository extends CrudRepository<User,Long> {
//
//	User findByUsername(String username);//search method
//	User findByEmail(String email);
//	List<User> findAll();
//}//spring help us generate concrete class by the time Spring runs


package com.bookstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByUsername(String username);
	User findByEmail(String email);
	List<User> findAll();
}
