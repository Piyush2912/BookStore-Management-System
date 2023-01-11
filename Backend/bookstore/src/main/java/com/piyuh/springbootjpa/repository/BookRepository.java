package com.piyuh.springbootjpa.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.piyuh.springbootjpa.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

}
