package by.seledtsovaos.swagger.controller.ui;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.seledtsovaos.swagger.dto.UserDto;
import by.seledtsovaos.swagger.service.UserService;

import static by.seledtsovaos.swagger.dto.UserDto.notEmptyString;

/**
 * Handles requests to do CRUD operation with {@link UserDto}.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        List<UserDto> users = userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/update")
    public String updateUser(UserDto userDto, Model model) {
        if (userDto.getId() != null) {
            userDto = userService.findById(userDto.getId());
            model.addAttribute("userDto", userDto);
        }
        return "update";
    }

    @PostMapping("/update")
    public String addOrUpdateUser(@ModelAttribute("userDto")
    @Valid UserDto userDto, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors() && notEmptyString(userDto)) {
            userService.create(userDto);
            return "redirect:/users/all";
        }
        else {
            return "update";
        }
    }

    @GetMapping("/remove")
    public String removeUserById(@RequestParam("id") Long id) {
        if (id != null) {
            userService.deleteById(id);
        }
        return "redirect:/users/all";
    }
}
