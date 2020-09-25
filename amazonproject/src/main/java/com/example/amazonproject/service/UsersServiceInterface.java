package com.example.amazonproject.service;
import java.util.List;
import java.util.Optional;

import com.example.amazonproject.entity.Leads;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
import com.example.amazonproject.entity.Users;
public interface UsersServiceInterface {
	public int getMaxLeadsCount();
	public void setMaxLeadsCount(int cachevar);
	public Users saveUser(Users user);
	public List<Users> saveUsers(List<Users> users);
	public Users getUserById(int id);
	public List<Users> getUsers();
	public String deleteUsersById(int id);
	public Users updateUser(Users user);
	public Optional<Users> findByLocation(String location);
	public void setMinLeadsCount(int minvar);
	public int getMinLeadsCount();
	public Optional<Users> findByCountOfLeads(int min);	
	public String assignLeads(List<Leads> leads);
}