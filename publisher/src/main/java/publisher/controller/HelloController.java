package publisher.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import publisher.service.HelloService;

@RestController
@RequestMapping("/services")
@AllArgsConstructor

public class HelloController {
    private  final HelloService helloService;

    @GetMapping
    public void send(){
        helloService.send();
    }
}
