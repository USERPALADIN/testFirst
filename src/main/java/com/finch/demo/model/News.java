package com.finch.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
public class News {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	@Column(name ="title", nullable = false)
	private String title;

	@Column(name="text", nullable = false)
	private  String text;
	
	public News(String title, String text) {
		this.title = title;
		this.text = text;
	}
	
	public News() {
	}
}
