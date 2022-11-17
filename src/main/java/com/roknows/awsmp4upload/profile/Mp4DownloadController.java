package com.roknows.awsmp4upload.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("*")
public class Mp4DownloadController {

    private final Mp4DownloadService mp4DownloadService;

    @Autowired
    public Mp4DownloadController(Mp4DownloadService mp4DownloadService) {
        this.mp4DownloadService = mp4DownloadService;
    }

    @PostMapping(
            path = "mp4/upload",
            consumes= MediaType.MULTIPART_FORM_DATA_VALUE,
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public void uploadUserProfileImage(@PathVariable("userProfileId") UUID userProfileId,
                                       @RequestParam("file") MultipartFile file) {
        mp4DownloadService.uploadUserProfileImage(userProfileId, file);
    }
}
