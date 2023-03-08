package com.example.share.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.share.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
	
	public Optional<Post> findByUuid(String uuid);
	
	public Page<Post> findAllByOrderByIdAsc(Pageable pageable);
	
}
