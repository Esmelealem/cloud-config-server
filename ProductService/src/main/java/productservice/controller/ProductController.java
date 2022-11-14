package productservice.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import productservice.entity.Product;
import productservice.service.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RefreshScope
@RequestMapping("/products")
public class ProductController {
    private Logger log= LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private ProductService productService;
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id){
        log.info("Product-service{}",id);
        return productService.getById(id);
    }
    @GetMapping()
    public List<Product> getProducts(){
        log.info("Product-service{}",getProducts());
        return productService.getAll();
    }
}
