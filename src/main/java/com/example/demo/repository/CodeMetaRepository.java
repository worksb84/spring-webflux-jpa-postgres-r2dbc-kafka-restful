package com.example.demo.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.CodeMeta;

@Repository
public interface CodeMetaRepository extends ReactiveCrudRepository<CodeMeta, Long> {

}
