package com.crud.crudapp.repository;

import com.crud.crudapp.models.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Integer> {
}
