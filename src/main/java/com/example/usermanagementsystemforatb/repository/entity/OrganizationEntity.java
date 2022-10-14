package com.example.usermanagementsystemforatb.repository.entity;

import com.example.usermanagementsystemforatb.repository.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  OrganizationEntity extends JpaRepository<Organization,Long> {
    Organization getOrganizationByOrganizationId(String id);
}
