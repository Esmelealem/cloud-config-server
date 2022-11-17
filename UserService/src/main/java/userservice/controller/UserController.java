package userservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
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

import java.util.Date;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private Logger log = LoggerFactory.getLogger(UserController.class);
    @Lazy
    private final RestTemplate restTemplate;
    @Value("${microservice.product-service.endpoints.endpoint.uri}")
    private String ENDPOINT_URL;

    private static final String USER_SERVICE = "userService";
    private int attempt=1;

    @GetMapping
   // @CircuitBreaker(name = USER_SERVICE, fallbackMethod = "getAllAvailableProducts")
    public Iterable<User> getAllUsers() throws JsonProcessingException {
//        var result = restTemplate.getForObject("http://product-service/products/1", ProductDto.class);
        //int id=0;
        // var result=id==null? ENDPOINT_URL:ENDPOINT_URL+'/'+id;
        var result = restTemplate.getForObject(ENDPOINT_URL, ProductDto.class);
        System.out.println(result);
        log.info("User-service{}", new ObjectMapper().writeValueAsString(result));
        return userService.getAll();
    }

    public Iterable<User> getAllAvailableProducts(Exception e) {

        return userService.getAll();
    }

    @GetMapping("/products")
   // @CircuitBreaker(name = USER_SERVICE, fallbackMethod = "getAllProducts")
    @Retry(name = USER_SERVICE,fallbackMethod = "getAllProducts")
    public ProductDto getAllProducts() throws JsonProcessingException {
        var result = restTemplate.getForObject(ENDPOINT_URL, ProductDto.class);
        System.out.println(result);
        log.info("User-service{}", new ObjectMapper().writeValueAsString(result));

        return result;

    }
    public ProductDto getAllProducts(Exception e) {
        System.out.println("Retry method called"+attempt++ + "times "+ "at "+new Date());
        ProductDto pdt=new ProductDto(1,"Apple","red");
        return pdt;
    }
}
