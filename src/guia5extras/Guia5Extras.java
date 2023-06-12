package guia5extras;

import javax.swing.JOptionPane;

public class Guia5Extras {

    public static void main(String[] args) {
        String vResp;
        vResp = JOptionPane.showInputDialog("1 -- Extras Primera Parte \n 2 -- Planilla de Carga Manual \n 3 -- Planilla Automatica \n S -- Terminar");
        if (vResp == null) {
            vResp = "S";
        }
        switch (vResp) {
            case "1":
                //Primer ejercicio de los extras de la guia 5
                String[] ele = new String[10];
                Pila pila = new Pila(ele);
                pila.agregar("heeeeee");
                pila.agregar("hoy");
                pila.agregar("estamos");
                pila.agregar("como");
                pila.agregar("Hola");
                int tope = pila.getTope();
                for (int i = pila.getTope(); i > -1; i--) {
                    System.out.println(" " + pila.verTope());
                    pila.quitar();
                }
                pila.setTope(tope);
                break;

            case "2":
                //Se necesita Saber cuantas zonas tendremos para poder determinar cuantas columnas tendra la matriz mm
                String[] zo = new String[12];
                for (int i = 0; i < zo.length; i++) {
                    zo[i] = "";
                }
                Lluvia lluvia = new Lluvia();
                boolean log = false; // mostrara todos los textos de seguimiento
                lluvia.setLog(log);
                lluvia.setZonas(zo);

                int contador = 0;
                do {
                    vResp = JOptionPane.showInputDialog("Ingrese una Zona o S para terminar");
                    if (vResp == null) {
                        vResp = "S";
                    }
                    if (!vResp.toUpperCase().equals("S")) {
                        lluvia.cargarZona(vResp);
                        contador++;
                    }
                } while (!vResp.toUpperCase().equals("S"));
                String[][] llu = new String[12][contador];
                String[][] per = new String[12][contador];
                for (int i = 0; i < llu.length; i++) {
                    for (int b = 0; b < llu[i].length; b++) {
                        llu[i][b] = "";
                        per[i][b] = "";
                    }
                }
                lluvia.setMm(llu);
                lluvia.setPersonas(per);
                do {
                    System.out.println("******* Menu *******");
                    System.out.println(" 1 --- Cargar Presipitacion");
                    System.out.println(" 2 --- Mostrar Zonas");
                    System.out.println(" 3 --- Mostrar planilla");
                    vResp = JOptionPane.showInputDialog("Que opcion Elijes, S para Terminar");
                    if (vResp == null) {
                        vResp = "S";
                    }
                    switch (vResp) {
                        case "1":
                            lluvia.cargarMM();
                            break;
                        case "2":
                            lluvia.mostrarZonas();
                            break;
                        case "3":
                            lluvia.mostrarPlanilla();
                    }
                } while (!vResp.toUpperCase().equals("S"));
                break;
            case "3":
                String[] pr = new String[3];
                pr[0] = "Jujuy";
                pr[1] = "Salta";
                pr[2] = "Tucuman";
                String[][] lu = new String[12][3];
                
                for (int i = 0;i<12;i++){
                    for (int b = 0;b<3;b++){
                        lu[i][b] =String.valueOf((int)(Math.random()*1000+1)); // no puedo convertir un numero creado al azar a texto!!!!
                    }
                }
                String[][] pe = new String[12][3];
                for (int i = 0;i<12;i++){
                    for (int b = 0;b<3;b++){
                        pe[i][b] = "Dario";
                    }
                }
                Lluvia l = new Lluvia();
                l.setLog(false);
                l.setMm(lu);
                l.setPersonas(pe);
                l.setZonas(pr);
                l.mostrarPlanilla();
                break;
        }
        
    }
    }
    
