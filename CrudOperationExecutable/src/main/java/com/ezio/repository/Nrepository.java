package com.ezio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ezio.model.Nmodel;

@Repository
public interface Nrepository extends JpaRepository<Nmodel, Long>
{

}
