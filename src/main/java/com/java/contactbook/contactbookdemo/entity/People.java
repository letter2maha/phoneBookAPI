package com.java.contactbook.contactbookdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
//@Table(name = "PEOPLE_TBL")
public class People {
//    @Id
//    @GeneratedValue
//    private int id;
//    private String name;
//    private Long contactNumber;
//
////    private String orgName;
//
////    @ManyToOne
////    @JoinColumn(name="orgId")
////    private Organization org;

    @Id
    @GeneratedValue
    private int pid;
    private String peopleName;
    private String contactNo;

    @ManyToOne(targetEntity = Organization.class)
    @JoinColumn(name ="og_fk")
    private Organization organization;
    

}
