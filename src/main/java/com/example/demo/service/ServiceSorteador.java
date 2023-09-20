package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;

@Service
public class ServiceSorteador {

    public static int[] geraNumeros(int min, int max, int quantidade, boolean cbordenar, boolean cbrepetir) {
        Random rand = new Random();
        int resultado;
        int[] numeros = new int[quantidade];

        for(int i = 0; i < quantidade; i++){
            boolean existeNoVetor = false;
            if(cbrepetir) {
                resultado = rand.nextInt(min,max+1);
            }else{
                do {
                    resultado = rand.nextInt(min,max+1);
                    int finalResultado = resultado;
                    existeNoVetor = Arrays.stream(numeros).anyMatch(numero -> numero == finalResultado);
                } while (existeNoVetor);
            }
            numeros[i] = resultado;
        }
        if (cbordenar) { 
            Arrays.sort(numeros);
        }
        return numeros;
    }
}
