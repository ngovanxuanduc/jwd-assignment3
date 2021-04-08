package fa.payload.request;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContentReq {
	
	private Integer id;
	
	@NotBlank(message = "Title Not Blank")
	private String title;
	
	@NotBlank(message = "Brief Not Blank")
	private String brief;
	
	@NotBlank(message = "Content Not Blank")
	private String content;
}
