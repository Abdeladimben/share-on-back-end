package com.example.share.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Where(clause = "is_delete = false and is_statut = true")
public class Profil extends BaseModel{

	@Column(unique = true,nullable = false)
	private String nomUtilisateur;
	
	@Lob
	@Type(type = "org.hibernate.type.BinaryType")
    @Column(length = 167772150)
    private byte[] photoProfil;
	
	@Column
	private String adresse;
	
	@Column
	private String genre;
	
	@Column
	private LocalDate dateNaissance; 
	
	@OneToOne
	private User utilisateur;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Post> posts;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "profil_abonne", inverseJoinColumns = @JoinColumn(name = "abonne_id"))
	List<Profil> profilsAbonne;
	
	
}
