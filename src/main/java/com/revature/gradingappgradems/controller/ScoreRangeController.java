package com.revature.gradingappgradems.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.gradingappgradems.dto.Message;
import com.revature.gradingappgradems.exception.ServiceException;
import com.revature.gradingappgradems.model.ScoreRange;
import com.revature.gradingappgradems.service.ScoreRangeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("ScoreRange")
public class ScoreRangeController {

	@Autowired 
	ScoreRangeService scorerangeService;

	@GetMapping("/update")
	@ApiOperation(value = "ScoreRange API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated", response = ScoreRange.class),
			@ApiResponse(code = 400, message = "Invalid Credentials", response = Message.class) })
	public ResponseEntity<?> range(@RequestParam("id1") int id1,@RequestParam("min1") int min1, @RequestParam("max1") int max1, @RequestParam("grade1") String grade1,
			@RequestParam("id2") int id2,@RequestParam("min2") int min2, @RequestParam("max2") int max2, @RequestParam("grade2") String grade2,
			@RequestParam("id3") int id3,@RequestParam("min3") int min3, @RequestParam("max3") int max3, @RequestParam("grade3") String grade3,
			@RequestParam("id4") int id4,@RequestParam("min4") int min4,	@RequestParam("max4") int max4, @RequestParam("grade4") String grade4) {
		String errorMessage = null; 

		ScoreRange range1 = new ScoreRange();
		range1.setId(id1);
		range1.setMin(min1);
		range1.setMax(max1);
		range1.setGrade(grade1);

		ScoreRange range2 = new ScoreRange();
		range2.setId(id2);
		range2.setMin(min2);
		range2.setMax(max2);
		range2.setGrade(grade2);

		ScoreRange range3 = new ScoreRange();
		range3.setId(id3);
		range3.setMin(min3);
		range3.setMax(max3);
		range3.setGrade(grade3);

		ScoreRange range4 = new ScoreRange();
		range4.setId(id4);
		range4.setMin(min4);
		range4.setMax(max4);
		range4.setGrade(grade4);

		List<ScoreRange> rangeList = new ArrayList<>();
		rangeList.add(range1);
		rangeList.add(range2);
		rangeList.add(range3);
		rangeList.add(range4);

		Message message = null;

		try {

			scorerangeService.detail(rangeList);
			return new ResponseEntity<>(message, HttpStatus.OK);
		} catch (Exception e) {
			errorMessage = e.getMessage();
			message = new Message(errorMessage);
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

		}
		
	}	


	
	@GetMapping("/{avg}")
	@ApiOperation(value = "ScoreRange API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully updated", response = String.class),
			@ApiResponse(code = 400, message = "Invalid Credentials", response = Message.class) })

	public ResponseEntity<?> getGrade(@PathVariable("avg") float avg) {
		
		String errorMessage = null; 
		String grade = null;
		Message message = null;

		try {

			grade = scorerangeService.findbyavg(avg);
			message = new Message(grade);
			return new ResponseEntity<>(grade, HttpStatus.OK);
		} catch (Exception e) {
			errorMessage = e.getMessage();
			message = new Message(errorMessage);
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

		}
	}
	
	@GetMapping("/viewscorerange")
	@ApiOperation(value = "viewScoreRange API")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ScoreRange.class),
			@ApiResponse(code = 400, message = "Invalid Credentials", response = Message.class) })
	public ResponseEntity<?> viewscorerange() throws ServiceException  {

		List<ScoreRange> list = null;
		String errorMessage = null;
		list = scorerangeService.findAllRange();
		Message message = null;
		if (list != null) {
			return new ResponseEntity<>(list, HttpStatus.OK);
		} else {
			message = new Message(errorMessage);
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}

}