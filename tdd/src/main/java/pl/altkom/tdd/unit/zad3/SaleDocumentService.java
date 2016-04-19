package pl.altkom.tdd.unit.zad3;

import java.math.BigDecimal;

import pl.altkom.tdd.unit.zad2.SaleDocument;
import pl.altkom.tdd.unit.zad2.SaleDocumentItem;

public class SaleDocumentService {

	SaleDocumentRepo documentRepo;
	SaleDocumentItemRepo documentItemRepo;
	PromotionService promotionService;
	OperationRegistryService operationRegistry;

	public void save(SaleDocument saleDocument) {
		BigDecimal promotion = promotionService.getPromotion();
		save(saleDocument, promotion);
	}

	public void save(SaleDocument saleDocument, BigDecimal promotion) {
		this.documentRepo.save(saleDocument);

		for (SaleDocumentItem sdi : saleDocument.getItems()) {
			this.documentItemRepo.save(sdi);
		}

		if (promotion != null)
			saleDocument.setPromotion(promotion);

		operationRegistry.documentAdded(saleDocument);
	}
}
