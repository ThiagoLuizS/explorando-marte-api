package com.elo7.explorandomarteapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elo7.explorandomarteapi.entity.dto.InputDTO;
import com.elo7.explorandomarteapi.entity.dto.SondaDTO;
import com.elo7.explorandomarteapi.utils.Util;

@Service
public class InputAndOutputService {
	
	@Autowired
	private SondaService sondaService;
	
	public List<SondaDTO> start(InputDTO dto) {
		Util.validInput(dto);
		return sondaService.getResultForInput(dto);
	}

}
