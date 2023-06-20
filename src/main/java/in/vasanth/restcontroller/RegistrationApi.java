package in.vasanth.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.vasanth.binding.CreateApplication;
import in.vasanth.service.RegistrationService;

@RestController
public class RegistrationApi {
	
	@Autowired
	private RegistrationService service;
   
	@PostMapping(value ="/register", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<String>  saveCitizenData(@RequestBody CreateApplication appData) {
	
		return  new ResponseEntity<>(service.restCall(appData),HttpStatus.CREATED);

	}
	@GetMapping(path = "/hi")
    public String showMsg() {
		
		return "Hello WOrld";
	}
	
}
