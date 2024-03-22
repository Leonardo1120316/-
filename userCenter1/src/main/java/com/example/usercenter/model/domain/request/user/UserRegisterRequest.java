package com.example.usercenter.model.domain.request.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRegisterRequest implements Serializable {
    private static final long serialVersionUID = 7259182340182216302L;
    private String userAccount;
    private String userPassword;
    private String checkPassword;
}
