package by.seledtsovaos.swagger.controller.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import by.seledtsovaos.swagger.dto.UserDto;
import by.seledtsovaos.swagger.service.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * Handles requests to do CRUD operation with {@link UserDto}.
 */
@RestController
@RequestMapping("/api")
public class UserRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);
    private final UserServiceImpl userService;

    @Autowired
    public UserRestController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get all users.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "All users successfully found.",
            content = {@Content(mediaType = "application/json",
                schema = @Schema(implementation = UserDto.class))}),
        @ApiResponse(responseCode = "400", description = "Invalid data supplied or bad request.",
            content = @Content),
        @ApiResponse(responseCode = "404", description = "Users not found.",
            content = @Content)})
    public List<UserDto> getAll() {
        return userService.findAll();
    }

    @PostMapping("/add")
    @Operation(summary = "Add a new user.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User successfully added.",
            content = {@Content(mediaType = "application/json",
                schema = @Schema(implementation = UserDto.class))}),
        @ApiResponse(responseCode = "400", description = "Invalid data supplied or bad request.",
            content = @Content),
        @ApiResponse(responseCode = "404", description = "User not added",
            content = @Content)})
    public ResponseEntity<Void> add(@RequestBody UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            LOGGER.error("Cannot add a new user.");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else {
            userService.create(userDto);
            LOGGER.error("Successfully added a new user.");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @GetMapping(value = "users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get a user by its id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Found the user",
            content = {@Content(mediaType = "application/json",
                schema = @Schema(implementation = UserDto.class))}),
        @ApiResponse(responseCode = "400", description = "Invalid id supplied",
            content = @Content),
        @ApiResponse(responseCode = "404", description = "User not found",
            content = @Content)})
    public ResponseEntity<UserDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a user by its id.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User successfully deleted.",
            content = {@Content(mediaType = "application/json",
                schema = @Schema(implementation = UserDto.class))}),
        @ApiResponse(responseCode = "400", description = "Invalid id supplied or bad request.",
            content = @Content),
        @ApiResponse(responseCode = "404", description = "User not deleted",
            content = @Content)})
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    @Operation(summary = "Update a user by its id.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User successfully updated.",
            content = {@Content(mediaType = "application/json",
                schema = @Schema(implementation = UserDto.class))}),
        @ApiResponse(responseCode = "400", description = "Invalid id supplied or bad request.",
            content = @Content),
        @ApiResponse(responseCode = "404", description = "User not updated",
            content = @Content)})
    public ResponseEntity<Void> updateUser(@RequestBody UserDto newUser, @PathVariable Long id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            LOGGER.error("Cannot update a user.");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else {
            UserDto userDtoToUpdate = userService.findById(id);
            userDtoToUpdate.setFirstname(newUser.getFirstname());
            userDtoToUpdate.setLastname(newUser.getLastname());
            userDtoToUpdate.setPatronymic(newUser.getPatronymic());
            userService.create(userDtoToUpdate);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
