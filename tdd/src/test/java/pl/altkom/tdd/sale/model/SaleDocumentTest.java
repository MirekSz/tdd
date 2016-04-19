package pl.altkom.tdd.sale.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;

import pl.altkom.tdd.sale.model.SaleDocument;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(DataProviderRunner.class)
public class SaleDocumentTest {
	@Test
	public void shouldCalculateValueWithOneItem() throws Exception {
		// given
		SaleDocument saleDocument = SaleDocumentBuilder.create()
				.withItem("2.2", "0.45").build();

		// when
		BigDecimal value = saleDocument.getTotalValue();

		// them
		assertThat(value).isEqualByComparingTo("0.99");
	}

	@Test
	public void shouldCalculateValueWithManyItems() throws Exception {
		// given
		SaleDocument saleDocument = SaleDocumentBuilder.create()
				.withItem("2.2", "0.45").withItem("3.2", "12.45")
				.withItem("1.95", "2.15").build();

		// when
		BigDecimal value = saleDocument.getTotalValue();

		// them
		assertThat(value).isEqualByComparingTo("45.0225");
	}

	@DataProvider
	public static Object[][] dataProviderAdd() {
		return new Object[][] { { 0, 0, 0 }, { 1, 1, 2 }, };
	}

	@Test
	@UseDataProvider("dataProviderAdd")
	public void testAdd(int a, int b, int expected) {
		// Given:

		// When:
		int result = a + b;

		// Then:
		assertThat(expected).isEqualTo(result);
	}

}
