package com.elo7.explorandomarteapi.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.elo7.explorandomarteapi.entity.dto.InputDTO;
import com.elo7.explorandomarteapi.entity.dto.SondaDTO;
import com.elo7.explorandomarteapi.service.exception.RequiredFieldException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface InputResource {
	
	@PostMapping
	@ApiOperation(
			value = "Endpoint responsável por processar cálculos de coordenadas e retornar localização",
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cálculo efetuado com sucesso", response = SondaDTO.class),
			@ApiResponse(code = 404, message = "Discrepância nos dados de entrada", response = RequiredFieldException.class),
			@ApiResponse(code = 500, message = "Erros desconhecidos")
	})
	List<SondaDTO> input(@Valid @RequestBody InputDTO dto);
	
}
