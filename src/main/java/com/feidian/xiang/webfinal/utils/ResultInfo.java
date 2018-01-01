package com.feidian.xiang.webfinal.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResultInfo {
    boolean isSuccess;
    String resultCode;

    public ResultInfo(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
}
