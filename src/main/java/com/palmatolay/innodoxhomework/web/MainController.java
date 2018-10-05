package com.palmatolay.innodoxhomework.web;

import com.palmatolay.innodoxhomework.service.AccountService;
import com.palmatolay.innodoxhomework.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/")
public class MainController {

	private final String[] accountTableHead = new String[] {"id", "username", "email"};
	private final String[] productTableHead = new String[] {"id", "name", "ownerId"};

	@Autowired
	private AccountService accountService;

	@Autowired
	private ProductService productService;

	@GetMapping("/")
	public String index(@RequestParam(value = "c", required = false) String content, Map<String, Object> model){
		final String account = "acc";
		final String product = "prod";
		if (content != null) {
			switch (content) {
				case account:
					model.put("c", account);
					model.put("theads", accountTableHead);
					model.put("accounts", accountService.getAll());
					break;
				case product:
					model.put("c", "acc");
					model.put("theads", productTableHead);
					model.put("products", productService.getAll());
					break;
				default:
					model.put("c", "");
			}
		} else {
			model.put("c", "");
		}
		System.out.println(content);
		System.out.println(model.toString());
		return "index";
	}
}
