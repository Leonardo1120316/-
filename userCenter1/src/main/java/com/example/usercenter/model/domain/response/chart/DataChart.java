package com.example.usercenter.model.domain.response.chart;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DataChart implements Serializable {
    private static final long serialVersionUID = 7259182340182216302L;
    private List<String> clubList;
}
