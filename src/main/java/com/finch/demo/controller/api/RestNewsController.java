package com.finch.demo.controller.api;

import com.finch.demo.model.News;
import com.finch.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/news")
public class RestNewsController {
	
	private final NewsService newsService;
	
	@Autowired
	public RestNewsController(NewsService newsService) {
		this.newsService = newsService;
	}
	
	@PreAuthorize("hasRole('EDITOR')")
	@PostMapping(value = "/create")
	public News create(@RequestBody News news) {
		return newsService.addNews(news);
	}
	
	@GetMapping
	public List<News> getNews(@RequestParam(value = "page",required = false) Integer page) {
		
		if (page == null){
			page = 0;
		}
		
		return 	newsService.getLimitedAllNews(page);
	}
	
}
