package com.java.contactbook.contactbookdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class Organization {
//
//    private String orgName;
//    private Long count;
//}
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
//@Table (name = "Org_TBL")
public class Organization{
//    @Id
//    @GeneratedValue
//    private int orgId;
//    private String orgName;
//    private Long orgContact;
//
////    @OneToMany(mappedBy = "org")
////            (targetEntity = People.class, cascade = CascadeType.ALL)
////    @JoinColumn(name = "op_fk", referencedColumnName = "orgId")
//
////    private List<People> peoples;

    @Id
    @GeneratedValue
    private int orgId;
    private String orgName;
    private String email;
}
