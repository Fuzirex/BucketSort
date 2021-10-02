import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;

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

    static void bucketSort(int[] arr) {
        // Pega a quantidade de valores na array
        int tamanhoDaArray = arr.length;
        // Pega o maior valor existente na array
        int maiorValor = Arrays.stream(arr).max().getAsInt();

        // Cria N+1 baldes vazios, N sendo o tamanho da array passada para o método
        Vector<Integer>[] buckets = new Vector[tamanhoDaArray + 1];

        for (int i = 0; i < buckets.length; i++)
            buckets[i] = new Vector<Integer>();

        // Coloca os valores da array nos seus devidos buckets
        for (int valor : arr) {
            //Calcula qual o balde em que o valor sendo iterado deve ser colocado
            int index = valor * tamanhoDaArray / maiorValor;

            //Adiciona o valor atual no seu balde
            buckets[index].add(valor);
        }

        // Ordena cada um dos baldes
        for (Vector<Integer> bucket : buckets)
            Collections.sort(bucket);

        System.out.println("Buckets:");
        for (Vector<Integer> bucket : buckets)
            System.out.println(bucket);

        // Junta todos os valores ordenados dos baldes na nova array
        int index = 0;
        for (Vector<Integer> bucket : buckets)
            for (Integer valor : bucket)
                arr[index++] = valor;
    }
}