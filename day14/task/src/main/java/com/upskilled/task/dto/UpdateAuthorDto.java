package com.upskilled.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAuthorDto {
  private Long id;
  private String firstName;
  private String lastName;
}
