package fa.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fa.service.DemoServices;

@Controller
public class DemoController {
	@Autowired
	private DemoServices demoService;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "hello";
	}

	@RequestMapping(value = "/demo", method = RequestMethod.GET)
	@ResponseBody
	public String demo() {
		demoService.saveTenEntity();
		String names = demoService.getAllNameDemoEntity().stream().collect(Collectors.joining(", "));
		return names;
	}
	@RequestMapping(value = "/listname", method = RequestMethod.GET)
	public String listName(Model model) {
		List<String> names =demoService.getAllNameDemoEntity();
		
		model.addAttribute("names", names);
		return "listName";
	}
	
	
}
