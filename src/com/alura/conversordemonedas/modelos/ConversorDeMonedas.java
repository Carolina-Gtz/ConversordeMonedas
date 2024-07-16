package com.alura.conversordemonedas.modelos;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.Scanner;

public class ConversorDeMonedas {
    private String nameMonedaBase;
    private String nameMonedaDestino;
    Scanner usuario = new Scanner(System.in);
    private String respuestaUsuario;
    private double monedaBase;
    private double monedaDestino;
    private Date date = new Date();

    public Date getDate() {
        return this.date;
    }

    public ConversorDeMonedas() {

    }

    public ConversorDeMonedas(ConversorDeMonedasDTO conversorDeMonedasDTO, int monedaBaseCantidad) {
        this.setMonedaBase(monedaBaseCantidad);
        this.monedaDestino = Double.valueOf(conversorDeMonedasDTO.conversion_rate());

    }

    public String getRespuestaUsuario() {
        return respuestaUsuario;
    }

    public void setRespuestaUsuario(String respuestaUsuario) {
        this.respuestaUsuario = respuestaUsuario;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getNameMonedaBase() {
        return this.nameMonedaBase;
    }

    public void setNameMonedaBase(String nameMonedaBase) {
        this.nameMonedaBase = nameMonedaBase;
    }

    public String getNameMonedaDestino() {
        return this.nameMonedaDestino;
    }

    public void setNameMonedaDestino(String nameMonedaDestino) {
        this.nameMonedaDestino = nameMonedaDestino;
    }


    public ConversorDeMonedas(double monedaDestino) {
        this.monedaBase = 1;
        this.monedaDestino = monedaDestino; // hacer un get.obtener valor
    }

    public double getMonedaBase() {
        return this.monedaBase;
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

    public double convertidor() {
        this.monedaBase = monedaBase;
        return this.getMonedaBase() * this.getMonedaDestino();


    }

    public void otrasOpcionesDeMonedas(Double monedaBase, Double monedaDestino) {
        setMonedaBase(monedaBase);
        setMonedaDestino(monedaDestino);
    }

    public void setMonedaDest(ConversorDeMonedasDTO conversorDeMonedasDTO) {
        this.monedaDestino = Double.valueOf(conversorDeMonedasDTO.conversion_rate());

    }


    public void printMenuConversor() {

        System.out.println("\n-------------------- Option menu  ------------------------------\n");
        System.out.println("Option  (1).  Convertir Dolar estadounidense USD => ARS Peso Argentino ");
        System.out.println("Option  (2).  Peso Argentino ARS => USD  Dolar estadounidense ");
        System.out.println("Option  (3).  Dolar estadounidense USD => BRL Real brasilero");
        System.out.println("Option  (4).  Real brasilero BRL => USD Dolar estadounidense ");
        System.out.println("Option  (5).  Dolar estadounidense USD => COP Peso colombiano");
        System.out.println("Option  (6).  Peso colombiano COP  => USD Dolar estadounidense ");
        System.out.println("Option  (7).  Otras Opciones de convecion de moneta");

    }

    public String elegirOpcionMenu(){
        System.out.println("\n-----" + "Elige una opcion del menu o escribe salir " + "---------\n");
        setRespuestaUsuario(usuario.nextLine());
        return getRespuestaUsuario();
    }
    public void setMonedas(String respuestaUsuario){


        switch (getRespuestaUsuario()) {

            // System.out.println("Elige una opcion del menu o escribe salir");
            case "1":
                setNameMonedaBase("USD");
                setNameMonedaDestino("ARS");
                setRespuestaUsuario(respuestaUsuario);
                break;

            case "2":
                setNameMonedaBase("ARS");
                setNameMonedaDestino("USD");
                setRespuestaUsuario(respuestaUsuario);
                break;

            case "3":
                setNameMonedaBase("USD");
                setNameMonedaDestino("BRL");
                setRespuestaUsuario(respuestaUsuario);
                break;

            case "4":
                setNameMonedaBase("BRL");
                setNameMonedaDestino("USD");
                setRespuestaUsuario(respuestaUsuario);

                break;

            case "5":
                setNameMonedaBase("USD");
                setNameMonedaDestino("COP");
                setRespuestaUsuario(respuestaUsuario);
                break;

            case "6":
                setNameMonedaBase("COP");
                setNameMonedaDestino("USD");
                setRespuestaUsuario(respuestaUsuario);
                break;

            case "7":
                System.out.println("Escribe el nombre de la moneda Base");
                String nameMonedaBase = usuario.nextLine();

                System.out.println("Escribe el nombre de la moneda Destino");
                String nameMonedaDestino = usuario.nextLine();
                setNameMonedaBase(nameMonedaBase);
                setNameMonedaDestino(nameMonedaDestino);
                setRespuestaUsuario(respuestaUsuario);
                break;

            case "salir":
                System.out.println("Has salido del menu");
                setRespuestaUsuario(respuestaUsuario);
                break;
        }
        System.out.println("Elegiste convertir " + getNameMonedaBase()
                + " a " + getNameMonedaDestino());

        System.out.println("Ingresa el cantidad a convertir");
        int monedaBaseCantidad = Integer.valueOf(usuario.nextLine());
        setMonedaBase(monedaBaseCantidad);
    }


    @Override
    public String toString() {
        return "---------------------  Resultado ----------------------- \n" +
                "" + this.monedaBase + " " + nameMonedaBase + " = " +
                convertidor() + " " + nameMonedaDestino + "\nfecha" + date;
    }
}
