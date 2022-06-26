package inspired.gaming.apigateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import inspired.gaming.apigateway.entity.AccountDetails;



@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Integer> {

	public AccountDetails findByUsernameAndPassword(@Param("username") String username, @Param("passwd") String passwd);
	public AccountDetails findByUsername(@Param("username") String username);

}
