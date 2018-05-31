package com.prabu.myrestfulapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prabu.myrestfulapi.entity.Title;
import com.prabu.myrestfulapi.entity.TitlePK;

@Repository
public interface TitleRepository extends JpaRepository<Title, TitlePK>{

}

