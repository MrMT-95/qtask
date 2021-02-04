package com.company.qtask.user;

import javax.validation.constraints.*;

public class UserLogin {

    @NotNull
    @NotEmpty
    @Size(min = 3,max=20)
    @Email(message = "Email is not valid!")
    String email;

    @NotNull
    @NotEmpty
    String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
