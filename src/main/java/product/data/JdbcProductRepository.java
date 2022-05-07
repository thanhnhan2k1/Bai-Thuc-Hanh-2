package product.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import product.Product;

@Repository
public class JdbcProductRepository implements ProductRepository{
	private JdbcTemplate jdbc;
	
	@Autowired
	public JdbcProductRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	@Override
	public Iterable<Product> findAll() {
		// TODO Auto-generated method stub
		return jdbc.query("Select code, description, price from Product", this::mapRowtoProduct);
	}

	@Override
	public Product findbyCode(String code) {
		// TODO Auto-generated method stub
		return jdbc.queryForObject("Select code, description, price from Product where code=?", this::mapRowtoProduct, code);
	}

	@Override
	public Product save(Product p) {
		// TODO Auto-generated method stub
		jdbc.update("Insert into Product(code, description, price) values(?, ?, ?)", 
				p.getCode(),
				p.getDescription(),
				p.getPrice());
		return p;
	}
	
	private Product mapRowtoProduct(ResultSet rs, int Rownum ) throws SQLException{
		return new Product(rs.getString("code"), rs.getString("description"), rs.getDouble("price"));
	}

	@Override
	public void delete(Product p) {
		// TODO Auto-generated method stub
		 jdbc.update("Delete from Product where code=?" , p.getCode());
	}

	@Override
	public Product update(Product p) {
		// TODO Auto-generated method stub
		jdbc.update("Update Product set description=?, price=? where code=?", p.getDescription(), p.getPrice(), p.getCode());
		return p;
	}
	
}
