package com.upskilled.task.responsebody;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBody {
  private Boolean success;
  private String message;
  private Object data;

  public Map<String, Object> getMap() {
    Map<String, Object> res = new HashMap<>();
    res.put("success", success);
    res.put("message", message);

    if (data != null) {
      res.put("data", data);
    }

    return res;
  }
}
