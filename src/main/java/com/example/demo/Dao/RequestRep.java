package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.XmlFileClass.Receiver;
import com.example.demo.XmlFileClass.Request;

public interface RequestRep extends JpaRepository<Request, Integer>{

}
