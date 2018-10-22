package com.finch.demo.initializer;

import com.finch.demo.model.News;
import com.finch.demo.model.User;
import com.finch.demo.model.Role;
import com.finch.demo.service.NewsService;
import com.finch.demo.service.UserService;
import com.finch.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataInitializer {
	
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private NewsService newsService;
	
	public void init() {
		
		News news = new News("aa", "bbb");
		News news2 = new News("12", "cccc");
		News news3 = new News("123", "cccc");
		News news4 = new News("124", "cccc");
		News news5 = new News("125", "cccc");
		News news6 = new News("126", "cccc");
		News news7 = new News("127", "cccc");
		News news8 = new News("128", "cccc");
		News news9 = new News("129", "cccc");
		News news10 = new News("130", "cccc");
		News news11 = new News("131", "cccc");
		News news12 = new News("132", "cccc");
		News news13 = new News("abc", "cccc");
		News news14 = new News("sss", "cccc");
		newsService.addNews(news);
		newsService.addNews(news2);
		newsService.addNews(news3);
		newsService.addNews(news4);
		newsService.addNews(news5);
		newsService.addNews(news6);
		newsService.addNews(news7);
		newsService.addNews(news8);
		newsService.addNews(news9);
		newsService.addNews(news10);
		newsService.addNews(news11);
		newsService.addNews(news12);
		newsService.addNews(news13);
		newsService.addNews(news14);
		
		Role role1 = new Role("ADMIN");
		Role role2 = new Role("USER");
		Role role3 = new Role("EDITOR");
		roleService.addRole(role1);
		roleService.addRole(role2);
		roleService.addRole(role3);
		
		Role admin = roleService.getByName("ADMIN");
		Role user = roleService.getByName("USER");
		Role editor = roleService.getByName("EDITOR");
		
		
		List<Role> roleList = new ArrayList<>();
		roleList.add(admin);
		roleList.add(user);
		roleList.add(editor);
		
		User user1 = new User("qwer", "qwer", roleList);
		User user2 = new User("q", "q", Arrays.asList(admin,user));
		userService.addUser(user1);
		userService.addUser(user2);
		
	}
}
