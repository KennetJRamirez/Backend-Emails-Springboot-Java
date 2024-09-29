package com.example.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@RestController
@RequestMapping("/api/emails")
@CrossOrigin(origins = "*")
public class EmailController {

    @Autowired
    private EmailExtractorService emailExtractorService;

    @PostMapping("/extract")
    public ResponseEntity<List<String>> extractEmailsFromFile(@RequestParam("file") MultipartFile file) {
        try {
            List<String> emails = emailExtractorService.extractEmails(new InputStreamReader(file.getInputStream()));
            return ResponseEntity.ok(emails);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
