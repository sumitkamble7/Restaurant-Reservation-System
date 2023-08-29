package com.app.entities;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cat_id;

	@NotBlank(message = "Category name is required")
	private String category;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Hotel> hotels;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int cat_id, @NotBlank(message = "Category name is required") String category) {
		super();
		this.cat_id = cat_id;
		this.category = category;
	}

	public int getCat_id() {
		return cat_id;
	}

	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Category [cat_id=" + cat_id + ", category=" + category + "]";
	}

}
