package com.example.amazonproject.dao;
//import java.util.List;
import java.util.Optional;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.amazonproject.entity.Users;
import org.springframework.stereotype.Repository;
@Repository("usersdao")
public interface UsersDaoInterface extends JpaRepository<Users,Integer> {
	@Query("Select u from Users u where u.location = :location")
	public Optional<Users> findByLocation(@Param("location")String location);
	@Query("Select u from Users u where u.countOfLeads <= :min")
	public Optional<Users> findByCountOfLeads(@Param("min")Integer min);
}