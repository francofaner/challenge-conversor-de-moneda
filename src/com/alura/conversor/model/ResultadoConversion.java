package com.alura.conversor.model;

public class ResultadoConversion {
    private String baseCode;
    private String targetCode;
    private double conversionRate;
    private double conversionResult;

    public ResultadoConversion(String baseCode, String targetCode, double conversionRate, double conversionResult) {
        this.baseCode = baseCode;
        this.targetCode = targetCode;
        this.conversionRate = conversionRate;
        this.conversionResult = conversionResult;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public double getConversionResult() {
        return conversionResult;
    }

    @Override
    public String toString() {
        return "Moneda base: " + baseCode +
                "\nMoneda destino: " + targetCode +
                "\nTasa de conversión: " + conversionRate +
                "\nResultado convertido: " + conversionResult;
    }
}