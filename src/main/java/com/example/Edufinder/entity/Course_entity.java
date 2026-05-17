package com.example.Edufinder.entity;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.*;

@Entity
@CrossOrigin("*")
public class Course_entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String duration;
    private Double fees;
    private String level; 
    @Lob
    private String description;

    @Column(nullable = false)// Beginner / Advanced
    private Double rating = 4.0;

    @Lob
	private String image;

    @ManyToOne
    @JoinColumn(name = "institute_id")
    private Institute_entity institute;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Double getFees() {
		return fees;
	}

	public void setFees(Double fees) {
		this.fees = fees;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Institute_entity getInstitute() {
		return institute;
	}

	public void setInstitute(Institute_entity institute) {
		this.institute = institute;
	}

	@Override
	public String toString() {
		return "Course_entity [id=" + id + ", name=" + name + ", duration=" + duration + ", fees=" + fees + ", level="
				+ level + ", description=" + description + ", rating=" + rating + ", image=" + image + ", institute="
				+ institute + "]";
	}

	public Course_entity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course_entity(Integer id, String name, String duration, Double fees, String level, String description,
			Double rating, String image, Institute_entity institute) {
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.fees = fees;
		this.level = level;
		this.description = description;
		this.rating = rating;
		this.image = image;
		this.institute = institute;
	}

	
	
}
