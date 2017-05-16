/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafioarreglomulti;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Eddy
 */
public class Desafioarreglomulti {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
        int cant_alum = 0,cant_notas=0,contador=0,cant_asignaturas=0;
        boolean estado=true;
        
        do{
            System.out.println("Ingrese la cantidad de asignaturas: ");
            try{
                cant_asignaturas=Integer.parseInt(leer.readLine());
                estado=true;
                if(cant_asignaturas<1){
                    System.out.println("La cantidad de asignaturas debe ser mayor que 0");
                    System.out.println("Intente nuevamente");
                }
            }catch(Exception e){
                System.out.println("La cantidad ingresada no es válida");
                System.out.println("Intente nuevamente");
                estado=false;
            }
        }while(cant_asignaturas<1||estado==false);
        
        do{
            System.out.println("Ingrese la cantidad de alumnos: ");
            try{
                cant_alum=Integer.parseInt(leer.readLine());
                estado=true;
                if(cant_alum<1){
                    System.out.println("La cantidad de alumnos debe ser mayor que 0");
                    System.out.println("Intente nuevamente");
                }
            }catch(Exception e){
                System.out.println("La cantidad ingresada no es válida");
                System.out.println("Intente nuevamente");
                estado=false;
            }
        }while(cant_alum<1||estado==false);
        
        do{
            System.out.println("Ingrese la cantidad de notas");
            try{
                cant_notas=Integer.parseInt(leer.readLine());
                estado=true;
                if(cant_notas<1){
                    System.out.println("La cantidad de notas debe ser mayor a 0");
                    System.out.println("Intente nuevamente");
                }
            }catch(Exception e){
                System.out.println("La cantidad ingresada no es válida");
                System.out.println("Intente nuevamente");
                estado=false;
            }
        }while(cant_notas<1||estado==false);
        
        String titulo[] = new String[cant_notas+4];
        
        float matriz [][][]=new float[cant_asignaturas][cant_alum+3][cant_notas+3];
        
        for (int i = 1; i <= cant_notas; i++) {
            titulo[0]="alum";
            titulo[i]="n°"+(i);
            titulo[cant_notas+1]="prom";
            titulo[cant_notas+2]="n>";
            titulo[cant_notas+3]="n<";
            
        }
        for (int k = 0; k < cant_asignaturas; k++) {
            System.out.println("Asignatura "+(k+1));
            for (int i = 0; i < cant_alum; i++) {
                float nota_max=0,nota_min=9,prom1=0,prom2=0;
                for (int j = 0; j < cant_notas; j++) {

                    do{
                        System.out.println("Ingrese la nota "+(j+1)+" del alumno "+(i+1));
                        try{
                            matriz[k][i][j]=Float.parseFloat(leer.readLine());
                            estado=true;
                            if(matriz[k][1][j]<0||matriz[k][i][j]>7){
                                System.out.println("La nota ingresada está fuera de rango");
                                System.out.println("Ingrese nuevamente");
                            }
                        }catch(Exception e){
                                estado=false;
                                System.out.println("El dato ingresado no es válido");
                                System.out.println("intente nuevamente");
                        }
                    }while(matriz[k][i][j]<1||matriz[k][i][j]>7||estado==false);

                    matriz[k][i][cant_notas] =  matriz[k][i][cant_notas]+matriz[k][i][j]/cant_notas;
                    
                    

                    if(matriz[k][i][j]>nota_max){
                    nota_max=matriz[k][i][j];
                    }
                    matriz[k][i][cant_notas+1]=nota_max;

                    if(matriz[k][i][j]<nota_min){
                    nota_min = matriz[k][i][j];
                    }
                    matriz[k][i][cant_notas+2]=nota_min;

                   matriz[k][cant_alum][j] =  matriz[k][cant_alum][j]+matriz[k][i][j]/cant_alum;
                   
                   

                    if(matriz[k][i][j]>=4){
                        contador++;
                    }
                    }
            }
            
        }
        for (int k = 0; k < cant_asignaturas; k++) {
            for (int i = 0; i < cant_notas; i++) {
            float mas_alta=0,mas_baja=9;
            for (int j = 0; j < cant_alum; j++) {
                
                if(matriz[k][j][i]>mas_alta){
                mas_alta = matriz[k][j][i];
                }
                if(matriz[k][j][i]<mas_baja){
                mas_baja = matriz[k][j][i];
                }
            }
            matriz[k][cant_alum+1][i]=mas_alta;
            matriz[k][cant_alum+2][i]=mas_baja;
            }
        }
        
        
        
        
        for (int k = 0; k < cant_asignaturas; k++) {
            System.out.println("asignatura "+(k+1));
            for (int i = 0; i < cant_notas+4; i++) {
                
            System.out.print(titulo[i]+"\t");
            }

            System.out.println("");
            
            
            
            for (int i = 0; i < cant_alum+3; i++) {
                if(i<cant_alum){
                System.out.print("N°"+(i+1)+"\t");
                }
                if(i==cant_alum){
                    System.out.print("prom"+"\t");
                }
                if(i==cant_alum+1){
                    System.out.print("N°>"+"\t");
                }
                if(i==cant_alum+2){
                    System.out.print("N°<"+"\t");
                }
                for (int j = 0; j < cant_notas+3; j++) 
                    
                    System.out.print(matriz[k][i][j]+"\t");
                    System.out.println();
            }
            
        }

          
    }
        
        
}
        

            

