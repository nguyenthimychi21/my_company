package com.example.demo.services;

import com.example.demo.entity.company;
import com.example.demo.respository.companyRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class companyServiceilmp implements companyService {
    @Autowired
    companyRespository companyRespository;
    public company saveCompany(company company) {
        return companyRespository.save(company);
    }

    public company getCompany(Long id) {
        return companyRespository.findByCompanyId(id);
    }

    public void deleteCompany(company company) {
        companyRespository.delete(company);
    }

    public List<company> getAllCompany() {
        return(List<company>) companyRespository.findAll();
    }


}

