package com.example.usercenter.model.domain.request.finance;

import lombok.Data;

import java.io.Serializable;

@Data
public class FinanceSearchRequest implements Serializable {
    private static final long serialVersionUID = 7259182340182216302L;
    private long id;
}
