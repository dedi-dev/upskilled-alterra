package com.upskilled.task.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Book")
@Table(name = "book")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, insertable = false, unique = true)
  private Long id;

  @NotBlank
  @Column(name = "name", nullable = false, length = 255)
  private String name;

  @NotNull
  @Column(name = "page", nullable = false)
  private Long page;

  @NotNull
  @Column(name = "author_id", nullable = false)
  private Long author_id;
}
