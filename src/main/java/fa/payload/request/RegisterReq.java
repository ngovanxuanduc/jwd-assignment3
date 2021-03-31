package fa.payload.request;

import lombok.Data;

@Data
public class RegisterReq {
	private String userName;
	private String email;
	private String password;
}
