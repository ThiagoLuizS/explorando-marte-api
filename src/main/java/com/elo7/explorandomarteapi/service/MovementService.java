package com.elo7.explorandomarteapi.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elo7.explorandomarteapi.entity.Coordinates;
import com.elo7.explorandomarteapi.entity.Movement;
import com.elo7.explorandomarteapi.entity.enumerator.DirectionEnum;

@Service
public class MovementService {
	
	private static String right = "R";
	private static String left = "L";
	
	@Autowired
	private DirectionService directionService;
	
	@Autowired
	private CoordinatesService coordinatesService;
	
	public boolean isRight(String value) {
		return StringUtils.equals(value, right);
	}
	
	public boolean isLeft(String value) {
		return StringUtils.equals(value, left);
	}
	
	public Movement movement(Movement movement) {
		
		movement.getMovements().stream().forEach(m -> {
			DirectionEnum direction = movement.getSonda().getDirection();
			Coordinates coordinates = movement.getSonda().getCoordinates();
			
			if(isRight(m)) {
				movement.getSonda().setDirection(directionService.rotate90DegreesRight(direction));
			} else if(isLeft(m)) {
				movement.getSonda().setDirection(directionService.rotate90DegreesLeft(direction));
			} else {
				movement.getSonda().setCoordinates(coordinatesService.movement(direction, coordinates));
			}
			
		});
		
		return movement; 
	}
}
