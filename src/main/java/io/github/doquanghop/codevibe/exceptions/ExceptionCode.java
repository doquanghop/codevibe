package io.github.doquanghop.codevibe.exceptions;

import org.springframework.http.HttpStatus;

public interface ExceptionCode {
    Integer getCode();

    String getType();

    default HttpStatus getHttpStatus() {
        HttpStatus status = HttpStatus.resolve(getCode());
        return status != null ? status : HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
