package com.java.contactbook.contactbookdemo.repository;

//import com.java.contactbook.contactbookdemo.dto.OrgDTO;
import com.java.contactbook.contactbookdemo.dto.ResponseDTO;
import com.java.contactbook.contactbookdemo.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

//    @Query("SELECT new com.java.contactbook.contactbookdemo.dto.OrgDTO(o.orgId, o.orgName, o.orgContact, p.id) FROM Organization o JOIN o.peoples p")
//    public List<OrgDTO> getJoinInformation();


    @Query("SELECT new com.java.contactbook.contactbookdemo.dto.ResponseDTO(o.orgName , p.peopleName) FROM People p JOIN p.organization o")
    public List<ResponseDTO> getJoinInformation();


//    @Query("SELECT new com.java.contactbook.contactbookdemo.dto.ResponseDTO(o.orgId, o.orgName, o.email, o.pid, p.peopleName, p.contactNo) FROM People p JOIN p.organization o")
//    public List<ResponseDTO> getJoinAllTable();

}
