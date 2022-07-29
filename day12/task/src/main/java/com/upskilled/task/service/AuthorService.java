package com.upskilled.task.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.upskilled.task.dto.CreateAuthorDto;
import com.upskilled.task.dto.DeleteAuthorDto;
import com.upskilled.task.dto.UpdateAuthorDto;
import com.upskilled.task.model.Author;
import com.upskilled.task.repository.AuthorRepository;
import com.upskilled.task.responsebody.ResponseBody;

import lombok.SneakyThrows;

@Service
@Transactional(rollbackOn = Exception.class)
public class AuthorService {

  @Autowired
  private AuthorRepository repository;

  @SneakyThrows(Exception.class)
  public ResponseEntity<Object> create(CreateAuthorDto dto) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    Author author = new Author();

    author.setFirstName(dto.getFirstName().trim());
    author.setLastName(dto.getLastName().trim());

    repository.save(author);

    ResponseBody res = new ResponseBody(true, "Berhasil simpan data", author);

    return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(res.getMap());
  }

  @SneakyThrows(Exception.class)
  public ResponseEntity<Object> get() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    List<Author> listAuthor = repository.findAll();

    ResponseBody res = new ResponseBody(true, "Berhasil Get Data", listAuthor);

    return ResponseEntity.status(HttpStatus.OK).headers(headers).body(res.getMap());
  }

  @SneakyThrows(Exception.class)
  public ResponseEntity<Object> update(UpdateAuthorDto dto) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    Author author = repository.findById(dto.getId()).orElse(new Author());

    if (author.getId() != null) {
      author.setFirstName(dto.getFirstName().trim());
      author.setLastName(dto.getLastName().trim());

      ResponseBody res = new ResponseBody(true, "Berhasil Update Data", null);

      return ResponseEntity.status(HttpStatus.OK).headers(headers).body(res.getMap());
    } else {
      ResponseBody res = new ResponseBody(false, "Data tidak ditemukan", null);

      return ResponseEntity.status(HttpStatus.OK).headers(headers).body(res.getMap());
    }
  }

  @SneakyThrows(Exception.class)
  public ResponseEntity<Object> delete(DeleteAuthorDto dto) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    Author author = repository.findById(dto.getId()).orElse(new Author());

    if (author.getId() != null) {
      repository.deleteById(dto.getId());

      ResponseBody res = new ResponseBody(true, "Berhasil Update Data", null);

      return ResponseEntity.status(HttpStatus.OK).headers(headers).body(res.getMap());
    } else {
      ResponseBody res = new ResponseBody(false, "Data tidak ditemukan", null);

      return ResponseEntity.status(HttpStatus.OK).headers(headers).body(res.getMap());
    }
  }
}
