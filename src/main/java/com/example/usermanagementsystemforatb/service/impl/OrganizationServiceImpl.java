package com.example.usermanagementsystemforatb.service.impl;

import com.example.usermanagementsystemforatb.repository.OrganizationRepository;
import com.example.usermanagementsystemforatb.entity.model.Organization;
import com.example.usermanagementsystemforatb.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrganizationServiceImpl  implements OrganizationService {

    @Autowired
    OrganizationRepository organizationEntity;



    @Override
    public void saveOrganizationToDb(Organization organization) {

        organizationEntity.save(organization);

    }






}