package whatimiss.top.littlenote.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class UserController {

    @GetMapping("index")
    public String index() {
        return "Hello";
    }

    @GetMapping("hello")
    public String hello() {
        return "Hello";
    }

    @GetMapping()
    private String HelloWorld() {
        return "Hello World";
    }
}
