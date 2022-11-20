package com.roknows.awsaudioupload.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("*")
public class AudioDownloadController {

    private final AudioDownloadService audioDownloadService;

    @Autowired
    public AudioDownloadController(AudioDownloadService audioDownloadService) {
        this.audioDownloadService = audioDownloadService;
    }

    @PostMapping(
            path = "mp4/upload",
            consumes= MediaType.MULTIPART_FORM_DATA_VALUE,
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public void uploadUserProfileImage(@RequestParam("file") MultipartFile file) {
        audioDownloadService.uploadUserProfileImage(file);
    }
}
