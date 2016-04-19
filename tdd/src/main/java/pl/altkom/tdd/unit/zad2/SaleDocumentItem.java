package pl.altkom.tdd.unit.zad2;

import java.math.BigDecimal;

public class SaleDocumentItem {
	Long id;
	Integer lp;

	BigDecimal quantity = BigDecimal.ZERO;
	BigDecimal price = BigDecimal.ZERO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getLp() {
		return lp;
	}

	public void setLp(Integer lp) {
		this.lp = lp;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getTotalValue() {
		return quantity.multiply(price);
	}

}
