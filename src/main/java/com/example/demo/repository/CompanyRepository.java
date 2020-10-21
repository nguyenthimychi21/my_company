package com.example.demo.repository;

import com.example.demo.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Long> {
    List<Company> findByPhone(int phone);

    List<Company> findByPhoneAndUrl(int phone, String url);

    @Query("SELECT c FROM Company c WHERE c.url LIKE  :key_word ")
    List<Company> findByUrlLike(@Param(value = "key_word") String keyWords);


}
