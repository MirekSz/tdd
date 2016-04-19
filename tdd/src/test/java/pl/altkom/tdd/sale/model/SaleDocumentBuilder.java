package pl.altkom.tdd.sale.model;

import java.math.BigDecimal;

import pl.altkom.tdd.sale.model.SaleDocument;
import pl.altkom.tdd.sale.model.SaleDocumentItem;

public class SaleDocumentBuilder {
	private SaleDocument saleDocument;

	private SaleDocumentBuilder() {
		this.saleDocument = new SaleDocument();
	}

	public static SaleDocumentBuilder create() {
		return new SaleDocumentBuilder();
	}

	public SaleDocumentBuilder withItem(String quantity, String price) {
		SaleDocumentItem saleDocumentItem = new SaleDocumentItem();
		saleDocumentItem.setQuantity(new BigDecimal(quantity));
		saleDocumentItem.setPrice(new BigDecimal(price));
		this.saleDocument.getItems().add(saleDocumentItem);
		return this;
	}

	public SaleDocument build() {
		return this.saleDocument;
	}
}
