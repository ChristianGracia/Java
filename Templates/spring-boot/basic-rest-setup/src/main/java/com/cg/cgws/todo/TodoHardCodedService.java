package com.cg.cgws.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class TodoHardCodedService {
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int idCounter = 0;
	
	static {
		todos.add(new Todo(++idCounter, "chris", "Learn to walk", new Date(), false ));
		todos.add(new Todo(++idCounter, "chris", "Learn to talk", new Date(), false ));
		todos.add(new Todo(++idCounter, "chris", "Learn to sing", new Date(), false ));
	}
	
	public List<Todo> findAll(){
		return todos;
		
	}

}
