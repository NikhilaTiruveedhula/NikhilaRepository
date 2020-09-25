package com.example.amazonproject.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.amazonproject.entity.Tasks;
import org.springframework.stereotype.Repository;
@Repository("tasksdao")
public interface TasksDaoInterface extends JpaRepository<Tasks,Integer> {
}