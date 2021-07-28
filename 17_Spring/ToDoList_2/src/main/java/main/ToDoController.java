package main;

import main.model.ToDo;
import main.model.ToDoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToDoController {

    private ToDoRepository toDoRepository;

    public ToDoController(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @PostMapping("/books/")
    public int add(ToDo dolist) {
        ToDo newToDo = toDoRepository.save(dolist);
        return newToDo.getId();
    }

}
