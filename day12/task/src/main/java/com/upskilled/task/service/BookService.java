package com.upskilled.task.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.upskilled.task.dto.CreateBookDto;
import com.upskilled.task.dto.DeleteBookDto;
import com.upskilled.task.dto.UpdateBookDto;
import com.upskilled.task.model.Book;
import com.upskilled.task.repository.BookRepository;
import com.upskilled.task.responsebody.ResponseBody;

import lombok.SneakyThrows;

@Service
@Transactional(rollbackOn = Exception.class)
public class BookService {

  @Autowired
  BookRepository repository;

  @SneakyThrows(Exception.class)
  public ResponseEntity<Object> create(CreateBookDto dto) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    Book book = new Book();

    book.setName(dto.getName().trim());
    book.setPage(dto.getPage());
    book.setAuthor_id(dto.getAuthor_id());

    repository.save(book);

    ResponseBody res = new ResponseBody(true, "Input data berhasil", null);

    return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res.getMap());

  }

  @SneakyThrows(Exception.class)
  public ResponseEntity<Object> getAll() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    List<Book> books = repository.findAll();

    ResponseBody res = new ResponseBody(true, "Get data berhasil", books);

    return ResponseEntity.status(HttpStatus.OK).headers(headers).body(res.getMap());
  }

  @SneakyThrows(Exception.class)
  public ResponseEntity<Object> delete(DeleteBookDto dto) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    Book book = repository.findById(dto.getId()).orElse(new Book());

    if (book.getId() != null) {
      repository.deleteById(dto.getId());

      ResponseBody res = new ResponseBody(true, "Berhasil Delete Data", null);

      return ResponseEntity.status(HttpStatus.OK).headers(headers).body(res.getMap());
    } else {
      ResponseBody res = new ResponseBody(false, "Data tidak ditemukan", null);

      return ResponseEntity.status(HttpStatus.OK).headers(headers).body(res.getMap());
    }
  }

  @SneakyThrows(Exception.class)
  public ResponseEntity<Object> update(UpdateBookDto dto) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    Book book = repository.findById(dto.getId()).orElse(new Book());

    if (book.getId() != null) {
      book.setName(dto.getName().trim());
      book.setAuthor_id(dto.getAuthor_id());
      book.setPage(dto.getPage());

      repository.save(book);

      ResponseBody res = new ResponseBody(true, "Update data berhasil", book);

      return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res.getMap());
    } else {
      ResponseBody res = new ResponseBody(false, "Data tidak ditemukan", null);
      return ResponseEntity.status(HttpStatus.OK).headers(headers).body(res.getMap());
    }
  }

}
