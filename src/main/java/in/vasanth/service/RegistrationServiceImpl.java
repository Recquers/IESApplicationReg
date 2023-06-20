package in.vasanth.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import in.vasanth.binding.CreateApplication;
import in.vasanth.binding.RestCallBind;
import in.vasanth.entity.Application;
import in.vasanth.repo.ApplicationRepo;


@Service
public class RegistrationServiceImpl implements RegistrationService{
	
	private static final String SSN_URL="http://65.2.166.5:8080/ssa/citizen";
	
	@Autowired
	private ApplicationRepo appRepo;
	
	private Application appData;

	@Override
	public String restCall(CreateApplication data) {
		
	WebClient client =WebClient.create();
	
	RestCallBind restData = client.post().uri(SSN_URL).bodyValue(data).retrieve().bodyToMono(RestCallBind.class).block();
	
	String state = restData.getState();
	
	
	if(state.equalsIgnoreCase("Rhode Island")) {
		appData=new Application();
		BeanUtils.copyProperties(restData, appData);
		appData.setEmail(data.getEmail());
		appData.setMobile(data.getMobile());
		createApplication();
		return "Citizen Approved";
	}else {
		return "Not Applicable";
	}
		
	}

	@Override
	public void createApplication() {
		appRepo.save(appData);
		
		
	}
	

}
