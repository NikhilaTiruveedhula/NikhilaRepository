package com.example.amazonproject.service;
import java.util.*;
import com.example.amazonproject.dao.LeadsDaoInterface;
import com.example.amazonproject.entity.Leads;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service("leadsservice")
public class LeadsService implements LeadsServiceInterface{
	@Autowired
	@Qualifier("leadsdao")
	private LeadsDaoInterface d;
	public Leads saveLead(Leads lead) {
		return d.save(lead);
	}
	public List<Leads> saveLeads(List<Leads> leads) {
		return d.saveAll(leads);
	}
	public Leads getLeadById(int id) {
		return d.findById(id).orElse(null);
	}
	public List<Leads> getLeads() {
		return d.findAll();
	}
	public String deleteLeadById(int id) {
		d.deleteById(id);
		return "lead removed";
	}
	public Leads updateLead(Leads lead) {
		Leads exist=d.findById(lead.getId()).orElse(null);
		exist.setContactNo(lead.getContactNo());
		exist.setName(lead.getName());
		exist.setLeadsource(lead.getLeadsource());
		exist.setContactNo(lead.getContactNo());
		exist.setEmailId(lead.getEmailId());
		exist.setLocation(lead.getLocation());
		exist.setType(lead.getType());
		exist.setScore(lead.getScore());
		return d.save(exist);
	}
	public Optional<Leads> findByLocation(String location){
		return d.findByLocation(location);
	}
}

