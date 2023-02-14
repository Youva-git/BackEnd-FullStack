package com.fullstack.backend.utils;

import com.flickr4java.flickr.FlickrException;
import com.fullstack.backend.service.impls.PhotoServiceImpl;

import java.io.*;

public class TestFlickr {
    public static void main(String[] args) throws IOException, FlickrException {
        PhotoServiceImpl photoServiceImpls = new PhotoServiceImpl();
        InputStream stream = new FileInputStream(new File("/home/djellal/Bureau/produit/p3/p3.jpg"));
        String url = photoServiceImpls.savePhoto(stream, "produit");
        System.out.println(url);
    }
}
