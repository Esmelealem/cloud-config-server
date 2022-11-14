package productservice.service;

import productservice.entity.Product;

import java.util.List;

public interface ProductService {
    Product getById(int id);
    List<Product> getAll();
}
