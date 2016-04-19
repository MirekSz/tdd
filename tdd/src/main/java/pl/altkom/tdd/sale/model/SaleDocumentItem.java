package pl.altkom.tdd.sale.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SaleDocumentItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	Integer lp;

	BigDecimal quantity = BigDecimal.ZERO;
	BigDecimal price = BigDecimal.ZERO;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_SALE_DOCUMENT")
	SaleDocument saleDocument;

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
