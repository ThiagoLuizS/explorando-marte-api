package com.elo7.explorandomarteapi.entity.dto;

import com.elo7.explorandomarteapi.entity.enumerator.DirectionEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SondaDTO {
	
	private CoordinatesDTO coordinates;
	private DirectionEnum direction;

}
