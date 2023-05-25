package com.example.spring_day5_exercise.ApiException;

import com.example.spring_day5_exercise.ApiResponse.ApiResponse;
import org.hibernate.dialect.PostgreSQLStructPGObjectJdbcType;
import org.springframework.http.ResponseEntity;

public class ApiException extends RuntimeException  {

    public ApiException (String message){
        super(message);
    }
}
