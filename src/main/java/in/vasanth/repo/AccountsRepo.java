package in.vasanth.repo;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.vasanth.entity.AccountDtls;

@Repository
public interface AccountsRepo extends JpaRepository<AccountDtls, Integer>{
	
	AccountDtls findByEmail(String email);

}
