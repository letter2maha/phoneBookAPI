package com.java.contactbook.contactbookdemo.dto;


import com.java.contactbook.contactbookdemo.entity.People;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PeopleDTO {

    private People people;
}
