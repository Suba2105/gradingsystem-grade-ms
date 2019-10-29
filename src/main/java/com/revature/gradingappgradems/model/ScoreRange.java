package com.revature.gradingappgradems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "score_range")
public class ScoreRange {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name = "max ")
	private Integer max;

	@Column(name = "min")
	private Integer min;
	
	@Column(name = "grade")
	private String grade;

	
}


