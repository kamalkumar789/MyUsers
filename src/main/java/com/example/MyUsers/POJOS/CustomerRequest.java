package com.example.MyUsers.POJOS;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("DOB")
    private String dob;
    @JsonProperty("Email")
    private String email;
    @JsonProperty("Cnic")
    private Long cnic;
}

