package com.thoughtworks.capacity.gtb.mvc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer userId = 0;

    @Size(min = 5, max = 12, message = "用户名不合法")
    private String userName;

    @Pattern(regexp = "^[0-9a-zA-Z_]+$", message = "密码格式错误")
    @Size(min = 5, max = 12, message = "密码格式错误")
    private String password;

    @Email(message = "邮箱格式错误")
    private String emailAddress;
}
