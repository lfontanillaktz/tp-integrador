package com.kaitzen.repository;

import com.kaitzen.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository

public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByStartDateBetween(Date date1, Date date2);

    //consulta HQL
    @Query("select c from Project c where c.startDate BETWEEN ?1 AND ?2")
    List<Project> findProjectByStartDateBetweenHQL(Date date1,Date date2);

    //Consulta SQL
    @Query(value = "SELECT * FROM PROJECTO WHERE FECHA_DE_INICIO BETWEEN :date1 AND :date2", nativeQuery = true)
    List<Project> findClientByNameQuerySQL(@Param("date1") Date date1,@Param("date2") Date date2);



}
