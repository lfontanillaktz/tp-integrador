package com.kaitzen.repository;

import com.kaitzen.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findAllByName(String name);

    //consulta HQL

    @Query("select c from Client c where c.name=?1")
    Client findClientByNmaeQueryHQL(String name);


}
