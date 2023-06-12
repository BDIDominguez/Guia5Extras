
package guia5extras;

//import com.sun.xml.internal.ws.util.StringUtils;
import java.io.PrintStream;
import javax.swing.JOptionPane;

public class Lluvia {
    private String [][] mm;
    private String [][] personas;
    private String[] zonas;
    private boolean log;
    private int esp = 25; // cantidad de espacios en cada campo de texto
    
    public void mostrarPlanilla(){
        String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        mostrarZonas();
        for (int i=0;i<mm.length;i++){
            System.out.print(String.format("%-" + esp + "s", meses[i]));
            for (int b=0;b<mm[i].length;b++) {
                System.out.print(String.format("%" + esp + "s", mm[i][b]+"-"+personas[i][b] ));
            }
            System.out.println(" ");
        }
        System.out.print(String.format("%" + esp + "s", "Promedio"));
        for (int i = 0;i < mm[1].length;i++){
            System.out.print(String.format("%" + esp + "s", Math.random(promedioZona(i)*100)/100));
        }
        System.out.println(" ");
        System.out.print(String.format("%" + esp + "s", "Total"));
        for (int i = 0;i < mm[1].length;i++){
            System.out.print(String.format("%" + esp + "s", totalZona(i)));
        }
        System.out.println(" ");
    }
    
    public double promedioZona(int columna){
        double total = 0, cantidad =0;
        for (int i=0;i<mm.length;i++){
            if (!mm[i][columna].equals("")){
                total += Integer.parseInt(mm[i][columna]);
                cantidad++;
            }
        }
        if (cantidad == 0){
            return 0;
        }else{
            return total/cantidad;
        }
    }
    public double totalZona(int columna){
        double total = 0;
        for (int i=0;i<mm.length;i++){
            if (!mm[i][columna].equals("")){
                total += Integer.parseInt(mm[i][columna]);
            }
        }
        return total;
    }
    
    public void cargarMM(){
        String mil = JOptionPane.showInputDialog("Ingrese los MM");
        int fila = determinarMes(JOptionPane.showInputDialog("Ingrese Mes"));
        String nombre = JOptionPane.showInputDialog("Ingrese Nombre");
        String apellido = JOptionPane.showInputDialog("Ingrese Apellido");
        int columna = determinarZona(JOptionPane.showInputDialog("Ingrese Zona"));
        log("Columna  " + columna);
        log("Fina " + fila);
        mm[fila][columna] = mil;
        personas[fila][columna] = apellido + ", " + nombre;
    }
    
    public int determinarZona(String cadena){
        cadena = cadena.toUpperCase().charAt(0) + cadena.substring(1,cadena.length()).toLowerCase();
        int vResp = -1;
        for (int i = 0; i < zonas.length;i++){
            if (zonas[i].equals(cadena)){
                vResp = i;
                i = zonas.length;
            }
        }
        if (vResp == -1){
            vResp = determinarZona(JOptionPane.showInputDialog("Ingrese una zona que exista!!!!!"));
        }
        return vResp;
    }
    
    public int determinarMes(String mes) {
        int vResp;
        mes = mes.toLowerCase();
        switch (mes) {
            case "enero":
                vResp = 0;
                break;
            case "febrero":
                vResp = 1;
                break;
            case "marzo":
                vResp = 2;
                break;
            case "abril":
                vResp = 3;
                break;
            case "mayo":
                vResp = 4;
                break;
            case "junio":
                vResp = 5;
                break;
            case "julio":
                vResp = 6;
                break;
            case "agosto":
                vResp = 7;
                break;
            case "septiembre":
                vResp = 8;
                break;
            case "octubre":
                vResp = 9;
                break;
            case "noviembre":
                vResp = 10;
                break;
            case "diciembre":
                vResp = 11;
                break;
            default:
                vResp = determinarMes(JOptionPane.showInputDialog("Ingrese bien el Mes!!!!!"));
        }
        return vResp;
    }


    public void log(String cadena){ // Reemplaza al SOUT, para mostrar texto cuando se necesite comprobar como funciona por medio de la variable log
        if (this.log){
            System.out.println(cadena);
        }
    }
        
    public void cargarZona(String cadena){
        // valor.toUpperCase().charAt(0) + valor.substring(1, valor.length()).toLowerCase(); 
        // Toma el Primer Caracter lo convierte en Mayusculas y el resto los corta en minusculas
        cadena = cadena.toUpperCase().charAt(0) + cadena.substring(1,cadena.length()).toLowerCase();
        log(cadena);
        for (int i = 0; i < zonas.length;i++){
            if (zonas[i].equals("")){
                zonas[i]=cadena;
                log("Cargando Zona...");
                i = zonas.length;
            }else if(zonas[i].equals(cadena)){
                log("Zona ya Existe!!!!");
                i = zonas.length;
            }
        }
    }
    
    public void mostrarZonas(){
        System.out.print(String.format("%" + esp + "s", " "));
        for (String zona : zonas) {
            System.out.print(String.format("%" + esp + "s", zona));
        }
        System.out.println(" ");
        
    }

    public String[][] getMm() {
        return mm;
    }

    public void setMm(String[][] mm) {
        this.mm = mm;
    }

    public String[] getZonas() {
        return zonas;
    }

    public void setZonas(String[] zonas) {
        this.zonas = zonas;
    }

    public boolean isLog() {
        return log;
    }

    public void setLog(boolean log) {
        this.log = log;
    }

    public String[][] getPersonas() {
        return personas;
    }

    public void setPersonas(String[][] personas) {
        this.personas = personas;
    }

    
    
} // Final de la Clase
