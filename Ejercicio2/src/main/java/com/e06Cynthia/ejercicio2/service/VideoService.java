package com.e06Cynthia.ejercicio2.service;

import com.e06Cynthia.ejercicio2.model.Video;
import com.e06Cynthia.ejercicio2.repository.VideoRepository;
import com.e06Cynthia.ejercicio2.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class VideoService extends BaseService<Video, Long, VideoRepository> {
}
