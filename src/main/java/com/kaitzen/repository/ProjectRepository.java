package com.kaitzen.repository;

import com.kaitzen.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByStartDateBetween(LocalDate start, LocalDate end);

    @Query("select p from Project p where p.startDate between ?1 and ?2")
    List<Project> findByStartDateBetweenJPQL(LocalDate start, LocalDate end);

    @Query(value = "select * from proyecto where fechainicio between :inicio and :final", nativeQuery = true)
    List<Project> findByStartDateBetweenSQL(@Param("inicio") LocalDate start, @Param("final") LocalDate end);



}
