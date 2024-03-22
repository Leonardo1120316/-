package com.example.usercenter.model.domain.request.activity;

import com.example.usercenter.model.domain.Activity;
import lombok.Data;

import java.io.Serializable;

@Data
public class ActivityUpdateRequest implements Serializable {
    private static final long serialVersionUID = 7259182340182216302L;
    private Activity activity;
}