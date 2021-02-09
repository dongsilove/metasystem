package com.metasystem.repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.metasystem.domain.TWdGovword;
import com.metasystem.domain.TWdWord;

public interface TWdGovwordRepository extends JpaRepository<TWdGovword, Integer > {
	Page<TWdGovword> findByWordNmContaining(String wordNm, PageRequest pageRequest);
}
