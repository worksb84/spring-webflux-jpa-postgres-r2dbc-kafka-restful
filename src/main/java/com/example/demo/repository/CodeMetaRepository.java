package com.example.demo.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.example.demo.domain.CodeMeta;

public interface CodeMetaRepository extends ReactiveCrudRepository<CodeMeta, Long> {

}
