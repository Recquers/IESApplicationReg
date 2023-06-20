package in.vasanth.binding;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateApplication {
	
	private String fullname;
	
	private String email;
	
	private String mobile;
	
	private String gender;
	
	private String dob;
	
	private String ssn;

}
