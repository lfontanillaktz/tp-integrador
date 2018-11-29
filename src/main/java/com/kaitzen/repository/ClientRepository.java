package com.kaitzen.repository;


import com.kaitzen.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findAllByName(String name);

    //Consulta HQL
    @Query("select c from Client c where c.name = ?1")
    Client findClientByNameQueryHQL (String name);

    //Consulta SQL
    @Query(value="SELECT * FROM cliente WHERE name = :name", nativeQuery = true)
    Client findClienteByNameQuerySQL(@Param("name") String name);


}
