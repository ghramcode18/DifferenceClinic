package com.example.difference_clinic.services;

import com.example.difference_clinic.entities.AboutCenterEntity;
import com.example.difference_clinic.repositories.AboutCenterRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AboutCenterService {

	@Autowired
	private AboutCenterRepo aboutCenterRepo;

	public AboutCenterEntity getAboutCenter() {

		return aboutCenterRepo.findById(1);
	}

	public AboutCenterEntity updateAboutCenter(int id, AboutCenterEntity aboutCenterEntity) {
		try {
			return aboutCenterRepo.save(aboutCenterEntity);
		} catch (Exception e) {

		}
		return null;
	}
}
