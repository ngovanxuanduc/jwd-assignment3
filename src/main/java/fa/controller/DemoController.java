package fa.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fa.service.DemoServices;

@Controller
public class DemoController {
	@Autowired
	private DemoServices demoService;
	

//	@Autowired
//	private DBContext dbContext;
	
//	@RequestMapping("/")
//	public String index() {
//		return "index";
//	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(HttpSession session) {
//		MemberEntity user = (MemberEntity) session.getAttribute("user");
//		System.out.println("chay vao day roi");
//		ContentEntity content = ContentEntity.builder()
//				.title("day la title")
//				.brief("day la brief")
//				.content("day la content")
//				.sort(1)
//				.author(user)
//				.build();
//		dbContext.contentRepository.save(content);
//		System.out.println("luu roi do");
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
	
	
	@RequestMapping("/index")
	public String getDemo(Model model, HttpServletRequest request) {
//		model.addAttribute("url",  request.getRequestURL().toString());
//		model.addAttribute("url",  context.getContextPath());
		String oldURL = request.getRequestURL().toString();
		String url = oldURL.substring(0, oldURL.indexOf(request.getRequestURI()));
		model.addAttribute("url",  url+request.getContextPath()+"/edit");
		model.addAttribute("errors", true);
		return "base";
	}
	
	
	@RequestMapping("/edit")
	@CrossOrigin(origins = "*")
	public String getEdit() {
		return "edit";
	}
	
}
