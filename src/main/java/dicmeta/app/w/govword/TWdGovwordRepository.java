package dicmeta.app.w.govword;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TWdGovwordRepository extends JpaRepository<TWdGovword, Integer > {
	Page<TWdGovword> findByWordNmContaining(String searchValue,  Pageable pageable);
	Page<TWdGovword> findByWordEnAbbrContaining(String searchValue,  Pageable pageable);
	Page<TWdGovword> findByWordEnNmContaining(String searchValue,  Pageable pageable);
}
