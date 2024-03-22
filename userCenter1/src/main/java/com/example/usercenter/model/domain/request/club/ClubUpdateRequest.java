package com.example.usercenter.model.domain.request.club;

import com.example.usercenter.model.domain.Club;
import com.example.usercenter.model.domain.User;
import lombok.Data;

import java.io.Serializable;

@Data
public class ClubUpdateRequest implements Serializable {
    private static final long serialVersionUID = 7259182340182216302L;
    private Club club;
}