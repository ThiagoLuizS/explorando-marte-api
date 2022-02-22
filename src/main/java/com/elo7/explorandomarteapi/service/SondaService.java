package com.elo7.explorandomarteapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elo7.explorandomarteapi.entity.Coordinates;
import com.elo7.explorandomarteapi.entity.Highland;
import com.elo7.explorandomarteapi.entity.Movement;
import com.elo7.explorandomarteapi.entity.Sonda;
import com.elo7.explorandomarteapi.entity.dto.InputDTO;
import com.elo7.explorandomarteapi.entity.dto.SondaDTO;

@Service
public class SondaService {
	
	@Autowired
	private MovementService movementService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<SondaDTO> getResultForInput(InputDTO dto) {
		
		Highland highland = Highland.builder().width(dto.getMesh().getX()).height(dto.getMesh().getY()).build();
		
		dto.getActions().stream().forEach(action -> {
			
			Sonda sonda = Sonda.builder()
				.coordinates(Coordinates.builder().x(action.getPosition().getX()).y(action.getPosition().getY()).build())
				.direction(action.getPosition().getDirection()).build();
			
			Movement movement = Movement.builder().sonda(sonda).movements(action.getMovements()).build();
			
			highland.addSonda(sonda);
			highland.addMovement(movement);
			
		});
		
		return processMovementToSonda(highland);
	}
	
	public List<SondaDTO> processMovementToSonda(Highland highland) {
		return highland.getMovements()
				.stream()
				.map(item -> modelMapper.map(movementService.movement(item).getSonda(), SondaDTO.class))
				.collect(Collectors.toList());
	}

}
