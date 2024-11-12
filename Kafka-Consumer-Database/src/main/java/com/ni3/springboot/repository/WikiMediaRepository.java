package com.ni3.springboot.repository;

import com.ni3.springboot.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikiMediaRepository  extends JpaRepository<WikimediaData,Integer> {
}
