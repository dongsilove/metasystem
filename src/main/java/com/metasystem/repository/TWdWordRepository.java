package com.metasystem.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.metasystem.domain.TWdWord;


public interface TWdWordRepository extends JpaRepository<TWdWord, Integer > {
}
