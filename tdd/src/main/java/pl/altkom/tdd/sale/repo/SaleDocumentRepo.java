package pl.altkom.tdd.sale.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.altkom.tdd.sale.model.SaleDocument;

@Repository
public interface SaleDocumentRepo extends JpaRepository<SaleDocument, Long> {
	@Query("SELECT number FROM SaleDocument ORDER BY number")
	Integer getLastNumber();
}
