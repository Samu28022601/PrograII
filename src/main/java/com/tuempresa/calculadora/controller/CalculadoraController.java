package com.tuempresa.calculadora.controller;

import com.tuempresa.calculadora.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CalculadoraController {

    @Autowired
    private CalculadoraService calculadoraService;

    @GetMapping("/sumar")
    public ResponseEntity<Integer> sumar(@RequestParam int a, @RequestParam int b) {
        return ResponseEntity.ok(calculadoraService.sumar(a, b));
    }

    @GetMapping("/restar")
    public ResponseEntity<Integer> restar(@RequestParam int a, @RequestParam int b) {
        return ResponseEntity.ok(calculadoraService.restar(a, b));
    }

    @GetMapping("/multiplicar")
    public ResponseEntity<Integer> multiplicar(@RequestParam int a, @RequestParam int b) {
        return ResponseEntity.ok(calculadoraService.multiplicar(a, b));
    }

    @GetMapping("/dividir")
    public ResponseEntity<Integer> dividir(@RequestParam int a, @RequestParam int b) {
        return ResponseEntity.ok(calculadoraService.dividir(a, b));
    }

    @GetMapping("/historial")
    public ResponseEntity<List<String>> obtenerHistorial() {
        return ResponseEntity.ok(calculadoraService.obtenerHistorial());
    }
}
