package pl.altkom.tdd.integration.zad4;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRegistryRepo extends
		JpaRepository<OperationRegistry, Long> {

}
