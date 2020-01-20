package com.cg.cgws.displaymessage;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class DisplayMessageController {
	
	@GetMapping(path="/call-us")
	public String sendMessage() {
		return "Call us 403-293-3943";
		
	}
	
	@GetMapping(path="/call-us-bean")
	public DisplayMessageBean sendMessageBean() {
//		throw new RuntimeException("Error please call support");
		return new DisplayMessageBean("Call us please!");
		
	}
	
	@GetMapping(path="/user/{name}")
	public DisplayMessageBean sendMessagePathVariable(@PathVariable String name) {
		return new DisplayMessageBean(String.format("Call us %s", name));
		
	}
	
	
}
