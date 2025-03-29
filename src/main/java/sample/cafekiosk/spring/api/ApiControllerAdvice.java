package sample.cafekiosk.spring.api;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.*;


@RestControllerAdvice
public class ApiControllerAdvice {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public ApiResponse<Object> bindException(BindException e) {
        return ApiResponse.of(
                BAD_REQUEST
                , e.getBindingResult().getAllErrors().get(0).getDefaultMessage()
                , null
        );
    }
}
