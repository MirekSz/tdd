package pl.altkom.tdd.unit.zad3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import pl.altkom.tdd.unit.zad2.SaleDocument;
import pl.altkom.tdd.unit.zad2.SaleDocumentBuilder;
import pl.altkom.tdd.unit.zad2.SaleDocumentItem;
import pl.altkom.tdd.unit.zad3.OperationRegistryService;
import pl.altkom.tdd.unit.zad3.PromotionService;
import pl.altkom.tdd.unit.zad3.SaleDocumentItemRepo;
import pl.altkom.tdd.unit.zad3.SaleDocumentRepo;
import pl.altkom.tdd.unit.zad3.SaleDocumentService;

@RunWith(MockitoJUnitRunner.class)
public class SaleDocumentServiceTest {

	@InjectMocks
	private SaleDocumentService service = new SaleDocumentService();

	@Mock
	SaleDocumentRepo documentRepo;
	@Mock
	SaleDocumentItemRepo documentItemRepo;
	@Mock
	PromotionService promotionService;
	@Spy
	OperationRegistryService operationRegistry;

	@Before
	public void prepare() {
		// this.service.documentRepo = mock(SaleDocumentRepo.class);
		// this.service.documentItemRepo = mock(SaleDocumentItemRepo.class);
		// this.service.promotionService = mock(PromotionService.class);
		// this.service.operationRegistry = spy(OperationRegistryService.class);
	}

	@Test
	public void shouldSaveEmptyDocument() throws Exception {
		// given
		SaleDocument saleDocument = SaleDocumentBuilder.create().build();

		// when
		service.save(saleDocument);

		// them
		verify(this.service.documentRepo).save(saleDocument);
	}

	@Test
	public void shouldSaveDocumentWithItems() throws Exception {
		// given
		SaleDocument saleDocument = SaleDocumentBuilder.create()
				.withItem("2.2", "0.45").withItem("3.2", "12.45")
				.withItem("1.95", "2.15").build();

		// when
		service.save(saleDocument);

		// them
		verify(this.service.documentRepo).save(saleDocument);
		verify(this.service.documentItemRepo, times(3)).save(
				any(SaleDocumentItem.class));

	}

	@Test
	public void shouldSaveDocumentWithPromotion() throws Exception {
		// given
		BigDecimal promotion = new BigDecimal("3.01");
		BigDecimal priceAfterPromotion = new BigDecimal("15.99");

		SaleDocument saleDocument = SaleDocumentBuilder.create()
				.withItem("1", "1").withItem("9", "2").build();

		// when
		when(service.promotionService.getPromotion()).thenReturn(promotion);
		service.save(saleDocument);

		// them
		ArgumentCaptor<SaleDocument> argument = ArgumentCaptor
				.forClass(SaleDocument.class);
		verify(this.service.documentRepo).save(argument.capture());

		assertThat(argument.getValue().getTotalValue()).isEqualTo(
				priceAfterPromotion);
	}

	@Test
	public void shouldNofityRegistryAboutAddingDocument() throws Exception {
		// given
		SaleDocument saleDocument = SaleDocumentBuilder.create().build();

		// when
		service.save(saleDocument);

		// them
		assertThat(this.service.operationRegistry.getRegistry()).hasSize(1);
		verify(this.service.operationRegistry).documentAdded(saleDocument);

	}
}
