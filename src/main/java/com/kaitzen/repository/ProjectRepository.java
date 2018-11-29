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

    List<Project> findAllByStartDateBetween(Date date1, Date date2);

    //Consulta HQL
    @Query("select p from Project p where p.startDate between ?1 and ?2")
    List<Project> findProjectByStartDateBetweenQueryHQL (Date date1, Date date2);

    //Consulta SQL
    @Query(value="SELECT * FROM proyecto WHERE fecha_de_inicio BETWEEN :date1 AND :date2", nativeQuery = true)
    List<Project> findProjectByStartDateBetweenQuerySQL(@Param("date1")Date date,@Param("date2") Date date2);

}
