package com.java.contactbook.contactbookdemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ResponseDTO {

    private String name;
    private String peopleName;

    public ResponseDTO(String name, String peopleName) {
        this.name = name;
        this.peopleName = peopleName;
    }
//
//    private int count;


    private int orgId;
    private String orgName;
    private String email;
    private int pid;

//    private String peopleName;
    private String contactNo;
}
