package fa.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.core.annotation.Order;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import fa.payload.request.ContentReq;

@ControllerAdvice
public class HandlerException {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public String handleValidationExceptions(MethodArgumentNotValidException ex) {
		System.out.println("da vao day ne");
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors.keySet().stream().map(key -> key + "=" + errors.get(key))
				.collect(Collectors.joining(", ", "{", "}"));
	}

	@ExceptionHandler(BindException.class)
//	@ResponseBody
	public String haha(HttpServletRequest req, BindException ex, HttpSession session,
			Model model/* , ContentReq ContentReq */) {
//		System.out.println("da vao day ne: " + ex.getClass());
//		System.out.println("Get Du lieu Demo Tu Session: "+session.getAttribute("preUrl"));
//		System.out.println("Get Du lieu Demo Tu Session: "+ req.getRequestURL());
		String pathURI = req.getRequestURI().substring(req.getContextPath().length());
		System.out.println("Action: "+pathURI);
//		System.out.println("Get Du lieu Demo Tu Session: "+session.getAttribute("duc"));
		String strEr = ex.getAllErrors().stream().map(er -> er.getDefaultMessage()).collect(Collectors.joining(", ","{","}"));
		System.out.println(strEr);
//		String urlRedirect = (String) session.getAttribute("preUrl");
		Map<String, String> errors = new HashMap<String, String>();
		ex.getBindingResult().getAllErrors().forEach(error ->{
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
//		errors.put("url", urlRedirect);	
		model.addAllAttributes(errors);
//		model.addAttribute("errors", errors);
//		return "da vao day ne Exception : " + ex.getStackTrace();
//		return errors.keySet().stream().map(key -> key + "=" + errors.get(key))
//				.collect(Collectors.joining(", ", "{", "}"));
//		return "redirect:"+pathURI;
		return "add-content";
//		return "forward:"+urlRedirect;
//		return errors;
	}
}
