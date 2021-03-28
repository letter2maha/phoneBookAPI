package com.java.contactbook.contactbookdemo.service;

import com.java.contactbook.contactbookdemo.entity.Organization;
import com.java.contactbook.contactbookdemo.entity.People;
import com.java.contactbook.contactbookdemo.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepository repository;

    public People updatePeople(People people){

        System.out.println(people.getPid());
        System.out.println(people.getPeopleName());
        System.out.println(people.getContactNo());
        System.out.println(people.getOrganization());

        People existingPeople =  repository.findById(people.getPid()).orElse(null);

        existingPeople.setPeopleName(people.getPeopleName());
        existingPeople.setContactNo(people.getContactNo());
        existingPeople.setOrganization(people.getOrganization());
        return repository.save(existingPeople);
    }

//   public People savePeople(People people){
//        return repository.save(people);
//   }
//
//   public List<People> getAllPeople(){
//       return  repository.findAll();
//   }
//
//   public People getPeopleByOrgID(int organizationId){
//       return repository.findById(organizationId).orElse(null);
//   }
//
//   public String deletePeople(int id){
//       repository.deleteById(id);
//       return "People Removed !!"+id;
//   }

//   public People updatePeople(People people){
//       People existingPeople =  repository.findById(people.getId()).orElse(null);
//
//       existingPeople.setName(people.getName());
//       existingPeople.setContactNumber(people.getContactNumber());
//       existingPeople.setOrganizationName(people.getOrganizationName());
//
//
//       return repository.save(existingPeople);
//   }

//   public List<Organization> getOrganization(){
//
//       Map<String, Long> orgMap = repository.findAll().
//               stream().map(val->val.getOrganizationName()).collect(Collectors.groupingBy(
//               Function.identity(),
//               Collectors.counting()));
//       return orgMap.entrySet().stream().map(val->new Organization(val.getKey(),
//               val.getValue())).collect(Collectors.toList());
//   }


}
