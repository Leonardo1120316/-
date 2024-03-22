package com.example.usercenter.model.domain.request.user;

import com.example.usercenter.model.domain.User;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserUpdateRequest implements Serializable {
    private static final long serialVersionUID = 7259182340182216302L;
    private User user;
}