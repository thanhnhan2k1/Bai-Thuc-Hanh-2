package product.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import product.Product;
import product.data.ProductRepository;

@Controller
@RequestMapping("/addProduct")
public class AddProductController {
	private final ProductRepository pRepo;
	
	@Autowired
	public AddProductController(ProductRepository pRepo) {
		this.pRepo = pRepo;
	}
	@GetMapping()
	public String showaddProduct(Product product, Model model) {
		model.addAttribute("product", new Product());
		return "addProduct";
	}
	
	@PostMapping()
	public String addProduct(@Valid Product product, Errors errors,Model model) {
		if (errors.hasErrors()) {
			return "addProduct";
		}
		try {
			pRepo.save(product);
			model.addAttribute(product);
			return "redirect:/displayProduct";
		}catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
			return "addProduct";
		}
	}
}
