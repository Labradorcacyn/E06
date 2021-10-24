package com.e06Cynthia.ejercicio2.repository;

import com.e06Cynthia.ejercicio2.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video,Long> {
}
