package com.lms.customerservice.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.customerservice.app.exception.CustomerNotFound;
import com.lms.customerservice.app.model.CustomerDetails;
import com.lms.customerservice.app.model.Ledger;
import com.lms.customerservice.app.repository.CustomerRepository;
import com.lms.customerservice.app.servicei.LedgerServiceI;
@CrossOrigin("*")
@RestController
@RequestMapping("/ledger")
public class LedgerController {

	@Autowired
    private LedgerServiceI ledgerService;

  @Autowired
   private CustomerRepository customerRepository;

	@PutMapping("/updateLedger/{customerId}/{ledgerId}")
	public ResponseEntity<?> updateLedger(@PathVariable Integer customerId, @PathVariable Integer ledgerId, @RequestBody Ledger updatedLedger) {
	    Optional<CustomerDetails> customerDetailsOptional = customerRepository.findById(customerId);
	    
	    if (!customerDetailsOptional.isPresent()) {
	        return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
	    }
	    
	    CustomerDetails customerDetails = customerDetailsOptional.get();
	    List<Ledger> ledgers = customerDetails.getLedger();
	    
	    Ledger existingLedger = null;
	    for (Ledger ledger : ledgers) {
	        if (ledger.getLedgerId().equals(ledgerId)) {
	            existingLedger = ledger;
	            break;
	        }
	    }
	    
	    if (existingLedger == null) {
	        return new ResponseEntity<>("Ledger not found", HttpStatus.NOT_FOUND);
	    }
	    
	    // Update the ledger fields
	    existingLedger.setLedgerCreatedDate(updatedLedger.getLedgerCreatedDate());
	    existingLedger.setTotalLoanAmount(updatedLedger.getTotalLoanAmount());
	    existingLedger.setPayableAmountwithInterest(updatedLedger.getPayableAmountwithInterest());
	    existingLedger.setTenure(updatedLedger.getTenure());
	    existingLedger.setMonthlyEMI(updatedLedger.getMonthlyEMI());
	    existingLedger.setAmountPaidtillDate(updatedLedger.getAmountPaidtillDate());
	    existingLedger.setRemainingAmount(updatedLedger.getRemainingAmount());
	    existingLedger.setNextEmiDatestart(updatedLedger.getNextEmiDatestart());
	    existingLedger.setNextEmiDateEnd(updatedLedger.getNextEmiDateEnd());
	    existingLedger.setDefaulterCount(updatedLedger.getDefaulterCount());
	    existingLedger.setPreviousEmiStatus(updatedLedger.getPreviousEmiStatus());
	    existingLedger.setCurrentMonthEmiStatus(updatedLedger.getCurrentMonthEmiStatus());
	    existingLedger.setLoanEndDate(updatedLedger.getLoanEndDate());
	    existingLedger.setLoanStatus(updatedLedger.getLoanStatus());
	    
	    ledgers.add(existingLedger); // Add the updated ledger to the list
	    customerDetails.setLedger(ledgers);
	    
	    CustomerDetails updatedCustomerDetails = ledgerService.saveCustomerLedger(customerDetails);
	    return new ResponseEntity<>(updatedCustomerDetails, HttpStatus.OK);
	}

}
