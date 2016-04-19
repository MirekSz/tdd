package pl.altkom.tdd.integration.zad4;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class OperationRegistryService {
	@Inject
	OperationRegistryRepo repo;

	public void documentAdded(SaleDocument saleDocument) {
		OperationRegistry operationRegistry = new OperationRegistry(
				saleDocument.toString());
		repo.save(operationRegistry);
	}

}
