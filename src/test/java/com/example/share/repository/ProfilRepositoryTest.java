package com.example.share.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.mockito.ArgumentMatchers.anyString;
import com.example.share.entities.Profil;
import com.example.share.repositories.ProfilRepository;

//@DataJpaTest
public class ProfilRepositoryTest {
	
/*	@Autowired
	ProfilRepository profilRepositoryUnderTest;
	
	@AfterEach
	void tearDown() {
		profilRepositoryUnderTest.deleteAll();
	}
	

	@Test
	void WhenGetOptionalProfilByUuidThenProfilIsPresent() {
		
		//	GETTER
		
		Profil profil=new Profil();
		profil.setNomUtilisateur("abdeladim");
		profil.setAdresse("Casablanca");
		profil.setGenre("M");
		Profil profilSaved=profilRepositoryUnderTest.save(profil);
		
		//	WHEN
		
		Optional<Profil> profilTested=profilRepositoryUnderTest.findByUuid(profilSaved.getUuid());
		
		//	THEN
		
		assertThat(profilTested.isPresent()).isTrue();
	}
	
	@Test
	void WhenGetOptionalProfilByUuidThenProfilIsNotPresent() {
	
		//	WHEN
		
		Optional<Profil> profilTested=profilRepositoryUnderTest.findByUuid(anyString());
		
		//	THEN
		
		assertThat(profilTested.isPresent()).isFalse();
	}
	
*/

}
