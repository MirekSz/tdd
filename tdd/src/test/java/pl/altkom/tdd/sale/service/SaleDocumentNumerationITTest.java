package pl.altkom.tdd.sale.service;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;

import org.junit.Test;

import pl.altkom.tdd.BaseIntegrationTest;
import pl.altkom.tdd.sale.model.SaleDocument;
import pl.altkom.tdd.sale.model.SaleDocumentItem;
import pl.altkom.tdd.sale.repo.OperationRegistryRepo;
import pl.altkom.tdd.sale.repo.SaleDocumentRepo;
import pl.altkom.tdd.sale.service.SaleDocumentService;

public class SaleDocumentNumerationITTest extends BaseIntegrationTest {

	@Inject
	private SaleDocumentService service;
	@Inject
	private SaleDocumentRepo saleDocumentRepo;
	@Inject
	private OperationRegistryRepo operationRegistryRepo;

	@Test
	public void shouldAssignNewNumberForDocument() throws Exception {
		// given
		SaleDocument saleDocument = new SaleDocument();

		// when
		service.save(saleDocument);

		// them
		assertThat(saleDocument.getNumber()).isNotNull();
	}

	@Test
	public void shouldAssignUniqueNumbers() throws Exception {
		// given
		SaleDocument saleDocument1 = new SaleDocument();
		SaleDocument saleDocument2 = new SaleDocument();

		// when
		service.save(saleDocument1);
		service.save(saleDocument2);

		// them
		assertThat(saleDocument1.getNumber()).isNotNull();
		assertThat(saleDocument2.getNumber()).isNotNull();

		assertThat(saleDocument1.getNumber()).isNotEqualTo(
				saleDocument2.getNumber());

		assertThat(saleDocument1.getNumber()).isLessThan(
				saleDocument2.getNumber());
	}

	@Test
	public void shouldAssignNewNumberForItem() throws Exception {
		// given
		SaleDocument saleDocument = new SaleDocument();
		SaleDocumentItem saleDocumentItem = new SaleDocumentItem();
		saleDocument.getItems().add(saleDocumentItem);

		// when
		service.save(saleDocument);

		// them
		assertThat(saleDocumentItem.getLp()).isNotNull();
	}

	@Test
	public void shouldAssignNewNumberForItemInsideDocument() throws Exception {
		// given
		SaleDocument saleDocument = new SaleDocument();
		SaleDocumentItem saleDocumentItem = new SaleDocumentItem();
		saleDocument.getItems().add(saleDocumentItem);

		SaleDocument saleDocument2 = new SaleDocument();
		SaleDocumentItem saleDocumentItem2 = new SaleDocumentItem();
		saleDocument2.getItems().add(saleDocumentItem2);

		// when
		service.save(saleDocument);
		service.save(saleDocument2);

		// them
		assertThat(saleDocumentItem.getLp()).isNotNull();
		assertThat(saleDocumentItem2.getLp()).isNotNull();
		assertThat(saleDocumentItem.getLp()).isEqualTo(
				saleDocumentItem2.getLp());
	}
}
