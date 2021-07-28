package main;

import main.model.Todo;
import main.model.TodoRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
//for new commit
@Controller
public class DefaultController {

    private final TodoRepository todoRepository;

    @Value("${someParameter.value}")
    private Integer someParameter;

    public DefaultController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @RequestMapping("/")
    public String index(Model model) {
        Iterable<Todo> todoIterable = todoRepository.findAll();
        ArrayList<Todo> todos = new ArrayList<>();

        for (Todo todo : todoIterable) {
            todos.add(todo);
        }

        model.addAttribute("todos", todos)
                .addAttribute("todosCount", todos.size())
                .addAttribute("someParameter", someParameter);

        return "index";
    }
    //for new commit
}