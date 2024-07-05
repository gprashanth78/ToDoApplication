package com.todoApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoApp.entity.ToDoDetails;
import com.todoApp.repository.ToDoRepository;

@Service
public class ToDoDetailsServiceImpl implements ToDoDetailService {

	@Autowired
	private ToDoRepository todoRepository;

	@Override
	public boolean saveToDoDetails(ToDoDetails todo) {
		ToDoDetails addDetails = todoRepository.save(todo);
		return addDetails.getId() != null;
	}

	@Override
	public List<ToDoDetails> getAllToDo() {
		return todoRepository.findAll();
	}

	@Override
	public ToDoDetails getToDoById(Integer id) {
		Optional<ToDoDetails> toDoDetails = todoRepository.findById(id);
		if (toDoDetails.isPresent()) {
			ToDoDetails todo = toDoDetails.get();
			return todo;
		}
		return null;
	}

	@Override
	public boolean deleteToDoById(Integer id) {
		todoRepository.deleteById(id);
		return true;
	}

}
