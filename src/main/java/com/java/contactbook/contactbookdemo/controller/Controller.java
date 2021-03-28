package com.java.contactbook.contactbookdemo.controller;

import com.java.contactbook.contactbookdemo.dto.PeopleDTO;
import com.java.contactbook.contactbookdemo.dto.ResponseDTO;
import com.java.contactbook.contactbookdemo.entity.Organization;
import com.java.contactbook.contactbookdemo.entity.People;
import com.java.contactbook.contactbookdemo.repository.OrganizationRepository;
import com.java.contactbook.contactbookdemo.repository.PeopleRepository;
import com.java.contactbook.contactbookdemo.service.OrganizationService;
import com.java.contactbook.contactbookdemo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class Controller {
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private PeopleRepository peopleRepository;

    @PostMapping("/addPeople")
    public People addPeople(@RequestBody PeopleDTO request){
       return peopleRepository.save(request.getPeople());
    }

    @PostMapping("/addOrganization")
    public Organization addOrg(@RequestBody Organization cust){
        return organizationRepository.save(cust);
    }

    @GetMapping("/getAllOrganization")
    public List<Organization> getAllOrg(){
        return organizationRepository.findAll();
    }

    @GetMapping("/getAllPeople")
    public List<People> getAllPeople(){
        return peopleRepository.findAll();
    }
    @GetMapping("/getInfo")
    public List<ResponseDTO> getJoinInformation(){
        return organizationRepository.getJoinInformation();
    }


    @GetMapping("/getPeopleByOrgId/{id}")
    public List<People> getAllPeopleByOrgId(@PathVariable int id){
        List<People> peoples= peopleRepository.findAll();
        List<People> filteredPeople = new ArrayList<>();
        for(People people: peoples){
            if(people.getOrganization().getOrgId() ==id){
                filteredPeople.add(people);
            }
        }
        return filteredPeople;
    }


    @DeleteMapping("/deletePeople/{id}")
    public String deletePeople(@PathVariable int id){
        peopleRepository.deleteById(id);
        return "People Removed from Contact";
    }

    @DeleteMapping("/deletePeopledByOrg/{id}")
    public String deletePeopleByOrg(@PathVariable int id){
        List<People> peoples= peopleRepository.findAll();
        int count=0;
        for(People people: peoples){
            if(people.getOrganization().getOrgId() ==id){
                peopleRepository.delete(people);
                count ++;
            }
        }
        return count+" people removed!";
    }

    @DeleteMapping("/deleteOrg/{id}")
    public String deleteOrg(@PathVariable int id){
        organizationRepository.deleteById(id);
        return "Organization Removed!";
    }

    @Autowired
    OrganizationService orgService;
    @PostMapping("/orgUpdate")
    public Organization updateOrg(@RequestBody Organization org){
        return orgService.updateOrganization(org);
    }

    @Autowired
    PeopleService peopleService;
    @PostMapping("/peopleUpdate")
    public People updatePeople(@RequestBody People people){
        return peopleService.updatePeople(people);
    }
}
