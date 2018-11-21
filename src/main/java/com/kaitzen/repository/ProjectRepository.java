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

    //List<Project> findProjectsByStartDateIsBetween(Date from, Date to);

    //@Query("select p from Project p where p.startDate between ?1 and ?2")
   // List<Project> findProjectsByStartDateIsBetweenQueryHQL(Date from, Date to);

    //@Query(value="SELECT * FROM proyecto WHERE start_date BETWEEN :from AND :to", nativeQuery = true)
    //List<Project> findProjectsByStartDateIsBetweenQuerySQL(@Param("from") Date from, @Param("to") Date to);

}
