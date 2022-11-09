package com.example.demo.Todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {
	
	@Autowired
	private TodoService todoService; 
	@RequestMapping("/todos")
	public List<Todo> getAllTodos(){
		return todoService.getAllTodos();
	}
	@RequestMapping("/todos/{id}")
	public Todo getTodo(@PathVariable Integer id) {
		return (Todo) todoService.getTodoID(id);
	}
	@RequestMapping(method=RequestMethod.POST, value="todos")
	
	public void createTodos(@RequestBody Todo todo) {
		todoService.createTodo(todo);
		
	}

	@RequestMapping(method=RequestMethod.PUT, value="todos/{id}")
	public void updateTodos(@PathVariable Integer id, @RequestBody Todo todo) {
		todoService.updateTodos(id, todo);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="todos/{id}")
	public void deleteTodos(@PathVariable Integer id) {
	todoService.deleteTodos(id);
	}

}
