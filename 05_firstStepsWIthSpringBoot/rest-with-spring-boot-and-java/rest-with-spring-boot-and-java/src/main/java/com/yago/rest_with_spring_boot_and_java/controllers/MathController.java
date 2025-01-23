package com.yago.rest_with_spring_boot_and_java.controllers;

// import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RestController;

import com.yago.rest_with_spring_boot_and_java.converters.NumberConverter;
import com.yago.rest_with_spring_boot_and_java.exceptions.UnsupportedMathOperationException;
import com.yago.rest_with_spring_boot_and_java.math.SimpleMath;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class MathController {
    // private final AtomicLong counter = new AtomicLong();
    private SimpleMath math = new SimpleMath();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Por favor, insira um número válido.");
        }
        return math.sum(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double subtraction(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Por favor, insira um número válido.");
        }
        return math.subtraction(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));

    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double multiplication(
        @PathVariable(value = "numberOne") String numberOne,
        @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Por favor, insira um número válido.");
        }
        return math.multiplication(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/squareroot/{number}", method=RequestMethod.GET)
    public Double squareroot(
        @PathVariable(value = "number") String number) throws Exception {

        if(!NumberConverter.isNumeric(number)){
            throw new UnsupportedMathOperationException("Por favor, insira um número válido.");
        }
        if( NumberConverter.convertToDouble(number) < 0){
            throw new UnsupportedMathOperationException("Não é possível calcular a raiz quadrada de um número negativo.");
        }
        return math.squareroot(NumberConverter.convertToDouble(number));
    }


}
