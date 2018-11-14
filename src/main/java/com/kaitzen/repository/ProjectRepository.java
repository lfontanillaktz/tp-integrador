package com.kaitzen.repository;

import com.kaitzen.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.kaitzen.model.Client;
import java.util.Date;
import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
    List<Project> findAllByName(String name);
    List<Project> findAllByStartDateIsBetween(Date stDate, Date edDate);

    @Query("select c from Client c where c.name = ?1")
    Client findClientByNameQueryHQL(String name);

    @Query(value="SELECT * FROM cliente WHERE name = :name",nativeQuery = true)
    Client findClientByNameQuerySQL(@Param("name") String name);


    @Query("select p from Project p where p.startDate between ?1 and ?2")
    Project findProjectByStartDateIsBetweenQueryHQL(Date stDate, Date edDate);

    @Query(value="SELECT * FROM proyecto WHERE fecha_de_inicio BETWEEN :stDate AND :edDate", nativeQuery = true)
    Project findProjectByStartDateIsBetweenQuerySQL(@Param("stDate") Date stDate, @Param("edDate") Date edDate);


}
