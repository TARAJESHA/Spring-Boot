package com.example.demo.Todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	private List<Todo> todos =new ArrayList<>(
			Arrays.asList(
			new Todo(1 , "task1", "summary1", "disc_1"),
			new Todo(2 , "task2", "summary2", "disc_2"),
			new Todo(3 , "task3", "summary3", "disc_3")
			));
	public List<Todo> getAllTodos() {
		return todos;
	}
//	private TodoRepository todoRepository;
//	
//	public List<Todo> getAllTodos() {
//		List<Todo> todos=new ArrayList<>();
//		todoRepository.findAll().forEach(todos::add);
//		
//		return todos;
//	}

	public  Todo getTodoID(Integer id) {
//		return todoRepository.findAll();
		return todos.stream().filter(t -> t.getID() == id).findFirst().get();
		
				}

	public void createTodo(Todo todo) {
		// TODO Auto-generated method stub
		todos.add(todo);
//		todoRepository.save(todo);
		
	}

	public void updateTodos(Integer id, Todo todo) {
		// TODO Auto-generated method stub
		for(int i=0; i<todos.size(); i++) {
			Todo t=todos.get(i);
			if(t.getID()==id) {
				todos.set(i, todo);
				return;
			}
		}
//		todoRepository.save(todo);
	}

	public void deleteTodos(Integer id) {
		// TODO Auto-generated method stub
		todos.removeIf(t -> t.getID()==id);	
//		todoRepository.deleteById(id);
	}

}
