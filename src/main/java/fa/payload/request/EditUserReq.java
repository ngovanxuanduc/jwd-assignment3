package fa.payload.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EditUserReq {
	@NotBlank(message = "FirstName Not Blank")
	private String firstName;
	
	@NotBlank(message = "LastName Not Blank")
	private String lastName;
	
	@NotBlank(message = "UserName Not Blank")
	private String phone;
	
	@NotBlank(message = "Description Not Blank")
	private String description;
}
