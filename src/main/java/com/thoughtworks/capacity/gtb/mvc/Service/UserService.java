package com.thoughtworks.capacity.gtb.mvc.Service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.thoughtworks.capacity.gtb.mvc.ErrorException.UserExistErrorException;
import com.thoughtworks.capacity.gtb.mvc.ErrorException.UserLoginErrorException;
import com.thoughtworks.capacity.gtb.mvc.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Map<String, User> userMap = new HashMap<>();

    @JsonIgnoreProperties(value = {"userId", "emailAddress"})
    public UserService() {
        String userOneName = "user1";
        String userOnePwd = "fdjfk3";
        String userOneEmail = "fjdksa@mail.com";

        String userTwoName = "user2";
        String userTwoPwd = "userpwd2";
        String userTwoEmail = "user2@mail.com";

        userMap.put(userOneName, new User(1, userOneName, userOnePwd, userOneEmail));
        userMap.put(userTwoName, new User(2, userTwoName, userTwoPwd, userTwoEmail));
    }

    public ResponseEntity<Void> creatUser(User user) {
        if (userMap.containsKey(user.getUserName())) {
            throw new UserExistErrorException("用户已存在");
        } else {
            int userId = generateUserId(userMap.size());
            user.setUserId(userId);
            userMap.put(user.getUserName(), user);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public int generateUserId(int size) {
        return size + 1;
    }

    public User getUserByUserName(String userName) {
        return userMap.get(userName);
    }

    public User validateUser(User user) {
        if (userMap.containsKey(user.getUserName())) {
            User tmp = userMap.get(user.getUserName());
            if (!tmp.getPassword().equals(user.getPassword())) {
                throw new UserLoginErrorException("用户名或密码错误");
            } else {
                return getUserByUserName(user.getUserName());
            }
        } else {
            throw new UserLoginErrorException("用户名或密码错误");
        }
    }
}
