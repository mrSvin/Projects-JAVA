package main;

import main.model.ToDo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

@Controller
public class UpdateController {

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String get(@ModelAttribute ToDo todocontent, Model model) throws SQLException {
        //todocontent.setContent(todocontent.getContent());
        return "update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String post(@ModelAttribute ToDo todocontent, Model model) throws SQLException {

        return "update";
    }
}
