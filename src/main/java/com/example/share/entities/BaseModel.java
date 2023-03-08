package com.example.share.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	@Setter(AccessLevel.NONE)
	protected Long id;

	@Column(name = "code", nullable = true)
	protected String code;

	@Column
	protected String uuid;

	@Column
	protected String description;

	@Column(columnDefinition = "boolean default false")
	protected boolean isDelete;

	@Column(columnDefinition = "boolean default true")
	protected boolean isStatut;

	@CreationTimestamp
	protected LocalDateTime createDateTime;

	@UpdateTimestamp
	protected LocalDateTime updateDateTime;

	@PrePersist
	public void prePersist() {
		this.isDelete = false;
		this.isStatut = true;
		this.uuid = UUID.randomUUID().toString();
	}

	
}
