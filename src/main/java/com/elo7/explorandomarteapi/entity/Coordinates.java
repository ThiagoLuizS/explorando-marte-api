package com.elo7.explorandomarteapi.entity;

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
public class Coordinates {
	
	@EqualsAndHashCode.Include
	private Integer x;
	@EqualsAndHashCode.Include
	private Integer y;

}
