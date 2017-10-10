package com.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
	@Entity
	@Table(name="Supplier_details")
	public class Supplier {
		@Id
		@Column(name="supid")
	    @GeneratedValue
	 private int id;
	 private String supplier_name;
	// @OneToMany(fetch=FetchType.EAGER,mappedBy="supplier")
	//private Set<Product>products=new HashSet<Product>(0);
	 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
}