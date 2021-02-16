package dicmeta.app.w.term;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TWdTermRepository extends JpaRepository<TWdTerm, Integer> {
	Page<TWdTerm> findByTermNmContaining(String searchWord, Pageable pageable);
	Page<TWdTerm> findByTermEnAbbrContaining(String searchWord, Pageable pageable);
	Page<TWdTerm> findByTermEnNmContaining(String searchWord, Pageable pageable);
}
