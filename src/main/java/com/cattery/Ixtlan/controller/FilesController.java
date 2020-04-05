package com.cattery.Ixtlan.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Controller
public class FilesController {

  @Value("${upload.path}")
  private String uploadPath;

  @GetMapping("/files")
  public String filesPage(Map<String, Object> model) {
    return "files";
  }

  @PostMapping("/files")
  public String addFiles(@RequestParam("file") MultipartFile file) throws IOException {

    if (file != null && !file.getOriginalFilename().isEmpty()) {
      File uploadDir = new File(uploadPath);

      if (!uploadDir.exists()) {
        uploadDir.mkdir();
      }

      String uuidFile = UUID.randomUUID().toString();
      String resultFilename = uuidFile + "." + file.getOriginalFilename();

      file.transferTo(new File(uploadPath + "/" + resultFilename));

    }

    return "files";
  }

}
