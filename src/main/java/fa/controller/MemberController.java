package fa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fa.entity.MemberEntity;
import fa.payload.request.EditUserReq;
import fa.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberService;

//	@PostMapping("/add")
	@GetMapping("/add")
	public String addMember(HttpSession session ) {
		MemberEntity entity = memberService.addMember(null);
		System.out.println(entity);
		// update ne
		System.out.println(memberService.updateMember(entity));
		return "hello";
	}
	
	
	@GetMapping("/edit")
	public String editMember(HttpSession session, Model model) {
		MemberEntity user = (MemberEntity) session.getAttribute("user");
//		System.out.println("CO ten la: "+user.getFirstName());
		model.addAttribute("user", user);
		return "edit-profile";
	}
	
	@PostMapping("/edit")
	public String editMember(HttpSession session, @ModelAttribute EditUserReq editUserReq, Model model) {
		System.out.println(editUserReq);
		MemberEntity user = (MemberEntity) session.getAttribute("user");
		model.addAttribute("edit", true);
		memberService.updateMember(editUserReq, user);
		return "edit-profile";
	}
}

