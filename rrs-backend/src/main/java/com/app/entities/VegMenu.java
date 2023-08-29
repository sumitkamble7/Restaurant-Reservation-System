package com.app.entities;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "veg_menu")
public class VegMenu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "m_id")
	private int m_id;

	@NotBlank(message = "Item name is required")
	private String item;

	@DecimalMin(value = "0.0", message = "Price cannot be negative")
	private Double price;
	
//	// hotel
	@ManyToOne
	@JoinColumn(name = "hotel_id", referencedColumnName = "hotel_id")
	private Hotel hotel;

	public VegMenu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VegMenu(int m_id, @NotBlank(message = "Item name is required") String item,
			@DecimalMin(value = "0.0", message = "Price cannot be negative") Double price) {
		super();
		this.m_id = m_id;
		this.item = item;
		this.price = price;
	}

	public int getm_id() {
		return m_id;
	}

	public void setm_id(int m_id) {
		this.m_id = m_id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "VegMenu [m_id=" + m_id + ", item=" + item + ", price=" + price + "]";
	}



}
