package com.example.MyUsers.POJOS;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerValidateResp {

    private Integer id;
    private Long cnic;
    private HttpStatus status;
}
