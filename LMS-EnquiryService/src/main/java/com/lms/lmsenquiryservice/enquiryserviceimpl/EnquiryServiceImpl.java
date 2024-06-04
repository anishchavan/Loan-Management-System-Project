package com.lms.lmsenquiryservice.enquiryserviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.lmsenquiryservice.enquiryrepository.EnquiryRepository;
import com.lms.lmsenquiryservice.enquiryservicei.EnquiryServiceI;
import com.lms.lmsenquiryservice.model.Enquiry;
@Service
public class EnquiryServiceImpl implements EnquiryServiceI {
	@Autowired
	EnquiryRepository er;
	@Override
	public Enquiry registerApplicant(Enquiry e) {
		return er.save(e);
	}
	@Override
	public List<Enquiry> getApplicants() {
		return (List<Enquiry>) er.findAll();
	}

}
