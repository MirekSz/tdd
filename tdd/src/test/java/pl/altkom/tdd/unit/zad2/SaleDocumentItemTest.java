package pl.altkom.tdd.unit.zad2;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

import pl.altkom.tdd.unit.zad2.SaleDocumentItem;

public class SaleDocumentItemTest {
	@Test
	public void emptyItemShouldHasValue() throws Exception {
		// given
		SaleDocumentItem saleDocumentItem = new SaleDocumentItem();

		// when
		BigDecimal value = saleDocumentItem.getTotalValue();

		// them
		assertThat(value).isEqualTo(BigDecimal.ZERO);
	}

	@Test
	public void shouldCalculateValue() throws Exception {
		// given
		BigDecimal quantity = BigDecimal.valueOf(7.0);
		BigDecimal price = BigDecimal.valueOf(0.99);
		BigDecimal expected = BigDecimal.valueOf(6.93);

		SaleDocumentItem saleDocumentItem = new SaleDocumentItem();

		// when
		saleDocumentItem.setQuantity(quantity);
		saleDocumentItem.setPrice(price);
		BigDecimal value = saleDocumentItem.getTotalValue();

		// them
		assertThat(value).isEqualByComparingTo(expected);
	}

}
