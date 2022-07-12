package com.nero.hua.controller;

import com.nero.hua.aop.LogAOP;
import com.nero.hua.config.ImageUploadConfig;
import com.nero.hua.model.base.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("image")
public class ImageController {

    @Autowired
    ImageUploadConfig imageUploadConfig;

    @PostMapping("/upload")
    @LogAOP.LogSkip
    public BaseResponse<String> upload(MultipartFile file, HttpServletRequest request) throws IOException {
        File direction = new File(imageUploadConfig.getRealPrefixPath());
        if (!direction.exists()) {
            direction.mkdirs();
        }

        long currentTimeMillis = System.currentTimeMillis();
        String newFileName= currentTimeMillis + file.getOriginalFilename();
        File newFile = new File(imageUploadConfig.getRealPrefixPath() + newFileName);

        file.transferTo(newFile);

        String url = imageUploadConfig.getVirtualPrefixPath() + newFileName;

        return new BaseResponse<>(url);
    }

    @GetMapping(path = "/{filename}", produces = { MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE })
    @LogAOP.LogSkip
    public BufferedImage download(@PathVariable("filename") String filename) throws IOException {
        File file = new File(imageUploadConfig.getRealPrefixPath(), filename);

        if (!file.exists()) {
            return null;
        }

        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedImage bufferedImage = ImageIO.read(fileInputStream);
        fileInputStream.close();
        return bufferedImage;
    }

}
