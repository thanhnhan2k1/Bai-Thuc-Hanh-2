package product;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Product {
	@NotBlank(message=" Product Code is required")
	private String code;
	@NotBlank(message=" Product Description is required")
	private String description;
	@NotBlank(message=" Product Price is required")
	private double price;
	public Product() {
		this.code="";
		this.description="";
		this.price=0;
	}
	public Product(String string, String string2, double price) {
		// TODO Auto-generated constructor stub
		this.code = string;
		this.description = string2;
		this.price = price;
	}
	
}
