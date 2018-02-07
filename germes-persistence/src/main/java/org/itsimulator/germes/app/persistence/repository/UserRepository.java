package org.itsimulator.germes.app.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.itsimulator.germes.app.model.entity.person.User;

/**
 * Defines CRUD methods to access User objects in the persistent storage
 * @author Morenets
 *
 */
public interface UserRepository {
	/**
	 * Saves(creates or modifies) specified user instance
	 * @param city
	 */
	void save(User user);
	
	/**
	 * Returns user with specified identifier boxed into Optional
	 * @param cityId
	 * @return
	 */
	Optional<User> findById(int userId);
	
	/**
	 * Delete city with specified identifier
	 * @param cityId
	 */
	void delete(int userId);
	
	/**
	 * Returns all the cities
	 * @return
	 */
	List<User> findAll();

}
