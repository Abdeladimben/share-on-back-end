package com.example.share.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
public class Post extends BaseModel{

	@Column
	private String text;
	
	@Lob
	@Type(type = "org.hibernate.type.BinaryType")
    @Column(length = 167772150)
    private byte[] image;
	
	@OneToMany
	private List<Likes> likes;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Profil profil;
	
}
