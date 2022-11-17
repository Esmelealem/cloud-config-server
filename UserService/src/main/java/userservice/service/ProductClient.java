package userservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import userservice.dto.ProductDto;

import java.util.List;

@FeignClient(name = "product-service",url = "http://loclahost:9090")
public interface ProductClient {
    @GetMapping("/products")
    List<ProductDto> getProducts();
}
