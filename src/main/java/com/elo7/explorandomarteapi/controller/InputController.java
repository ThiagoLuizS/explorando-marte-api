package com.elo7.explorandomarteapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elo7.explorandomarteapi.entity.dto.InputDTO;
import com.elo7.explorandomarteapi.entity.dto.SondaDTO;
import com.elo7.explorandomarteapi.resource.InputResource;
import com.elo7.explorandomarteapi.service.InputAndOutputService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/input")
@Api(value = "Entrada de dados para cálculos de coordenadas")
public class InputController implements InputResource {

	@Autowired
	private InputAndOutputService service;
	
	@Override
	public List<SondaDTO> input(InputDTO dto) {
		return service.start(dto);
	}

}
