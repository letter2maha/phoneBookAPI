package com.java.contactbook.contactbookdemo.service;

//import com.java.contactbook.contactbookdemo.dto.OrgDTO;
//import com.java.contactbook.contactbookdemo.dto.PeopleDTO;
//import com.java.contactbook.contactbookdemo.entity.OrgPeople;
import com.java.contactbook.contactbookdemo.entity.Organization;
//import com.java.contactbook.contactbookdemo.entity.People;
import com.java.contactbook.contactbookdemo.entity.People;
//import com.java.contactbook.contactbookdemo.repository.OrgPeopleRepository;
import com.java.contactbook.contactbookdemo.repository.OrganizationRepository;
//import com.java.contactbook.contactbookdemo.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {
    @Autowired
    OrganizationRepository repository;

//    @Autowired
//    OrgPeopleRepository orgPeopleRepository;

    public List<Organization> getAllOrganization(){
        return  repository.findAll() ;
    }
    public Organization saveOrganization(Organization org){
        return repository.save(org);
    }

    public Organization updateOrganization(Organization org){

        System.out.println(org.getOrgId());
        System.out.println(org.getOrgName());
        System.out.println(org.getEmail());
       Organization existingOrg =  repository.findById(org.getOrgId()).orElse(null);

        existingOrg.setOrgName(org.getOrgName());
        existingOrg.setEmail(org.getEmail());
       return repository.save(existingOrg);
   }

    public String deleteOrganazation(int id){
       repository.deleteById(id);
       return "Organization Removed !!"+id;
   }

//    public OrgDTO getOrgPeople(int orgId) {
//
//        Organization org = repository.findById(orgId).orElse(null);
//        List<OrgPeople> peoples= orgPeopleRepository.findAll();
//        OrgDTO orgDTO = new OrgDTO();
//        orgDTO.setOrgId(org.getOrgId());
//        orgDTO.setOrgName(org.getOrgName());
//        orgDTO.setOrgContact(org.getOrgContact());
//
//        List<PeopleDTO> peopleDTOList = new ArrayList<>();
//
//        for(OrgPeople people:peoples) {
//            PeopleDTO peopleDTO = new PeopleDTO();
//            peopleDTO.setName(people.getPeople().getName());
//            peopleDTOList.add(peopleDTO);
//        }
//        orgDTO.setPeoples(peopleDTOList);
//        System.out.println("People size: "+peoples.size());
//        return orgDTO;
//    }
}
