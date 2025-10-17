package com.scm.entities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class userForm {
    @NotBlank(message = "Name is required")
    @Size(min = 3,max = 10 ,message = "Name should be in 3-10")
    private String name;
    @Email(message = "@gamil.com required")
    private String email;
    @Size(min = 8,message = "Password shoud be 8 characters")
    private String password;
    private String ph;
    private String about;
    
}
