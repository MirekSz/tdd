package pl.altkom.tdd.unit.zad3;

import java.util.LinkedList;
import java.util.List;

import pl.altkom.tdd.unit.zad2.SaleDocument;

public class OperationRegistryService {
	private List<SaleDocument> registry = new LinkedList<SaleDocument>();

	public void documentAdded(SaleDocument saleDocument) {
		this.getRegistry().add(saleDocument);
	}

	public List<SaleDocument> getRegistry() {
		return registry;
	}

}
