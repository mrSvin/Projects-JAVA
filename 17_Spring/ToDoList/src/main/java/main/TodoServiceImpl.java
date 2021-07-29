package main;

import main.model.Todo;
import main.model.TodoRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

public class TodoServiceImpl implements ServiceDao {

    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> getTodo() {
        Iterable<Todo> bookIterable = todoRepository.findAll();

        List<Todo> todos = new ArrayList<>();
        for (Todo todo : bookIterable) {
            todos.add(todo);
        }
        return todos;
    }

    @Override
    public Todo addTodo(Todo todo) {
        todoRepository.save(todo);
        return null;
    }

    @Override
    public Todo deleteByid(int id) {
        todoRepository.deleteById(id);
        return null;
    }

    @Override
    public void deleteall() {
        todoRepository.deleteAll();
    }

    @Override
    public Todo updateTodo(@PathVariable String todoupdate, @PathVariable int id) {
        Todo todo = new Todo();
        todo.setId(id);
        todo.setName(todoupdate);
        todoRepository.save(todo);
        return null;
    }
}
