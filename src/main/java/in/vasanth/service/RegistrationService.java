package in.vasanth.service;

import in.vasanth.binding.CreateApplication;

public interface RegistrationService {
	
	public String restCall(CreateApplication data);
	
	public void createApplication();

}
