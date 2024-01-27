package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.XmlFileClass.Receiver;

public interface ReceiverRep extends JpaRepository<Receiver, Integer> {

}
