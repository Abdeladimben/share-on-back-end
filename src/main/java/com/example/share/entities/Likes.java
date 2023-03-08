package com.example.share.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
@Where(clause = "is_delete = false and is_statut = true")
public class Likes extends BaseModel{

}
