package main;

import main.model.Todo;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ServiceDao {

    List<Todo> getTodo ();
    Todo addTodo(Todo todo);
    Todo deleteByid(int id);
    void deleteall();
    Todo updateTodo(@PathVariable String todoupdate, @PathVariable int id);

}
