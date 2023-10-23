package org.corrigentia.fitrest.cpl.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.core.util.Json;

@RestController
@CrossOrigin(origins = { "http://localhost:4200" }, allowCredentials = "true", exposedHeaders = {
        "Access-Control-Allow-Origin" })
@RequestMapping(path = "/api", consumes = { jakarta.ws.rs.core.MediaType.MULTIPART_FORM_DATA })
public class FileUploadController {
    @PostMapping("/upload")
    // public ResponseEntity<String> uploadFile(
    public ResponseEntity<Json> uploadFile(
            // @RequestPart("name") String nom,
            @RequestPart("file") MultipartFile fichier

    ) {
        // System.out.println(nom);
        System.out.println("Got into the controller");

        // return new ResponseEntity<>("Upload successful", HttpStatus.OK);
        return new ResponseEntity<>(new Json(), HttpStatus.OK);
    }
}
