package pl.altkom.tdd.sale.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.test.annotation.DirtiesContext;

import pl.altkom.tdd.BaseIntegrationTest;
import pl.altkom.tdd.sale.model.SaleDocument;
import pl.altkom.tdd.sale.repo.OperationRegistryRepo;
import pl.altkom.tdd.sale.repo.SaleDocumentRepo;
import pl.altkom.tdd.sale.service.PromotionService;
import pl.altkom.tdd.sale.service.SaleDocumentService;

@Configuration
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class SaleDocumentServiceITTest extends BaseIntegrationTest {

	@Inject
	private SaleDocumentService service;
	@Inject
	private SaleDocumentRepo saleDocumentRepo;
	@Inject
	private OperationRegistryRepo operationRegistryRepo;

	@Test
	public void shouldSaveEmptyDocument() throws Exception {
		// given
		SaleDocument saleDocument = new SaleDocument();

		// when
		service.save(saleDocument);

		// them
		assertThat(saleDocumentRepo.count()).isEqualTo(1);
	}

	@Test
	public void shouldGenerateOperationRegistryWhenSavingDocument()
			throws Exception {
		// given
		SaleDocument saleDocument = new SaleDocument();

		// when
		service.save(saleDocument);

		// them
		assertThat(saleDocumentRepo.count()).isEqualTo(1);
		assertThat(operationRegistryRepo.count()).isEqualTo(1);
	}

	@Test
	public void shouldAddPromotion() throws Exception {
		// given
		SaleDocument saleDocument = new SaleDocument();

		// when
		service.save(saleDocument);

		// them
		assertThat(saleDocument.getTotalValue()).isEqualTo(new BigDecimal(-1));
	}

	@Primary
	@Bean
	public PromotionService yo(PromotionService bean) {
		PromotionService promotionService = spy(bean);
		when(promotionService.getPromotion()).thenReturn(BigDecimal.ONE);
		return promotionService;
	}

}
