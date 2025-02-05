package com.example.demo.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(path = "/api")
public class ConversionController {

private final ConversionService studentService;

@Autowired
public ConversionController(ConversionService studentService){
    this.studentService=studentService;
}


    @GetMapping("/rates")
    public ExchangeRateResponse getExchangeRates(@RequestParam(defaultValue = "USD") String base) {
        return studentService.getExchangeRates(base);
    }

    @PostMapping("/convert")
    public ConvertResponse convertCurrency(@RequestBody ConvertRequest request) {
        return studentService.convertCurrency(request.getAmount(), request.getFrom(), request.getTo());
    }


    // Global exception handler for catching all exceptions
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Exception ex) {
        return "An error occurred: " + ex.getMessage();
    }

    // Specific exception handler for resource not found
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleResourceNotFound(ResourceNotFoundException ex) {
        return ex.getMessage();
    }

    public static class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }
    
}
