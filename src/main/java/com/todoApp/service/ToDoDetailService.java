package com.todoApp.service;

import java.util.List;

import com.todoApp.entity.ToDoDetails;

public interface ToDoDetailService {

	public boolean saveToDoDetails(ToDoDetails todo);
	
	public List<ToDoDetails> getAllToDo();
	
	public ToDoDetails getToDoById(Integer id);
	
	public boolean deleteToDoById(Integer id);
}
