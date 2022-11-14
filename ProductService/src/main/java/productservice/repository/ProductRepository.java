package productservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import productservice.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {
}
