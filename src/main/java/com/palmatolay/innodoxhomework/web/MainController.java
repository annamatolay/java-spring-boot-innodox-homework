package com.palmatolay.innodoxhomework.web;

import com.palmatolay.innodoxhomework.dto.ProductDto;
import com.palmatolay.innodoxhomework.model.Account;
import com.palmatolay.innodoxhomework.service.AccountService;
import com.palmatolay.innodoxhomework.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * It is the web layer what responsible for the view manipulation and communication between the client and the server.
 * Also responsible for communication between the web and service layer.
 * final static String {@link #ACC} and {@link #PROD} define a content selector for the web layer.
 * final String[] {@link #accountTableHead} and {@link #productTableHead} define the tables header for the view.
 */
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

	/**
	 * Responsible for rendering the home page and the tables what filled with data from the database.
	 * @param content is a String request parameter what contain the desired content based on the user input.
	 * @param model is an interface that defines a holder for model attributes. The content of model can be accessible
	 *              on the front-end side.
	 * @return a String what is equal with an exist HTML document name under the resources/templates folder.
	 */
	@GetMapping("/")
	private String index(@RequestParam(value = "c", required = false) String content, Model model){
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

	/**
	 * Responsible handling all the incoming form submission and send new data objects to the service layer.
	 * @param target is a String path variable based on the content selector.
	 *               Because of this the application know which form was submitted.
	 * @param account an {@link Account} object what instantiated in the {@link #index(String, Model)} method and received here
	 *                with the modified attributes based on the form input.
	 * @param productDto a {@link ProductDto} object what instantiated in the {@link #index(String, Model)} method and
	 *                   received here with the modified attributes based on the form input.
	 * @return a String what is HTTP redirect request to the home/index page
	 */
	@PostMapping("/{target}")
	private String formHandling(@PathVariable("target") String target,
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

	/**
	 * Responsible for deletion based on the given id.
	 * @param target is a String path variable based on the content selector.
	 *               Because of this the application know which type of service should be invoked.
	 * @param id is a Long request parameter what refer to an account/product in the database.
	 * @return a String what is HTTP redirect request to the home/index page
	 */
	@GetMapping("/delete/{target}")
	private String delete(@PathVariable("target") String target,
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
