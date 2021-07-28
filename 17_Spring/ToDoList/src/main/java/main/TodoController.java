package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import main.model.Todo;
import main.model.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

@RestController
public class TodoController {

    private final TodoRepository todoRepository;

    // Рекомендуемый вариант внедрения зависимости:
    // внедрение зависимости в класс через конструктор
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/todos/")
    public List<Todo> list() {
        Iterable<Todo> bookIterable = todoRepository.findAll();

        List<Todo> todos = new ArrayList<>();
        for (Todo todo : bookIterable) {
            todos.add(todo);
        }
        return todos;
    }

    //Добавление дела
    @PostMapping("/todos/")
    public int add(Todo todo) {
        Todo newTodo = todoRepository.save(todo);
        return newTodo.getId();
    }


    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") int id) {
        todoRepository.deleteById(id);
        System.out.println(id);
        return "Delete by id called";
    }
    @RequestMapping(value = "/{deleteall}", method = DELETE)
    @ResponseBody
    public String deleteAll() {
        todoRepository.deleteAll();

        return "Delete by id called";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        todoRepository.deleteById(id);

        return "Удалено дело №" + id;
    }

    @GetMapping("/deleteall")
    public String deleteall() {
        todoRepository.deleteAll();
        return "Удалены все дела";
    }

    @PutMapping("/update/{id}/{todoupdate}")
    public String updateput(@PathVariable String todoupdate, @PathVariable int id) {
        Todo todo = new Todo();
        todo.setId(id);
        todo.setName(todoupdate);
        todoRepository.save(todo);
        return "Обновлено дело №" + id;
    }


    @GetMapping("/update/{id}/{todoupdate}")
    public String update(@PathVariable String todoupdate, @PathVariable int id) {
        Todo todo = new Todo();
        todo.setId(id);
        todo.setName(todoupdate);
        todoRepository.save(todo);
        return "Обновлено дело №" + id;
    }


    @GetMapping("/todos/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        Optional<Todo> optionalBook = todoRepository.findById(id);

        if (!optionalBook.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return new ResponseEntity<>(optionalBook.get(), HttpStatus.OK);
    }
}