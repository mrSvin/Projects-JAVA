package main;

import java.util.ArrayList;
import java.util.Date;

import main.model.Book;
import main.model.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class DefaultController {

    private final BookRepository bookRepository;

    @Value("${someParameter.value}")
    private Integer someParameter;

    public DefaultController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


}