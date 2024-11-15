package com.example.aula_actions.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculadoraServiceTest {

    @Test
    @DisplayName("Quando acionado com 10 e 2, então deve retornar 5")
    public void testDividir() {
        // Arrange
        CalculadoraService calculadoraService = new CalculadoraService();
        double num1 = 10;
        double num2 = 2;
        double esperado = 5;

        // Act
        double resultado = calculadoraService.dividir(num1, num2);

        // Assert
        assertEquals(esperado, resultado);
    }

    @Test
    @DisplayName("Quando acionado com 10 e 0, então deve retornar exceção")
    public void testDividirPorZero() {
        // Arrange
        CalculadoraService calculadoraService = new CalculadoraService();
        double num1 = 10;
        double num2 = 0;
        var expectedMessage = "400 BAD_REQUEST \"Não é possível dividir por zero\"";

        // Assert
        ResponseStatusException exception = assertThrows(
                ResponseStatusException.class, () -> {
                    // Act
                    calculadoraService.dividir(num1, num2);
                }
        );
    }
}
