package com.yago.rest_with_spring_boot_and_java.math;


public class SimpleMath {

    public Double sum(Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }

    public Double subtraction(Double numberOne,Double numberTwo) {
        return numberOne - numberTwo;
    }

    public Double multiplication(Double numberOne,Double numberTwo) {
        return numberOne * numberTwo;
    }

    public Double squareroot(Double number) {
        return Math.sqrt(number);
    }
}
