package com.jb.rickAndMor.Exeptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum CustomExceptions {


    DONE_EXISTS("cant find data",HttpStatus.BAD_REQUEST);
    private HttpStatus httpStatus;
    private String msg;

    CustomExceptions(String msg,HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.msg = msg;
    }
}
