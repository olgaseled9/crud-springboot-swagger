package by.seledtsovaos.swagger.mapper;

import org.mapstruct.Mapper;

import by.seledtsovaos.swagger.dto.UserDto;
import by.seledtsovaos.swagger.model.User;

/**
 * Converts a container of User entity data {@link User}
 * into a container for representing data {@link UserDto}.
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto mapToDto(User user);

    User mapToEntity(UserDto userDto);

}
