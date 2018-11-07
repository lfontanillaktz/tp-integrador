package com.kaitzen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kaitzen.model.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/* ESTE ENTENDS ME FACILITA HACER CONSULTAS SENCILLAS SIN HACER SQL NI HQL */

@Repository
public interface ClientRepository extends JpaRepository<Client,Long>{

    List<Client> findAllByName(String name);

    @Query("select c from Client c where c.name=?1")
    Client findClientByNameQueryHQL(String name);


    @Query(value="SELECT *FROM cliente WHERE name= :name", nativeQuery = true)
    Client findClientByNameQuerySQL(@Param("name") String name);

}
