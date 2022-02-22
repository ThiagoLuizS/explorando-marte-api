package com.elo7.explorandomarteapi.service;

import org.springframework.stereotype.Service;

import com.elo7.explorandomarteapi.entity.enumerator.DirectionEnum;

@Service
public class DirectionService {

	public DirectionEnum rotate90DegreesLeft(DirectionEnum direction) {
		switch (direction) {
			case N: return DirectionEnum.W;
			case S: return DirectionEnum.E;
			case E:	return DirectionEnum.N;
			case W:	return DirectionEnum.S;
			default: return null;
		}
	}

	public DirectionEnum rotate90DegreesRight(DirectionEnum direction) {
		switch (direction) {
			case N: return DirectionEnum.E;
			case S: return DirectionEnum.W;
			case E:	return DirectionEnum.S;
			case W:	return DirectionEnum.N;
		default: return null;
		}
	}
}
