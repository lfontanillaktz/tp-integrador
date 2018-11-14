package com.kaitzen.repository;

import com.kaitzen.model.Client;
import com.kaitzen.model.Employee;
import com.kaitzen.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

    List<Project> findAllByName(String name);
    List<Project> findAllByStartDate(Date startDate);
    List<Project> findAllByClient(Client client);
    List<Project> findAllByEmployees(Employee employee);

    @Query("select p from Project p where p.startDate between ?1 and ?2")
    Project findProjectByStartDateIsBetweenQueryHQL(Date stDate, Date edDate);

    @Query(value="SELECT * FROM proyecto WHERE FECHA_INICIO BETWEEN :stDate AND :edDate", nativeQuery = true)
    Project findProjectByStartDateIsBetweenQuerySQL(@Param("stDate") Date stDate, @Param("edDate") Date edDate);

}
