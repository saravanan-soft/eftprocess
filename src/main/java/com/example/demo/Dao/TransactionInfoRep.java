package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.XmlFileClass.TransactionInfo;

public interface TransactionInfoRep extends JpaRepository<TransactionInfo, Integer> {

}
