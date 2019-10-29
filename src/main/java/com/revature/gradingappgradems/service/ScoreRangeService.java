package com.revature.gradingappgradems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.gradingappgradems.dto.MessageConstant;
import com.revature.gradingappgradems.exception.ServiceException;
import com.revature.gradingappgradems.model.ScoreRange;
import com.revature.gradingappgradems.repository.ScoreRangeRepository;

@Service
public class ScoreRangeService {
	@Autowired
	ScoreRangeRepository scorerangerepository;

	@Transactional
	public void detail1(String grade, int min, int max) throws ServiceException {
		ScoreRange detail = new ScoreRange();
		detail.setGrade(grade);
		detail.setMin(min); 
		detail.setMax(max);
		detail = scorerangerepository.save(detail);
		if (detail == null) {
			throw new ServiceException(MessageConstant.INVALID);
		}
	}

	@Transactional
	public List<ScoreRange> findAllRange() throws ServiceException {
		List<ScoreRange> rangeList = null;
		rangeList = scorerangerepository.findAll();
		if (rangeList == null) {
			throw new ServiceException(MessageConstant.INVALID);
		}
		return rangeList;
	}

	@Transactional
	public void detail(List<ScoreRange> rangeList) {
		System.out.println("TestService" + rangeList);
		System.out.println("hello");

		try {

			for (ScoreRange ranges : rangeList) {

				ScoreRange range = scorerangerepository.findByGrade(ranges.getGrade());
				System.out.println("For" + ranges);
				scorerangerepository.updateById(ranges.getGrade(), ranges.getMin(), ranges.getMax(), ranges.getId());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Transactional
	public String findbyavg(float avg) throws ServiceException {
		String grade = scorerangerepository.findByAverage(avg);
		if (grade == null) {
			throw new ServiceException(MessageConstant.INVALID);
		}
		return grade;
	}
	
	
}
