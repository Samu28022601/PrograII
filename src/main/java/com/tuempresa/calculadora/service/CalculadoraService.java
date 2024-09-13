package com.tuempresa.calculadora.service;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CalculadoraService {

    private final LinkedList<String> historial = new LinkedList<>();

    public int sumar(int a, int b) {
        int resultado = a + b;
        agregarAlHistorial(a + " + " + b + " = " + resultado);
        return resultado;
    }

    public int restar(int a, int b) {
        int resultado = a - b;
        agregarAlHistorial(a + " - " + b + " = " + resultado);
        return resultado;
    }

    public int multiplicar(int a, int b) {
        int resultado = a * b;
        agregarAlHistorial(a + " * " + b + " = " + resultado);
        return resultado;
    }

    public int dividir(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("División por cero no permitida");
        }
        int resultado = a / b;
        agregarAlHistorial(a + " / " + b + " = " + resultado);
        return resultado;
    }

    private void agregarAlHistorial(String operacion) {
        if (historial.size() == 10) {
            historial.removeFirst();
        }
        historial.add(operacion);
    }

    public List<String> obtenerHistorial() {
        return historial;
    }
}
