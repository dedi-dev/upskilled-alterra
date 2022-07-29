package com.upskilled.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateBookDto {
  private Long id;
  private String name;
  private Long page;
  private Long author_id;
}
