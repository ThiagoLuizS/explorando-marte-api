package com.elo7.explorandomarteapi.entity.dto;

import com.elo7.explorandomarteapi.entity.enumerator.DirectionEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CoordinatesDTO {
	
	private Integer x;
	
	private Integer y;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private DirectionEnum direction;

}
