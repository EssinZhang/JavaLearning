package com.abc.repository;

import com.abc.bean.Depart;
import org.springframework.data.jpa.repository.JpaRepository;
//持久层
public interface DepartRepository extends JpaRepository<Depart, Integer> {
}
