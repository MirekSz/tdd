package pl.altkom.tdd.sale.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import pl.altkom.tdd.sale.model.SaleDocument;

@Service
public class OperationRegistryService {
	private List<SaleDocument> registry = new LinkedList<SaleDocument>();

	public void documentAdded(SaleDocument saleDocument) {
		this.getRegistry().add(saleDocument);
	}

	public List<SaleDocument> getRegistry() {
		return registry;
	}

}
