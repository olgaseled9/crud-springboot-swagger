package by.seledtsovaos.swagger.service;

import java.util.List;

import by.seledtsovaos.swagger.dto.UserDto;

/**
 * Provides the methods to interact with representing {@link UserDto} data.
 */
public interface UserService {

    void create(UserDto userDto);

    List<UserDto> findAll();

    UserDto findById(Long id);

    UserDto update(Long id, UserDto userDto);

    void deleteById(Long id);
}
