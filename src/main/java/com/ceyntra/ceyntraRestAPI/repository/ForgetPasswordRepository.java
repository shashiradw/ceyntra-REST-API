package com.ceyntra.ceyntraRestAPI.repository;

import com.ceyntra.ceyntraRestAPI.model.ForgetPasswordModel;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface ForgetPasswordRepository extends JpaRepository<ForgetPasswordModel, Integer> {
    @Query("Select a.id, a.email, a.pinNumber from ForgetPasswordModel a where a.email = :email and a.pinNumber= :pin")
    public List<String> findByEmailAndPin(@Param("email") String email, @Param("pin") int pin);

    @Query("Select a.email from ForgetPasswordModel a where a.email = :email ")
    public List<String> findByEmail(@Param("email") String email);

    @Transactional
    @Modifying
    @Query("UPDATE ForgetPasswordModel a SET a.pinNumber = :#{#pin} WHERE a.email = :#{#email}")
    public int updatePin(@Param("email") String email, @Param("pin") int pin);

}
