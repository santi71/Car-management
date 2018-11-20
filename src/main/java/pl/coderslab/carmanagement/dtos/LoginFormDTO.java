package pl.coderslab.carmanagement.dtos;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginFormDTO {
    @NotNull @NotBlank @Size(min = 8, max = 12)
    private String login;
    @NotNull @NotBlank
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
