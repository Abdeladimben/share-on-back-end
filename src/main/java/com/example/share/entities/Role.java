package com.example.share.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.example.share.enums.Roles;

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
public class Role extends BaseModel{
	
	@Column
	private String libelle;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Roles nom;

}
