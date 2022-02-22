package com.elo7.explorandomarteapi.entity.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class InputActionDTO {
	
	@NotNull
	private CoordinatesDTO position;
	private List<String> movements;
	
}
