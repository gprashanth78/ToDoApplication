package com.todoApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.todoApp.entity.ToDoDetails;
import com.todoApp.service.ToDoDetailService;

@Controller
public class ToDoDetailsController {

	@Autowired
	private ToDoDetailService todoService;

	@GetMapping("/loadTodoForm")
	public String loadToDoForm(Model model) {
		model.addAttribute("todoDetails", new ToDoDetails());
		return "todoForm";
	}

	@PostMapping("/addToDoDetails")
	public String addToDoDetails(@ModelAttribute("todoDetails") ToDoDetails todoDetails,
			RedirectAttributes attributes) {
		boolean saveDetails = todoService.saveToDoDetails(todoDetails);
		if (saveDetails) {
			if (todoDetails.getId() != null) {
				attributes.addFlashAttribute("UpdateMessage", "Updated the studendetails");
			} else {
				attributes.addFlashAttribute("SuccMessage", "ToDoDetails record saved");
			}
		} else {
			attributes.addFlashAttribute("ErrorMessage", "Failed to save the records");
		}
		return "redirect:getAllToDoDetails";
	}

	@GetMapping("/getAllToDoDetails")
	public String getAllToDoDetails(Model model) {
		List<ToDoDetails> toDoDetailsList = todoService.getAllToDo();
		model.addAttribute("toDoDetailsList", toDoDetailsList);
		return "todoList";
	}

	@GetMapping("/editToDoDetails/{id}")
	public String updateStudentById(@PathVariable("id") Integer id, Model model) {
		ToDoDetails todoDetails = todoService.getToDoById(id);
		model.addAttribute("todoDetails", todoDetails);
		return "editToDo";
	}

	@GetMapping("/deleteToDo/{id}")
	public String deleteToDoDetailsById(@PathVariable("id") Integer id, RedirectAttributes attribute) {
		boolean deleteToDo = todoService.deleteToDoById(id);
		if (deleteToDo) {
			attribute.addFlashAttribute("succMsg", "Deleted ToDo record successfully");
		} else {
			attribute.addFlashAttribute("errorMsg", "Unable to delete the record");
		}
		return "redirect:/getAllToDoDetails";

	}
}
