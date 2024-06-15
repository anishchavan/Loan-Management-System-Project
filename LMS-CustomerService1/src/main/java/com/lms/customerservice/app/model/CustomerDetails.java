package com.lms.customerservice.app.model;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
    private String customerFirstName;
    private String customerMiddleName;
    private String customerLastName;
    
    private long mobileNumber;
	private String CustomerEmailId;
	private String panCardNumber;
	private long aadharNumber;
	private String customerDateOfBirth;
	private String customerGender;
	private String qualification;
	private String customerLoanStatus;
	private Integer customerCibilScore;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerAddress customerAddress;
    
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerBankDetails customerBankDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private EmploymentDetails employmentDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private GuarantorDetails guarantorDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PreviousLoanDetails previousLoanDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private PropertyDetails propertyDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerDocuments customerDocuments;
	
	@OneToOne(cascade = CascadeType.ALL)
	private SanctionLetter sanctionLetter;
	
	@OneToOne(cascade = CascadeType.ALL)
	private LoanDisbursement loanDisbursement;
}
