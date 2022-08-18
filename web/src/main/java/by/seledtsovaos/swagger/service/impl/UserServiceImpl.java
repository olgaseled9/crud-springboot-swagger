package by.seledtsovaos.swagger.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.seledtsovaos.swagger.dao.UserRepository;
import by.seledtsovaos.swagger.dto.UserDto;
import by.seledtsovaos.swagger.exeption.ServiceException;
import by.seledtsovaos.swagger.exeption.UserNotFoundException;
import by.seledtsovaos.swagger.mapper.UserMapper;
import by.seledtsovaos.swagger.service.UserService;

/**
 * Implements interface {@link UserService} methods
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Transactional(readOnly = true)
    @Override
    public UserDto findById(Long id) {
        return userMapper.mapToDto(
            userRepository.findById(id)
                .orElseThrow(
                    () -> new UserNotFoundException(id)));
    }

    @Override
    public UserDto update(Long id, UserDto userDto) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        try {
            userRepository.deleteById(id);
        }
        catch (DataAccessException e) {
            throw new ServiceException("Cannot be removed user with id = " + id, e);
        }
    }

    @Override
    public void create(UserDto userDto) {
        try {
            userRepository.save(userMapper.mapToEntity(userDto));
        }
        catch (DataAccessException e) {
            throw new ServiceException("Not able to add new user : " + userDto, e);
        }
    }

    @Transactional(readOnly = true)
    public List<UserDto> findAll() {
        try {
            return userRepository.findAll().stream()
                .map(userMapper::mapToDto)
                .collect(Collectors.toList());
        }
        catch (DataAccessException e) {
            throw new ServiceException("Not able to get all users. ", e);
        }
    }
}
