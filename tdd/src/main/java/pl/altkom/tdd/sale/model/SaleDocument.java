package pl.altkom.tdd.sale.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SaleDocument {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	Integer number;
	BigDecimal totalValue;

	@OneToMany(mappedBy = "saleDocument")
	List<SaleDocumentItem> items = new ArrayList<SaleDocumentItem>();

	private BigDecimal promotion = BigDecimal.ZERO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public List<SaleDocumentItem> getItems() {
		return items;
	}

	public void setItems(List<SaleDocumentItem> items) {
		this.items = items;
	}

	public BigDecimal getTotalValue() {
		BigDecimal result = BigDecimal.ZERO;
		for (SaleDocumentItem saleDocumentItem : items) {
			result = result.add(saleDocumentItem.getTotalValue());
		}
		return result.subtract(promotion);
	}

	public void setPromotion(BigDecimal promotion) {
		this.promotion = promotion;

	}

}
