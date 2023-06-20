package in.vasanth.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.vasanth.entity.AccountDtls;
import in.vasanth.repo.AccountsRepo;
@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private AccountsRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AccountDtls findByEmail = userRepo.findByEmail(username);
	    if(findByEmail==null) {
	    	throw new UsernameNotFoundException(username);
	    }
	    String role = findByEmail.getRole();
	    UserDetails users = User.withUsername(findByEmail.getEmail()).
	    		                 password(findByEmail.getPazzword()).roles("USER").build();
	    return users;
			
			
			
			
		

		
		
	}

}
