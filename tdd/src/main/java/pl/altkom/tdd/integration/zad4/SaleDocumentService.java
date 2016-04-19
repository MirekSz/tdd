package pl.altkom.tdd.integration.zad4;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class SaleDocumentService {
	@Inject
	SaleDocumentRepo documentRepo;
	@Inject
	SaleDocumentItemRepo documentItemRepo;
	@Inject
	PromotionService promotionService;
	@Inject
	OperationRegistryService operationRegistryService;

	public void save(SaleDocument saleDocument) {
		BigDecimal promotion = promotionService.getPromotion();
		save(saleDocument, promotion);
	}

	public void save(SaleDocument saleDocument, BigDecimal promotion) {
		Integer lastNumber = this.documentRepo.getLastNumber();
		if (lastNumber == null) {
			saleDocument.setNumber(1);
		} else {
			saleDocument.setNumber(++lastNumber);
		}

		this.documentRepo.save(saleDocument);

		for (int i = 0; i < saleDocument.getItems().size(); i++) {
			SaleDocumentItem sdi = saleDocument.getItems().get(i);
			sdi.setLp(i + 1);
			this.documentItemRepo.save(sdi);
		}

		if (promotion != null)
			saleDocument.setPromotion(promotion);

		operationRegistryService.documentAdded(saleDocument);
	}
}
