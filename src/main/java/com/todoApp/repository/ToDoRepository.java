package com.todoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todoApp.entity.ToDoDetails;

@Repository
public interface ToDoRepository extends JpaRepository<ToDoDetails, Integer> {

}
