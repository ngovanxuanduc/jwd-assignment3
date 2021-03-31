package fa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fa.entity.MemberEntity;
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

}

