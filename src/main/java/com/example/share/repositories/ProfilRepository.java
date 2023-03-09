package com.example.share.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.share.entities.Profil;

@Repository
public interface ProfilRepository extends JpaRepository<Profil, Long>{

	public Optional<Profil> findByUuid(String uuid);
	
	public Optional<Profil> findByUtilisateur_Email(String email);
	
	public Optional<Profil> findByNomUtilisateur(String nomUtilisateur);
}
