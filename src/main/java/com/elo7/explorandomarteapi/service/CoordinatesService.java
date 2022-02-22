package com.elo7.explorandomarteapi.service;

import org.springframework.stereotype.Service;

import com.elo7.explorandomarteapi.entity.Coordinates;
import com.elo7.explorandomarteapi.entity.enumerator.DirectionEnum;

@Service
public class CoordinatesService {
	
	public Coordinates movement(DirectionEnum direction, Coordinates coordinates) {
		switch (direction) {
			case N: return Coordinates.builder().x(coordinates.getX()).y(coordinates.getY() + 1).build();
			case S: return Coordinates.builder().x(coordinates.getX()).y(coordinates.getY() - 1).build();
			case W: return Coordinates.builder().x(coordinates.getX() - 1).y(coordinates.getY()).build();
			case E: return Coordinates.builder().x(coordinates.getX() + 1).y(coordinates.getY()).build();
			default: return coordinates;
		}
	}

}
