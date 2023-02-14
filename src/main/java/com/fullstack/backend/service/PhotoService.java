package com.fullstack.backend.service;

import com.flickr4java.flickr.FlickrException;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

public interface PhotoService {
    String savePhoto(InputStream photo, String titre) throws FlickrException, IOException, ExecutionException, InterruptedException;
}
