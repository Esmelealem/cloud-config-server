package userservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import userservice.dto.ProductDto;
import userservice.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import userservice.service.UserService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private Logger log= LoggerFactory.getLogger(UserController.class);
    @Lazy
    private final RestTemplate restTemplate;
    @Value("${microservice.product-service.endpoints.endpoint.uri}")
    private String ENDPOINT_URL;

    @GetMapping
    public Iterable<User> getAllUsers() throws JsonProcessingException {
//        var result = restTemplate.getForObject("http://product-service/products/1", ProductDto.class);
        var result = restTemplate.getForObject(ENDPOINT_URL, ProductDto.class);
        System.out.println(result);
        log.info("User-service{}",new ObjectMapper().writeValueAsString(result));
        return userService.getAll();
    }
    @GetMapping("/products")
    public ProductDto getAllProducts() throws JsonProcessingException {
        var result = restTemplate.getForObject(ENDPOINT_URL, ProductDto.class);
        System.out.println(result);
        log.info("User-service{}",new ObjectMapper().writeValueAsString(result));
        return result;
    }
}
