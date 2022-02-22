package com.elo7.explorandomarteapi.utils;

import java.util.Objects;

import org.apache.commons.collections4.CollectionUtils;

import com.elo7.explorandomarteapi.entity.dto.InputDTO;
import com.elo7.explorandomarteapi.service.exception.RequiredFieldException;

public class Util {
	
	private Util() {}
	
	public static void validInput(InputDTO dto) {
		if(Objects.isNull(dto.getMesh())
				|| Objects.isNull(dto.getMesh().getX()) 
				|| Objects.isNull(dto.getMesh().getY())
				|| CollectionUtils.isEmpty(dto.getActions())
				|| dto.getActions().stream().anyMatch(ft -> Objects.isNull(ft.getPosition()) 
						|| Objects.isNull(ft.getPosition().getX()) 
						|| Objects.isNull(ft.getPosition().getY())
						|| CollectionUtils.isEmpty(ft.getMovements()))) {
			throw new RequiredFieldException();
		}
	}
	
}
