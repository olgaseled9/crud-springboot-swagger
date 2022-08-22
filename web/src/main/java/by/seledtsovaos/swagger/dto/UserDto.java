package by.seledtsovaos.swagger.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Container for UserDto representing data, getter and setter methods.
 * @see UserDto
 */
public class UserDto {

    private Long id;
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 30)
    @Pattern(regexp = "[A-Za-zА-Яа-яЁё\\s-]*", message = "Only the Latin and Russian alphabet must be used")
    private String firstname;
    @NotEmpty
    @Size(min = 1, max = 30)
    @Pattern(regexp = "[A-Za-zА-Яа-яЁё\\s-]*", message = "Only the Latin and Russian alphabet must be used")
    private String lastname;
    @NotEmpty
    @NotNull
    @Size(min = 1, max = 30)
    @Pattern(regexp = "[A-Za-zА-Яа-яЁё\\s-]*", message = "Only the Latin and Russian alphabet must be used")
    private String patronymic;

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    /**
     * Checks that a string does not contain only spaces.
     * @param userDto object whose fields are being checked
     * @return true if at least one non-whitespace character is contained
     */
    public static boolean notEmptyString(UserDto userDto) {
        return !userDto.getFirstname().trim().isEmpty()
            && !userDto.getLastname().trim().isEmpty()
            && !userDto.getPatronymic().trim().isEmpty();
    }

    @Override
    public String toString() {
        return "UserDto{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", patronymic='" + patronymic + '\'' +
            '}';
    }
}
