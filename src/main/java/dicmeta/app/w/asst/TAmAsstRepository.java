package dicmeta.app.w.asst;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TAmAsstRepository extends JpaRepository<TAmAsst, Integer > {
	Page<TAmAsst> findByAsstNmContaining(String searchValue,  Pageable pageable); 			// 자산명
	Page<TAmAsst> findByAsstAccntNovContaining(String searchValue,  Pageable pageable);		// 자산회계번호
	Page<TAmAsst> findByAsstAccntSclasNmContaining(String searchValue,  Pageable pageable);	// 자산회계소분류명
	Page<TAmAsst> findByLocplcNmContaining(String searchValue,  Pageable pageable);			// 소재지명
	Page<TAmAsst> findByPsitnNmContaining(String searchValue,  Pageable pageable);			// 소속명
	Page<TAmAsst> findByFrstAcqsYmdContaining(String searchValue,  Pageable pageable);		// 최초취득일
}
