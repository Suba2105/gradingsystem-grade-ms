package com.revature.gradingappgradems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.gradingappgradems.model.ScoreRange;

@Repository
public interface ScoreRangeRepository extends JpaRepository<ScoreRange, String>{
	
	@Query(value="select get_grade(:avg)", nativeQuery = true)
	String findByAverage(@Param("avg")float avg);

	@Modifying
	@Query(value="update score_range  set grade =:grade,min =:min,max =:max where id = :id",nativeQuery = true)
	Integer updateById(@Param("grade") String grade,
	@Param("min") int min,
	@Param("max") int max,
	@Param("id") int id);
	
	@Query("from ScoreRange  where grade = ?1")
	ScoreRange findByGrade(String grade);

}
