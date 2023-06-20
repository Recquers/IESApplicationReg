package in.vasanth.entity;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import in.vasanth.repo.AccountsRepo;
import in.vasanth.service.CustomUserDetailService;

public class AuditorAwareImpl implements AuditorAware<AccountDtls> {

	@Autowired
	private AccountsRepo accRepo;
	
	
	
	

	@Override
	public Optional<AccountDtls> getCurrentAuditor() {
		 String name = SecurityContextHolder.getContext().getAuthentication().getName();
	
		AccountDtls user = accRepo.findByEmail(name);
		if(user==null) {
			return null;
		}
			

		return Optional.of(user);

	}

   

}
