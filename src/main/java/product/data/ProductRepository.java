package product.data;

import product.Product;

public interface ProductRepository {
	Iterable<Product> findAll();
	Product findbyCode(String code);
	Product save(Product p);
	void delete(Product p);
	Product update(Product p);
}
