package main;

import main.model.ToDo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

@Controller
public class DeleteAllController {

    @RequestMapping(value = "/deleteall", method = RequestMethod.GET)
    public String get(@ModelAttribute ToDo todocontent, Model model) throws SQLException {
        return "deleteall";
    }

    @RequestMapping(value = "/deleteall", method = RequestMethod.POST)
    public String post(@ModelAttribute ToDo todocontent, Model model) throws SQLException {
        todocontent.deleteAllTodo();
        return "deleteall";
    }

}
