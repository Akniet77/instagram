package com.example.instagram.model;

import android.net.Uri;

public class Post {
    private Uri profile;
    private String name;
    private Uri image;

    public Post(Uri profile, String name, Uri image) {
        this.profile = profile;
        this.name = name;
        this.image = image;
    }

    public Uri getProfile() {
        return profile;
    }

    public String getName() {
        return name;
    }

    public Uri getImage() {
        return image;
    }
}
