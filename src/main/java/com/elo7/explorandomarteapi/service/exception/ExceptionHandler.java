package com.elo7.explorandomarteapi.service.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<Error> errors = createListError(ex.getBindingResult());
		return handleExceptionInternal(ex, errors, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	private List<Error> createListError(BindingResult bindingResult){
		List<Error> erros = new ArrayList<>();
		for(FieldError fildError : bindingResult.getFieldErrors()) {			
			String mensagemUsuario = messageSource.getMessage(fildError, LocaleContextHolder.getLocale());
			String mensagemDesenvolvedor = fildError.toString();
			erros.add(new Error(mensagemUsuario, mensagemDesenvolvedor));
		}
		return erros;
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler({RequiredFieldException.class})
	public ResponseEntity<Object> handleRequiredFieldException(RequiredFieldException ex){
		String messageUser = messageSource.getMessage("campos.obrigatorios", null, LocaleContextHolder.getLocale());
		String messageDeveloper = ex.toString();
		List<Error> errors = Arrays.asList(new Error(messageUser, messageDeveloper));
		log.error("<< handleRequiredFieldException [messageUser={}, handleRequiredFieldException [messageDeveloper={}] ", messageUser);
		return handleExceptionInternal(ex, errors, null, HttpStatus.BAD_REQUEST, null);
	}
	
	public static class Error{
		private String messageUser;
		private String messageDeveloper;
		
		public Error(String mensagemUsuario, String mensagemDesenvolvedor) {
			this.messageUser = mensagemUsuario;
			this.messageDeveloper = mensagemDesenvolvedor;
		}

		public String getMessageUser() {
			return messageUser;
		}

		public void setMessageUser(String messageUser) {
			this.messageUser = messageUser;
		}

		public String getMessageDeveloper() {
			return messageDeveloper;
		}

		public void setMessageDeveloper(String messageDeveloper) {
			this.messageDeveloper = messageDeveloper;
		}
	}

}
