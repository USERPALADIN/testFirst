package com.finch.demo.service;

import com.finch.demo.model.News;

import java.util.List;
import java.util.UUID;

public interface NewsService {
	
	List<News> getAllNews();
	
	News addNews(News n);
	
	News getNewsById(UUID id);
	
	News updateNews(News n);
	
	void deleteNewsById(UUID id);
	
	List<News> getLimitedAllNews(int page);
}
