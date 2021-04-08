package fa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.RequestParam;

import fa.entity.MemberEntity;
import fa.payload.request.ContentReq;
import fa.payload.response.ViewContentResp;
import fa.service.ContentService;

@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private ContentService contentService;

	@GetMapping("/viewcontent")
	public String getAllContent(Model model, HttpServletRequest request, HttpSession session, @RequestParam(name = "content", required = false) String content) {
		MemberEntity user = (MemberEntity) session.getAttribute("user");
//		contentService.getAllAuthorizedContent(user.getId()).forEach(System.out::println);
		List<ViewContentResp> contents = null;
		if (content == null || "".equals(content)) {
			contents = contentService.getAllAuthorizedContent(user.getId());
		} else {
			contents = contentService.getAllAuthorizedContent(user.getId(), content);
		}
		
//		model.addAttribute("contents", contentService.getAllAuthorizedContent(user.getId()));
		model.addAttribute("contents", contents);
		return "view-content";
	}

	@GetMapping("/addcontent")
	public String addContent(HttpSession session, Model model, @RequestParam(name = "id", required = false) Integer id) {
		MemberEntity user = (MemberEntity) session.getAttribute("user");
		if (id != null) {
			ContentReq oldContent =  contentService.getContentByIdAndAuthorId(id, user.getId());
			System.out.println("Old Content: "+oldContent);
			if (oldContent != null) {
				model.addAttribute("oldContent", oldContent);
			}
		}
		return "add-content";
	}

	@PostMapping("/addcontent")
	public String addContent(HttpSession session, @Valid @ModelAttribute(name = "content") ContentReq contentReq,
			BindingResult br, Model model) {
//		System.out.println("co loi khong: " + br.hasErrors());
//		, BindingResult br
		System.out.println(contentReq);
		if (br.hasErrors()) {

			br.getAllErrors().forEach(System.out::println);
//			//get danh sach loi
//			Map<String, String> errors = new HashMap<String, String>();
//			br.getAllErrors().forEach(error ->{
//				String fieldName = ((FieldError) error).getField();
//				String errorMessage = error.getDefaultMessage();
//				errors.put(fieldName, errorMessage);
//			});
//			
//			model.addAttribute("errors", errors);
//			model.addAttribute("oldContent", ContentReq);
			return "add-content";
		} else {
			MemberEntity user = (MemberEntity) session.getAttribute("user");
//			System.out.println(user);
			contentService.save(contentReq, user);
//			System.out.println("Luu du lieu di ne");

//			luu du lieu di ne
		}

		return "redirect:viewcontent";
	}

	@PostMapping("/deletecontent")
	public String deleteContent(HttpSession session, Model model, HttpServletRequest request ) {
		MemberEntity user = (MemberEntity) session.getAttribute("user");
//		System.err.println("id post: "+request.getAttribute("id"));
//		System.err.println("id parameter: "+request.getParameter("id"));
		Integer idContent = Integer.valueOf(request.getParameter("id"));		
		if (idContent != null) {
			boolean isDelete  =  contentService.deleteContent(idContent, user.getId());
		}
		return "redirect:viewcontent";
	}

}
