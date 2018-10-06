package com.palmatolay.innodoxhomework.web;

import com.palmatolay.innodoxhomework.dto.ProductDto;
import com.palmatolay.innodoxhomework.model.Account;
import com.palmatolay.innodoxhomework.model.Product;
import com.palmatolay.innodoxhomework.service.AccountService;
import com.palmatolay.innodoxhomework.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class MainController {

	private final static String ACC = "acc";
	private final static String PROD = "prod";
	private final String[] accountTableHead = new String[] {"id", "username", "email"};
	private final String[] productTableHead = new String[] {"id", "name", "ownerId"};

	@Autowired
	private AccountService accountService;

	@Autowired
	private ProductService productService;

	@GetMapping("/")
	public String index(@RequestParam(value = "c", required = false) String content, Model model){
		if (content != null) {
			switch (content) {
				case ACC:
					model.addAttribute("c", ACC);
					model.addAttribute("theads", accountTableHead);
					model.addAttribute("accounts", accountService.getAll());
					break;
				case PROD:
					model.addAttribute("c", PROD);
					model.addAttribute("theads", productTableHead);
					model.addAttribute("products", productService.getAll());
					break;
			}
		} else {
			model.addAttribute("c", "");
		}
		model.addAttribute("account", new Account());
		model.addAttribute("productDto", new ProductDto());
		return "index";
	}

	@PostMapping("/{target}")
	public String formHandling(@PathVariable("target") String target,
							   @ModelAttribute Account account,
							   @ModelAttribute ProductDto productDto){
		if (target != null) switch (target){
			case ACC:
				accountService.save(account);
				return "redirect:/?c="+ACC;
			case PROD:
				productService.save(productDto);
				return "redirect:/?c="+PROD;
		}
		return "redirect:/";
	}
	@GetMapping("/delete/{target}")
	public String delete(@PathVariable("target") String target,
						 @RequestParam(value = "id") Long id){
		if (target != null) switch (target){
			case ACC:
				accountService.delete(id);
				return "redirect:/?c="+ACC;
			case PROD:
				productService.delete(id);
				return "redirect:/?c="+PROD;
		}
		return "redirect:/";
	}
}
