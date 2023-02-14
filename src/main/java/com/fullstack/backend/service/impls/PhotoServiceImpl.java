package com.fullstack.backend.service.impls;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.fullstack.backend.config.FlickrConfigurationConnect;
import com.fullstack.backend.service.PhotoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
@Slf4j
public class PhotoServiceImpl implements PhotoService {

    private final FlickrConfigurationConnect flickrConf = new FlickrConfigurationConnect();

    private final Flickr flickr = flickrConf.getCnxFlickr();

    @Override
    public String savePhoto(InputStream photo, String titre) throws FlickrException {
        UploadMetaData uploadMetaData = new UploadMetaData();
        uploadMetaData.setTitle(titre);
        String vPhotoId = flickr.getUploader().upload(photo, uploadMetaData);
        return flickr.getPhotosInterface().getPhoto(vPhotoId).getMedium640Url();
    }

}
