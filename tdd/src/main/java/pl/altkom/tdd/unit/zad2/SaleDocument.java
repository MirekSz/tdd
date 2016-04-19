package pl.altkom.tdd.unit.zad2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SaleDocument {

	Long id;
	String number;

	BigDecimal totalValue;
	private BigDecimal promotion = BigDecimal.ZERO;

	List<SaleDocumentItem> items = new ArrayList<SaleDocumentItem>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
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

	public BigDecimal getPromotion() {
		return promotion;
	}

	public void setPromotion(BigDecimal promotion) {
		this.promotion = promotion;
	}
}
