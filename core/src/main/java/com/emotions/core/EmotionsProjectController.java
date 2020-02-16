package com.emotions.core;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmotionsProjectController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

}
