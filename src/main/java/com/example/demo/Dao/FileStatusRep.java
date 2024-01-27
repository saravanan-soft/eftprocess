package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.XmlFileClass.fileStatus;

public interface FileStatusRep extends JpaRepository<fileStatus, Integer> {

}
