package controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
	
	@GetMapping(value = "/" , produces = MediaType.TEXT_HTML_VALUE)
	public @ResponseBody String get(){
		return "Abhinav";
	}

}
