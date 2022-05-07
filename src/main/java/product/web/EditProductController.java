package product.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import product.Product;
import product.data.ProductRepository;

@Controller
@RequestMapping("/editProduct")
public class EditProductController {
	private final ProductRepository pRepo;

	@Autowired
	public EditProductController(ProductRepository pRepo) {
		this.pRepo = pRepo;
	}
	@GetMapping()
	public String showEditpage(@RequestParam(name = "productCode") String code, Model model) {
		Product p = new Product();
		p = pRepo.findbyCode(code);
		model.addAttribute("product",p);
		return "editProduct";
	}
	@PostMapping
	public String processEdit(Product p, Model model) {
		pRepo.update(p);
		return "redirect:/displayProduct";
	}
}
