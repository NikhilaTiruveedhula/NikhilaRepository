package com.example.amazonproject.service;
import java.util.List;
import java.util.HashMap;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
import com.example.amazonproject.entity.Leads;

public interface LeadsServiceInterface {
	public class Node {
	    String prefix;
	    HashMap<Character, Node> children;
	    boolean isWord;        
	    public Node(String prefix) {
	        this.prefix = prefix;
	        this.children = new HashMap<Character, Node>();
	    }
	}
	public static HashMap<String,List<Long>> hm=new HashMap<String,List<Long>>();
	public Leads saveLead(Leads lead);
	public List<Leads> saveLeads(List<Leads> leads);
	public Leads getLeadById(int id);
	public List<Leads> getLeads();
	public String deleteLeadById(int id);
	public Leads updateLead(Leads lead);
}
