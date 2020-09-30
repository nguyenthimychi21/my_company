package com.example.demo.respository;

import com.example.demo.entity.project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface projectRepository extends CrudRepository <project,Long>{
project findByProjectId(Long id);
}
