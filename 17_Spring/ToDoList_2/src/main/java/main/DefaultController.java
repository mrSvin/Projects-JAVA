package main;

import java.sql.SQLException;

import main.model.ToDo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DefaultController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Stanki(@ModelAttribute ToDo todocontent, Model model) throws SQLException {
        //преобразовываем массив в список
        String listToSpisok = String.valueOf(todocontent.getTodo());
        listToSpisok = listToSpisok.replaceAll("]","");
        listToSpisok = listToSpisok.replaceAll("\\[","");
        listToSpisok = listToSpisok.replaceAll(",","<br />");



        model.addAttribute("booksCount", todocontent.getTodo().size())
                .addAttribute("someParameter", listToSpisok)
                .addAttribute("todocontent", todocontent);
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String greetingSubmitDate(@ModelAttribute ToDo todocontent, Model model) throws SQLException {

        return "index";
    }

}