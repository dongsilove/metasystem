package dicmeta.app.w.domain;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TWdDomainRepository extends JpaRepository<TWdDomain, Integer> {
	Page<TWdDomain> findByDomainNmContaining(String searchValue,  Pageable pageable);
	List<TWdDomain> findByDomainNmContaining(String searchValue);
	Page<TWdDomain> findByDomainEnAbbrContaining(String searchValue,  Pageable pageable);
	Page<TWdDomain> findByDomainEnNmContaining(String searchValue,  Pageable pageable);
}
