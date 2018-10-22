package com.finch.demo.repository;

import com.finch.demo.model.News;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
@Transactional
public interface NewsRepository extends CrudRepository<News, UUID>, NewsRepositoryCustom {
	
	News getNewsById(UUID id);
	
}
