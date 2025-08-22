package com.example.demo.domain;

import java.sql.Timestamp;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "code_metas")
public class CodeMeta {
    @Id
    private long id;
    private String pcode;
    private String ccode;
    private String descriptionKor;
    private String descriptionEng;
    private Timestamp createdAt;
}
