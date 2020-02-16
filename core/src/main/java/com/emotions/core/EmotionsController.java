package com.emotions.core;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emotions.core.model.Emotion;
import com.emotions.core.service.EmotionsService;

@RestController
@RequestMapping("/emotions")
public class EmotionsController {
	
	@Autowired
	private EmotionsService emotionsService;
	
	@PostMapping
	public Emotion createEmotion(@RequestBody Emotion emotion) {
		emotionsService.persistEmotion(emotion);
		return emotion;
	}
	
	@GetMapping("/byName")
	public Emotion getEmotionByName(@RequestParam String name) {
		return emotionsService.getEmotionByName(name);
	}
	
	@GetMapping
	public List<Emotion> listEmotions(){
	    return emotionsService.getAllEmotions();
	 }
	
	
	
}
