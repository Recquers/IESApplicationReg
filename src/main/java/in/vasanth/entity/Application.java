package in.vasanth.entity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
public class Application {
	@Id
	@GeneratedValue(generator = "sequence-generator")
	@GenericGenerator(name = "sequence-generator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "user_sequence"),
			@Parameter(name = "initial_value", value = "1000"), @Parameter(name = "increment_size", value = "1") })
	private Integer caseNumber;

	private String fullname;

	private String email;

	private String mobile;

	private String gender;

	private String dob;

	private String ssn;
	

	private String state;

	private String city;
	
	private String houseNum;
	
	@CreatedBy
	@ManyToOne
	@JoinColumn(name = "account_id")
	private AccountDtls userId;

}
