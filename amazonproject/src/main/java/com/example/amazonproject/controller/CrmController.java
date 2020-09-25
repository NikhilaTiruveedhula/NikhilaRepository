package com.example.amazonproject.controller;
import com.example.amazonproject.entity.Leads;
import com.example.amazonproject.entity.Users;
import com.example.amazonproject.entity.Tasks;
import com.example.amazonproject.service.LeadsServiceInterface;
import com.example.amazonproject.service.TasksServiceInterface;
import com.example.amazonproject.service.UsersServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class CrmController {
	@Autowired
	@Qualifier("leadsservice")
    private LeadsServiceInterface service;
	@Autowired
	@Qualifier("usersservice")
    private UsersServiceInterface uservice;
	@Autowired
	@Qualifier("leadsservice")
	private TasksServiceInterface tservice;
	@PostMapping("/addLead")
    public Leads addLead(@RequestBody Leads lead) {
        return service.saveLead(lead);
    }

    @PostMapping("/addLeads")
    public List<Leads> addLeads(@RequestBody List<Leads> leads) {
        return service.saveLeads(leads);
    }

    @GetMapping("/leads")
    public List<Leads> findAllLeads() {
        return service.getLeads();
    }

    @GetMapping("/leadById/{id}")
    public Leads findLeadById(@PathVariable int id) {
        return service.getLeadById(id);
    }

    @PutMapping("/updatelead")
    public Leads updateLead(@RequestBody Leads lead){
        return service.updateLead(lead);
    }

    @DeleteMapping("/deletelead/{id}")
    public String deleteLead(@PathVariable int id) {
        return service.deleteLeadById(id);
    }
  
	@PostMapping("/addTask")
    public Tasks addTask(@RequestBody Tasks task) {
        return tservice.saveTask(task);
    }

    @PostMapping("/addTasks")
    public List<Tasks> addTasks(@RequestBody List<Tasks> users) {
        return tservice.saveTasks(users);
    }

    @GetMapping("/tasks")
    public List<Tasks> findAllTasks() {
        return tservice.getTasks();
    }

    @GetMapping("/taskById/{id}")
    public Tasks findTaskById(@PathVariable int id) {
        return tservice.getTaskById(id);
    }

    @DeleteMapping("/deletetask/{id}")
    public String deleteTask(@PathVariable int id) {
        return tservice.deleteTaskById(id);
    }

    @GetMapping("/users")
    public List<Users> findAllUsers() {
        return uservice.getUsers();
    }

    @GetMapping("/userById/{id}")
    public Users findUserById(@PathVariable int id) {
        return uservice.getUserById(id);
    }

    @PutMapping("/updateuser")
    public Users updateUser(@RequestBody Users user){
        return uservice.updateUser(user);
    }

    @DeleteMapping("/deleteuser/{id}")
    public String deleteUser(@PathVariable int id) {
        return uservice.deleteUsersById(id);
    }
    @PostMapping("/assignLeads")
    public String assignLeads(List<Leads> leads) {
    	return uservice.assignLeads(leads);
    }
}