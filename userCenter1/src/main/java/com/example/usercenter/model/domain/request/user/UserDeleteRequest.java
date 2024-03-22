package com.example.usercenter.model.domain.request.user;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
public class UserDeleteRequest implements Serializable {
    private static final long serialVersionUID = 7259182340182216302L;
    private long id;
}