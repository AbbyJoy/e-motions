package com.emotions.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emotions.core.model.Emotion;
import com.emotions.core.repository.EmotionRepository;

@Service
public class EmotionsService {
	
	@Autowired
	private EmotionRepository emotionRepository;

	
	public Emotion persistEmotion(Emotion emotion) {		
		Emotion dbEmotion = null;
		dbEmotion = getEmotionByName(emotion.getName());
		if(dbEmotion != null) {
			emotion.setId(dbEmotion.getId());	
		}
		return emotionRepository.save(emotion);
	}
	
	public Emotion getEmotionByName(String name) {
		return emotionRepository.findByName(name);
	}
	
	public List<Emotion> getEmotionsByGroup(String group) {
		return emotionRepository.findByGroup(group);
	}
	
	public List<Emotion> getAllEmotions() {
		return emotionRepository.findAll();
	}
}
