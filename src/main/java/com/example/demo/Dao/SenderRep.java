package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.XmlFileClass.Sender;

public interface SenderRep extends JpaRepository<Sender, Integer> {

}
