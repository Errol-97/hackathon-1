package com.roknows.awsimageupload.datastore;

import com.roknows.awsimageupload.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileDataStore {
    private static final List<UserProfile> USER_PROFILES = new ArrayList<>();

    static{
        USER_PROFILES.add(new UserProfile(UUID.fromString("272d8eca-db2a-4a40-8c83-cc7dbb46dfe2"), "thagreatest", null));
        USER_PROFILES.add(new UserProfile(UUID.fromString("a5e20196-c942-466b-b084-34141da2a4b9"), "rorochester", null));
    }

    public List<UserProfile> getUserProfiles() {
        return USER_PROFILES;
    }

}
