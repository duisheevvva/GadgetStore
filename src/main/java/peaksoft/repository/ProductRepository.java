package peaksoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
