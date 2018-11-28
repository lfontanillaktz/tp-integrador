package com.kaitzen.repository;

import com.kaitzen.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findAllByNameIgnoreCase(String name);

    @Query("select c from Client c where c.name = ?1")
    Client findClientByNameQueryHQL(String name);

    @Query(value="SELECT * FROM cliente WHERE name = :name", nativeQuery = true)
    Client findClientByNameQuerySQL(@Param("name") String name);

    @Query("select c from Client c where c.id = ?1")
    Client findByIdQueryHQL(Long id);

    @Query(value="SELECT * FROM cliente WHERE id = :id", nativeQuery = true)
    Client findByIdQuerySQL(@Param("id") Long id);

}