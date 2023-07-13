package com.web.futureroi.common.exception;

import com.web.futureroi.common.code.ApiCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BaseException extends Exception{
    private ApiCode status;
}
