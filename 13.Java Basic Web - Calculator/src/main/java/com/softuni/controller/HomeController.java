package com.softuni.controller;

import com.softuni.entity.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DecimalFormat;

@Controller
public class HomeController {
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("operator", "+");
		model.addAttribute("view", "views/calculatorForm");
		return "base-layout";
	}
@PostMapping("/")
	public String calculate(Model model,
							@RequestParam(name = "leftOperand") Double num1,
							@RequestParam(name = "rightOperand") Double num2,
							@RequestParam(name = "operator") String operator){
	model.addAttribute("view", "views/calculatorForm");

	Calculator calculator = new Calculator(num1, operator, num2);
	Double result = calculator.result();
	DecimalFormat df = new DecimalFormat("#.##");

	model.addAttribute("leftOperand",df.format(num1));
	model.addAttribute("rightOperand",df.format(num2));
	model.addAttribute("operator",operator);

	model.addAttribute("result",df.format(result));

		return "base-layout";
}
}
