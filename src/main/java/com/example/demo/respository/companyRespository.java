package com.example.demo.respository;

import com.example.demo.entity.company;
import org.springframework.data.repository.CrudRepository;

public interface companyRespository extends CrudRepository<company,Long> {
    company findByCompanyId(Long id);
}
