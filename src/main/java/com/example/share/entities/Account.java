package com.example.share.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Builder
@Where(clause = "is_delete = false and is_statut = true")
public class Account extends BaseModel{
	
	@Column(unique = true,nullable = false)
	private String email;
	
	@Column
	private String nom;
	
	@Column
	private String prenom;
	
	@Column
	private String password;
	
	@Column
	private String telephone;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Role> roles = new HashSet<>();
}
