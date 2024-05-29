package com.lms.lmsenquiryservice.enquiryrepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lms.lmsenquiryservice.model.Enquiry;

@Repository
public interface EnquiryRepository extends CrudRepository<Enquiry, Integer> {

}
