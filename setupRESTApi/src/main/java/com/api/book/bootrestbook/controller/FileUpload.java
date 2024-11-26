package com.api.book.bootrestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.book.bootrestbook.helper.Helper;

import jakarta.servlet.Servlet;

@RestController
public class FileUpload {
	
	
	@Autowired
	private Helper uploadHelper;
	
	@PostMapping("/file-upload")
	public ResponseEntity<String> uploadFile(@RequestParam("images") MultipartFile file){
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize()/1024);
		
		try {
		
		if(file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Image should not be null");
		}
		if(!file.getContentType().equals("image/jpeg")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Image type should be jpeg format");
		}
		// passing helper method
		 boolean flag=uploadHelper.uploadFile(file);
		 if(flag) {
//			 return ResponseEntity.ok("  Image is uploaded SucessFully..");
			 
			 return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image").path(file.getOriginalFilename()).toUriString());
		 }
		 
		
		}catch (Exception e) {
		e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong please try again");
	}

}
