package com.finch.demo.repository.impl;

import com.finch.demo.model.News;
import com.finch.demo.repository.UserRepository;
import com.finch.demo.repository.NewsRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class NewsRepositoryImpl implements NewsRepositoryCustom {
	
	private final EntityManager entityManager;
	private final UserRepository userRepository;
	
	@Value("10")
	private int pageSize;
	
	@Autowired
	public NewsRepositoryImpl(EntityManager entityManager, UserRepository userRepository) {
		this.entityManager = entityManager;
		this.userRepository = userRepository;
	}
	
	@Override
	public List<News> getLimitedAllNews(int pageNumber) {
		Query query = entityManager.createQuery("SELECT news FROM  News news ORDER BY  title");
		query.setFirstResult(pageNumber * pageSize);
		query.setMaxResults(pageSize);
		List<News> fooList = query.getResultList();
		return fooList;
	}
}
