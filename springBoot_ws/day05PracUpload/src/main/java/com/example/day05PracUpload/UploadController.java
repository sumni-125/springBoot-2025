package com.example.day05PracUpload;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.UUID;

@Controller
public class UploadController {

    @GetMapping("/uploadForm")
    public String uploadForm(){
        return "uploadForm";
    }

    @PostMapping("/upload")
    public String upload(
            @RequestParam(name="goodsName") String goodsName,
            @RequestParam(name="file") MultipartFile file,
            Model model
    ) throws MalformedURLException {
        System.out.println(goodsName);
        System.out.println(file.getOriginalFilename());
        String fileOriginName=file.getOriginalFilename();

        String uuid = UUID.randomUUID().toString();
        int index = fileOriginName.lastIndexOf(".");
        String ext = fileOriginName.substring(index+1);
        String saveName = uuid+"."+ext;

        System.out.println(saveName);

        String path="c:\\test\\upload\\";
        try {
            file.transferTo(new File(path+saveName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("fileName",saveName);
        return "uploadOK";
    }

    /*@ResponseBody
    @GetMapping("/images/{fileName}")
    public Resource image(@PathVariable(name="fileName") String fileName) throws MalformedURLException {
        return new UrlResource("file:c:\\test\\upload\\"+fileName);
    }*/

    @ResponseBody
    @GetMapping("/images/{fileName:.*}")
    public ResponseEntity<Resource> images(@PathVariable(name="fileName") String fileName) throws MalformedURLException {
        System.out.println("djfdkfkfkfvkkg="+fileName);

        Resource reSource = new UrlResource("file:c:\\test\\upload\\"+fileName);
        return ResponseEntity.ok().body(reSource);
    }

}
