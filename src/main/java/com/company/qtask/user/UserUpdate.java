package com.company.qtask.user;

import javax.validation.constraints.*;

public class UserUpdate {

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 20)
    @Email(message = "Email is not valid!")
    String email;

    @Size(max = 25)
    String firstName;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,10}$", message = "Password is not valid!")
    String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
