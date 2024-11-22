package com.sathya.mvc.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
	 @NotBlank(message = "Product name is required")
	    @Size(min = 2, max = 100, message = "Product name must be between 2 and 100 characters")
		private String proName;
	 @NotNull(message = "Product price is required")
	    @DecimalMin(value = "0.0", inclusive = false, message = "Product price must be greater than 0")
		private double proPrice;
	 @DecimalMin(value = "0.0", message = "Discounted price cannot be negative")
		private double disPrice;
	 @NotBlank(message = "Brand is required")
	    @Size(max = 50, message = "Brand name must not exceed 50 characters")
		private String proBrand;
	 @Size(max = 255, message = "Description must not exceed 255 characters")
		private String proDescription;
	 @NotBlank(message = "Category is required")
		private String proCategory;
	 		public String getProName() {
			return proName;
		}
		public void setProName(String proName) {
			this.proName = proName;
		}
		public double getProPrice() {
			return proPrice;
		}
		public void setProPrice(double proPrice) {
			this.proPrice = proPrice;
		}
		public double getDisPrice() {
			return disPrice;
		}
		public void setDisPrice(double disPrice) {
			this.disPrice = disPrice;
		}
		public String getProBrand() {
			return proBrand;
		}
		public void setProBrand(String proBrand) {
			this.proBrand = proBrand;
		}
		public String getProDescription() {
			return proDescription;
		}
		public void setProDescription(String proDescription) {
			this.proDescription = proDescription;
		}
		public String getProCategory() {
			return proCategory;
		}
		public void setProCategory(String proCategory) {
			this.proCategory = proCategory;
		}
	
		public String toString() {
			return "ProductModel [proName=" + proName + ", proPrice=" + proPrice + ", disPrice=" + disPrice
					+ ", proBrand=" + proBrand + ", proDescription=" + proDescription + ", proCategory=" + proCategory
					+ "]";
		}
		public Long getId() {
			
			return getId();
		}
		
		}
		


