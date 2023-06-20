package in.vasanth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import in.vasanth.entity.AccountDtls;
import in.vasanth.entity.AuditorAwareImpl;

@Configuration
@EnableJpaAuditing
public class AuditConfig {
	 @Bean
	  public AuditorAware<AccountDtls> auditorProvider() {
	    return new AuditorAwareImpl();
	  }

}
