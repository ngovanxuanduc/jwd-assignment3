package fa.payload.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginReq {
	@NotBlank(message = "UserName Not Blank")
	private String userName;
	
	@NotBlank(message = "Password Not Blank")
	private String password;
}
