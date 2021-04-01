package fa.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@ResponseBody
	public String haha(BindException ex) {
		System.out.println("da vao day ne: " + ex.getClass());
		String strEr = ex.getAllErrors().stream().map(er -> er.getDefaultMessage()).collect(Collectors.joining(", ","{","}"));
		System.out.println(strEr);
		return "da vao day ne Exception : " + ex.getStackTrace();
	}
}
