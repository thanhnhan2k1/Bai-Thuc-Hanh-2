package product.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import product.Product;
import product.data.ProductRepository;

@Controller
@RequestMapping("/displayProduct")
public class DisplayProductController {
	private final ProductRepository pRepo;
	
	@Autowired
	public DisplayProductController(ProductRepository pRepo) {
		this.pRepo = pRepo;
	}
	@ModelAttribute
	public void addProductToModel(Model model) {
		ArrayList<Product> products = new ArrayList<>();
		pRepo.findAll().forEach(products::add);;
		model.addAttribute("products", products);
	}
	
	@GetMapping()
	public String displayProduct(Model model) {
		addProductToModel(model);
		return "displayProduct";
	}
	
	@PostMapping(name = "addProduct")
	public String showaddProduct() {
		return "redirect:/addProduct";
	}
}
