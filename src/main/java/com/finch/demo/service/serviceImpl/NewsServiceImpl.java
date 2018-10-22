package com.finch.demo.service.serviceImpl;

import com.finch.demo.model.News;
import com.finch.demo.repository.NewsRepository;
import com.finch.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NewsServiceImpl implements NewsService {
	
	private final NewsRepository newsRepository;
	
	@Autowired
	public NewsServiceImpl(NewsRepository newsRepository) {
		this.newsRepository = newsRepository;
	}
	
	
	@Override
	public List<News> getAllNews() {
		return (List<News>) newsRepository.findAll();
	}
	
	@Override
	public News addNews(News n) {
		return newsRepository.save(n);
	}
	
	@Override
	public News getNewsById(UUID id) {
		return newsRepository.getNewsById(id);
	}
	
	
	@Override
	public News updateNews(News n) {
		return newsRepository.save(n);
	}
	
	@Override
	public void deleteNewsById(UUID id) {
		newsRepository.deleteById(id);
	}
	
	@Override
	public List<News> getLimitedAllNews(int page) {
		return newsRepository.getLimitedAllNews(page);
	}
}
