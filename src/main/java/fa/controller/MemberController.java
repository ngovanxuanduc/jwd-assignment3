package fa.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
//	@GetMapping("/add")
//	public String addMember(HttpSession session ) {
//		MemberEntity entity = memberService.addMember(null);
//		System.out.println(entity);
//		// update ne
//		System.out.println(memberService.updateMember(entity));
//		return "hello";
//	}
	
	
	@GetMapping("/edit")
	public String editMember(HttpSession session, Model model) {
		MemberEntity user = (MemberEntity) session.getAttribute("user");
		//lay du lieu moi trong DB, lo coi nguoi update trong DB
		user = memberService.getMemberEntityById(user.getId());
		model.addAttribute("user", user);
		return "edit-profile";
	}
	
	@PostMapping("/edit")
	public String editMember(HttpSession session,@Valid @ModelAttribute(name = "editUser") EditUserReq editUserReq, BindingResult br, Model model) {
		System.out.println(editUserReq);
		if (br.hasErrors()) {
			return "edit-profile";
		}
		MemberEntity user = (MemberEntity) session.getAttribute("user");
		memberService.updateMember(editUserReq, user);
		model.addAttribute("edit", true);
		return "edit-profile";
	}
}

