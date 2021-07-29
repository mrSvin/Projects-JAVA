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
//for new commit
@RestController
public class TodoController {

    //private final TodoRepository todoRepository;
    TodoServiceImpl todoService;

    // Рекомендуемый вариант внедрения зависимости:
    // внедрение зависимости в класс через конструктор
    public TodoController(TodoRepository todoRepository) {
        //this.todoRepository = todoRepository;
        todoService = new TodoServiceImpl(todoRepository);
    }

    @GetMapping("/todos/")
    public List<Todo> list() {
        return todoService.getTodo();
    }

    //Добавление дела
    @PostMapping("/todos/")
    public int add(Todo todo) {
        todoService.addTodo(todo);
        return 1;
    }


    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") int id) {
        todoService.deleteByid(id);
        System.out.println(id);
        return "Delete by id called";
    }

    @RequestMapping(value = "/{deleteall}", method = DELETE)
    @ResponseBody
    public String deleteAll() {
        todoService.deleteall();

        return "Delete by id called";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        todoService.deleteByid(id);

        return "Удалено дело №" + id;
    }

    @GetMapping("/deleteall")
    public String deleteall() {
        todoService.deleteall();
        return "Удалены все дела";
    }

    @PutMapping("/update/{id}/{todoupdate}")
    public String updateput(@PathVariable String todoupdate, @PathVariable int id) {
        todoService.updateTodo(todoupdate, id);
        return "Обновлено дело №" + id;
    }


    @GetMapping("/update/{id}/{todoupdate}")
    public String update(@PathVariable String todoupdate, @PathVariable int id) {
        todoService.updateTodo(todoupdate, id);
        return "Обновлено дело №" + id;
    }


//    @GetMapping("/todos/{id}")
//    public ResponseEntity<?> get(@PathVariable int id) {
//        Optional<Todo> optionalBook = todoRepository.findById(id);
//
//        if (!optionalBook.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//
//        return new ResponseEntity<>(optionalBook.get(), HttpStatus.OK);
//    }
    //for new commit
}
