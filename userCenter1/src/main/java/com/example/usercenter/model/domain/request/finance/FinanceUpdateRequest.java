package com.example.usercenter.model.domain.request.finance;

import com.example.usercenter.model.domain.Finance;
import lombok.Data;

import java.io.Serializable;

@Data
public class FinanceUpdateRequest implements Serializable {
    private static final long serialVersionUID = 7259182340182216302L;
    private Finance finance;
}
