package pl.altkom.tdd.sale.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.altkom.tdd.sale.model.SaleDocumentItem;

@Repository
public interface SaleDocumentItemRepo extends
		JpaRepository<SaleDocumentItem, Long> {

}
