package Inheritance;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product extends Store {
	int ProductId;
	String ProductName;
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	
}
