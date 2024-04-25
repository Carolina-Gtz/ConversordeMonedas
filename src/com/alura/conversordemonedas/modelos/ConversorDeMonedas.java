package com.alura.conversordemonedas.modelos;

public class ConversorDeMonedas {
   private double monedaBase;
    private double monedaDestino;

    public ConversorDeMonedas(double monedaBase, double monedaDestino) {
        this.monedaBase = monedaBase;
        this.monedaDestino = monedaDestino;
    }

    public double getMonedaBase() {
        return monedaBase;
    }

    public void setMonedaBase(double monedaBase) {
        this.monedaBase = monedaBase;
    }

    public double getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(double monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    @Override
    public String toString() {
        return "ConversorDeMonedas{" +
                "monedaBase=" + monedaBase +
                ", monedaDestino=" + monedaDestino +
                '}';
    }
}
