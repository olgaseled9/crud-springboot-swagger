package by.seledtsovaos.swagger.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Container for UserDto representing data, getter and setter methods.
 * @see UserDto
 */
public class UserDto {

    @NotNull
    @NotEmpty
    private Long id;
    @NotNull
    @Size(min = 1, max = 30)
    private String firstname;
    @NotEmpty
    @Size(min = 1, max = 30)
    private String lastname;
    @NotEmpty
    @Size(min = 1, max = 30)
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
