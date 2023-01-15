package com.example.safebackend.repo;

import com.example.safebackend.model.Passwort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SafeRepo extends CrudRepository<Passwort,Integer> {
}
