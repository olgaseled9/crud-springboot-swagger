package by.seledtsovaos.swagger.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import by.seledtsovaos.swagger.model.User;

/**
 * Handles  all database operations with {@link User} object.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
