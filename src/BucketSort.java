import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;

public class BucketSort {

    public static void main(String[] args) {
        Random rd = new Random();

        // Sort de números inteiros
        int[] array = new int[50];

        for (int i = 0; i < array.length; i++)
            array[i] = rd.nextInt(200);

        bucketSort(array);

        System.out.println("Array de inteiros ordenada: ");
        for (int valor : array)
            System.out.print(valor + " | ");
    }

    static void bucketSort(int[] array) {
        // Pega a quantidade de valores na array
        int tamanhoDaArray = array.length;
        // Pega o maior valor existente na array
        int maiorValor = Arrays.stream(array).max().getAsInt();

        // Cria N+1 baldes vazios, N sendo o tamanho da array passada para o método
        ArrayList<Integer>[] buckets = new ArrayList[tamanhoDaArray + 1];

        for (int i = 0; i < buckets.length; i++)
            buckets[i] = new ArrayList<Integer>();

        // Coloca os valores da array nos seus devidos buckets
        for (int valor : array) {
            //Calcula qual o balde em que o valor sendo iterado deve ser colocado
            int index = valor * tamanhoDaArray / maiorValor;

            //Adiciona o valor atual no seu balde
            buckets[index].add(valor);
        }

        // Ordena cada um dos baldes
        for (ArrayList<Integer> bucket : buckets)
            Collections.sort(bucket);
            //insertionSort(bucket);

        System.out.println("Buckets:");
        for (ArrayList<Integer> bucket : buckets)
            System.out.println(bucket);

        // Junta todos os valores ordenados dos baldes na nova array
        int index = 0;
        for (ArrayList<Integer> bucket : buckets)
            for (Integer valor : bucket)
                array[index++] = valor;
    }

    public static void insertionSort(ArrayList<Integer> array) {
        for (int i = 1; i < array.size(); i++){
            int aux = array.get(i);
            int j = i;

            while ((j > 0) && (array.get(j-1) > aux)){
                array.set(j, array.get(j-1));
                j -= 1;
            }

            array.set(j, aux);
        }
    }
}