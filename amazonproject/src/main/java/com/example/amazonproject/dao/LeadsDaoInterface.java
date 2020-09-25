package com.example.amazonproject.dao;
import java.util.Optional;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.amazonproject.entity.Leads;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
@Repository("leadsdao")
public interface LeadsDaoInterface extends JpaRepository<Leads,Integer> {
	@Query("Select l from Leads l where l.location = :location")
	public Optional<Leads> findByLocation(@Param("location")String location);
}
