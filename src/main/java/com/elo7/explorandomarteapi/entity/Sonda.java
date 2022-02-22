package com.elo7.explorandomarteapi.entity;

import com.elo7.explorandomarteapi.entity.enumerator.DirectionEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Sonda {
	
	private Coordinates coordinates;
	private DirectionEnum direction;
	
}
