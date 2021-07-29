package main;

import main.model.Todo;
import main.model.TodoRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;



//for new commit
@Controller
public class DefaultController {

    //private final TodoRepository todoRepository;

    @Value("${someParameter.value}")
    private Integer someParameter;
    TodoServiceImpl todoService;

    public DefaultController(TodoRepository todoRepository) {
        //this.todoRepository = todoRepository;
        todoService = new TodoServiceImpl(todoRepository);
    }

    @RequestMapping("/")
    public String index(Model model) {


        model.addAttribute("todos", todoService.getTodo())
                .addAttribute("todosCount", todoService.getTodo().size())
                .addAttribute("someParameter", someParameter);

        return "index";
    }
    //for new commit
}
