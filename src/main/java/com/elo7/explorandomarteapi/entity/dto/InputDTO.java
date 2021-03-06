package com.elo7.explorandomarteapi.entity.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InputDTO {
	
	private CoordinatesDTO mesh;
	
	private List<InputActionDTO> actions;

}
