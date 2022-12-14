package com.roknows.awsaudioupload.profile;

import com.roknows.awsaudioupload.bucket.BucketName;
import com.roknows.awsaudioupload.filestore.FileStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class AudioDownloadService {

    private final FileStore fileStore;

    @Autowired
    public AudioDownloadService(FileStore fileStore) {
        this.fileStore = fileStore;
    }



    public void uploadUserProfileImage( MultipartFile file) {
        //1. check if image is not empty

        //2. check if file is an image
        //3. check whether user exists in database
        //4. Grab some metadata from file if any
        //5. store image in s3 and update database (userProfileImageLink) with s3 image link
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload empty file [ " + file.getSize() + " ]");
        }

        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));

        String path = String.format("%s", BucketName.PROFILE_IMAGE.getBucketName());
        String filename = String.format("%s-%s", UUID.randomUUID(), file.getOriginalFilename());

        try{
            fileStore.save(path, filename, Optional.of(metadata), file.getInputStream());
        }catch (IOException e){
            throw new IllegalStateException(e);
        }

    }


}
