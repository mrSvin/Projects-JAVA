package main;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//For new commit
@RestController
public class DefaultController {

    @RequestMapping("/")
    public String index() {
        return (new Date().toString() + ", рандомное число: " + Math.random()*1000);
    }
}
//For new commit