package com.kaitzen.Repository;

import com.kaitzen.Modelos.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findAllByName(String name);

    //consulta HQL
    @Query("select c from Client c where c.name = ?1") //aca va Client porque HQL usa consulta sobre objetos
    Client finClientByNameQueryHQL(String name);

    //consulta SQL
    @Query(value= "SELECT * FROM cliente WHERE nombre= :name",nativeQuery=true) // se usa el cliente definido en la BD (SQL normal)
    Client findClientByNameQuerySQL(@Param("name") String name);
}
