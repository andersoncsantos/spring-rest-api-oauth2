package br.com.codenation.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.codenation.entity.Log;

@Repository
public interface LogRepository extends PagingAndSortingRepository<Log, Long> {

	@Query("FROM Log l WHERE l.environment = :e AND l.level like %:q% AND l.archived = :a")
	Page<Log> filterByLevel(@Param("e") String environment, @Param("q") String search, @Param("a") boolean archived,
			Pageable pageable);

	@Query("FROM Log l WHERE l.environment = :e AND l.description like %:q% AND l.archived = :a")
	Page<Log> filterByDescription(@Param("e") String environment, @Param("q") String search, @Param("a") boolean archived, Pageable pageable);

	@Query("FROM Log l WHERE l.environment = :e AND l.source like %:q% AND l.archived = :a")
	Page<Log> filterBySource(@Param("e") String environment, @Param("q") String search, @Param("a") boolean archived,
			Pageable pageable);
}
