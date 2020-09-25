package com.example.amazonproject.service;
import java.util.*;
import com.example.amazonproject.dao.TasksDaoInterface;
import com.example.amazonproject.entity.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service("tasksservice")
public class TasksService implements TasksServiceInterface{
	@Autowired
	@Qualifier("tasksdao")
	private TasksDaoInterface td;
	public Tasks saveTask(Tasks task) {
		return td.save(task);
	}
	public List<Tasks> saveTasks(List<Tasks> tasks) {
		return td.saveAll(tasks);
	}
	public Tasks getTaskById(int id) {
		return td.findById(id).orElse(null);
	}
	public List<Tasks> getTasks() {
		return td.findAll();
	}
	public String deleteTaskById(int id) {
		td.deleteById(id);
		return "task removed";
	}
}

