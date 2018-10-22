package com.finch.demo.repository;

import com.finch.demo.model.News;
import com.finch.demo.model.User;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
public  interface NewsRepositoryCustom {

	public List<News> getLimitedAllNews(int pageNumber);
}
