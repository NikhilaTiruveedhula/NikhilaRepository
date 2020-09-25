package com.example.amazonproject.service;
import java.util.List;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
import com.example.amazonproject.entity.Tasks;

public interface TasksServiceInterface {
	public Tasks saveTask(Tasks task);
	public List<Tasks> saveTasks(List<Tasks> tasks);
	public String deleteTaskById(int id);
	public Tasks getTaskById(int id);
	public List<Tasks> getTasks() ;
}
