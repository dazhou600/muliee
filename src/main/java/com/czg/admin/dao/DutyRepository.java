package com.czg.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.czg.admin.domain.Duty;
@Repository
public interface DutyRepository extends JpaRepository<Duty,String> {

}
