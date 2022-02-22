package com.elo7.explorandomarteapi.entity;

import java.util.ArrayList;
import java.util.List;

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
public class Highland {
	
	private Integer width;
	private Integer height;
	@Builder.Default
	private List<Sonda> sondas = new ArrayList<>();
	@Builder.Default
	private List<Movement> movements = new ArrayList<>();
	
	public void addSonda(Sonda sonda) {
		sondas.add(sonda);
	}
	
	public void addMovement(Movement movement) {
		movements.add(movement);
	}
}
