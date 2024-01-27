package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.XmlFileClass.MessageInfo;



public interface MessageInfoRep extends JpaRepository<MessageInfo, Integer> {

}
