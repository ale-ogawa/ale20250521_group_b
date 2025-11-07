package com.example.webapp.utility;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public class ImagesPath {
	
	public Map<Integer, String> images = new HashMap<>();
	
	public ImagesPath(){
		images.put(1, "/img/niko01_circle.png");
		images.put(2, "/img/niko02_circle.png");
		images.put(3, "/img/niko03_circle.png");
		images.put(4, "/img/niko04_circle.png");
		images.put(5, "/img/niko05_circle.png");
	}

}
