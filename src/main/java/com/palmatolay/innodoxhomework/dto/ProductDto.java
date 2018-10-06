package com.palmatolay.innodoxhomework.dto;

/**
 * Product data transfer object responsible to transfer data from the web layer to the service layer
 */
public class ProductDto {
	private String name;
	private String ownerEmail;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}
}
