package pl.altkom.tdd.integration.zad4;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleDocumentRepo extends JpaRepository<SaleDocument, Long> {
	@Query("SELECT number FROM SaleDocument ORDER BY number")
	Integer getLastNumber();
}
