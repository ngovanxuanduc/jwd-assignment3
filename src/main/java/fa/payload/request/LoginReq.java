package fa.payload.request;

import lombok.Data;

@Data
public class LoginReq {
	private String userName;
	private String password;
}
