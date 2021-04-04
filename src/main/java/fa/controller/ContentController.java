package fa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fa.entity.MemberEntity;
import fa.payload.request.ContentReq;
import fa.payload.request.RegisterReq;
import fa.service.ContentService;


@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private ContentService contentService;
//	
//	@GetMapping("/api/all")
//	@CrossOrigin(origins = "*")
//	@ResponseBody
//	public ResponseEntity getListContent() {
//		return ResponseEntity.ok().body(contentService.getAllAuthorizedContent(1));
//	}
//	
	
	@GetMapping("/viewcontent")
	public String getAllContent(Model model, HttpServletRequest request, HttpSession session) {
		MemberEntity user = (MemberEntity) session.getAttribute("user");
		model.addAttribute("contents",contentService.getAllAuthorizedContent(user.getId()));
//		model.addAttribute("contents",contentService.getAllAuthorizedContent());
		return "view-content";
	}
	
		
	@GetMapping("/addcontent")
	public String addContent() {
		return "add-content";
	}
	
	@PostMapping("/addcontent")
	public String addContent(HttpSession session, @ModelAttribute ContentReq ContentReq) {
		MemberEntity user = (MemberEntity) session.getAttribute("user");
		System.out.println(ContentReq);
		return "add-content";
	}
	
}
