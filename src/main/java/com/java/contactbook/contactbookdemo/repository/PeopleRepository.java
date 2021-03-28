package com.java.contactbook.contactbookdemo.repository;

import com.java.contactbook.contactbookdemo.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PeopleRepository extends JpaRepository<People, Integer> {

}
