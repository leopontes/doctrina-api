package br.com.doctrina.spring;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.doctrina.dto.ErrorResponseDTO;
import br.com.doctrina.spring.exception.ApplicationException;
import br.com.doctrina.spring.exception.BusinessException;
import br.com.doctrina.spring.exception.NotFoundException;
import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleResourceNotFound(NotFoundException ex) {
		ErrorResponseDTO errorResponse = new ErrorResponseDTO(
            LocalDateTime.now(),
            HttpStatus.NOT_FOUND.value(),
            "Not Found",
            ex.getMessage(),
            "/resource/path"
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleResourceNotFoundException(EntityNotFoundException ex) {
		ErrorResponseDTO errorResponse = new ErrorResponseDTO(
            LocalDateTime.now(),
            HttpStatus.NOT_FOUND.value(),
            "Not Found",
            "Recurso não encontrado.",
            "/resource/path"
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
	
	
	@ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponseDTO> handleResourceBusiness(BusinessException ex) {
		ErrorResponseDTO errorResponse = new ErrorResponseDTO(
            LocalDateTime.now(),
            HttpStatus.BAD_REQUEST.value(),
            "Not Found",
            ex.getMessage(),
            "/resource/path"
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorResponseDTO> handleResourceBusiness(ApplicationException ex) {
		ErrorResponseDTO errorResponse = new ErrorResponseDTO(
            LocalDateTime.now(),
            HttpStatus.BAD_REQUEST.value(),
            "Not Found",
            ex.getMessage(),
            "/resource/path"
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
