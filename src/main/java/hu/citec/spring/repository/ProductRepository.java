package hu.citec.spring.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Repository;

import hu.citec.spring.entities.Product;

@Repository
public class ProductRepository {

	private JdbcTemplate jdbcTemplate;

	private List<Product> products = new ArrayList<Product>();

	public ProductRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Product> findAllProduct() {
		return jdbcTemplate.query("SELECT * FROM product", new ResultSetExtractor<List<Product>>() {
			@Override
			public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Product> result = new ArrayList<Product>();
				while (rs.next()) {
					result.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
				}
				return result;
			}
		});
	}

	public void addProduct(Product product) {

		String query = "INSERT INTO product (name, type, price) VALUES (?,?,?)";

		jdbcTemplate.update(query, ps -> {
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getType());
			ps.setDouble(3, product.getPrice());
		});

		products.add(product);
	}

	public boolean findUser(String userName) {

		String query = "SELECT user_id as id FROM users WHERE username = ?";

		boolean validUser = false;
		
//		User user = null;

		int validate = 0;

		try {
			validate = jdbcTemplate.queryForObject(query, SingleColumnRowMapper.newInstance(Integer.class), userName);
			if (validate > 0) {
				validUser = true;
			}
		} catch (DataAccessException e) {
			System.out.println("Hiba történt a felhasználó beolvasásakor: " + e.getMessage());
		}
		return validUser;
	}
}