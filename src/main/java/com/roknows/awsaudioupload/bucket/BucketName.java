package com.roknows.awsaudioupload.bucket;

public enum BucketName {
    PROFILE_IMAGE("roknows-hackathon-1");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
