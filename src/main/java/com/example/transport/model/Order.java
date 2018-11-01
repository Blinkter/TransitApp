package com.example.transport.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	// -----------------------------------------------------------------------------
	@NotEmpty
	private String sourceAddress;
	// -----------------------------------------------------------------------------
	@NotEmpty
	private String destinationAddress;
	// -----------------------------------------------------------------------------
	private double price;
	// -----------------------------------------------------------------------------
	private double distance;
	// -----------------------------------------------------------------------------

	private LocalDate date;
	// -----------------------------------------------------------------------------

	public Order() {
	}

}
