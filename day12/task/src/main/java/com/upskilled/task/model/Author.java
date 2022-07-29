package com.upskilled.task.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Author")
@Table(name = "author")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Author implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, insertable = false, unique = true)
  private Long id;

  @NotBlank
  @Column(name = "firstName", nullable = false, length = 50)
  private String firstName;

  @NotBlank
  @Column(name = "lastName", nullable = false, length = 50)
  private String lastName;

}
