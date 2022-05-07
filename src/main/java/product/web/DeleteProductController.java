package product.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import product.Product;
import product.data.ProductRepository;

@Controller
@Slf4j
@RequestMapping("/deleteProduct")

public class DeleteProductController {
	private final ProductRepository pRepo;

	@Autowired
	public DeleteProductController(ProductRepository pRepo) {
		this.pRepo = pRepo;
	}

	@GetMapping()
	public String showdeletepage(@RequestParam(name = "productCode") String code, Model model) {
		Product p = new Product();
		p = pRepo.findbyCode(code);
		model.addAttribute("product", p);
		model.addAttribute("code", code);
		return "deleteProduct";
	}

	@PostMapping
	public String processDelete(Product p, Model model) {
		String code = p.getCode();
		log.info(code);
		pRepo.delete(p);
		return "redirect:/displayProduct";
	}
}
