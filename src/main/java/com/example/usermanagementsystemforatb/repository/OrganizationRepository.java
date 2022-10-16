package com.example.usermanagementsystemforatb.repository;

import com.example.usermanagementsystemforatb.entity.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization,Long> {
    Organization getOrganizationByOrganizationId(String id);
}
