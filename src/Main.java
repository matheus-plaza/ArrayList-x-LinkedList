import java.util.*;

public class Main {

    public static void main(String[] args) {
        int tamanho = 2000000;
        long inicio, fim;

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < tamanho; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        System.out.println("--- Cenario 1:\n");
        inicio = System.nanoTime();
        arrayList.get(tamanho/2);
        fim = System.nanoTime();
        System.out.println("ArrayList  get: " + (fim - inicio) + "ns");

        inicio = System.nanoTime();
        linkedList.get(tamanho/2);
        fim = System.nanoTime();
        System.out.println("linkedList get: " + (fim - inicio) + "ns");

        System.out.println("\n\n--- Cenario 2:\n");
        inicio = System.nanoTime();
        arrayList.add(tamanho/2, 1);
        fim = System.nanoTime();
        System.out.println("arrayList  add meio: " + (fim - inicio) + "ns");

        inicio = System.nanoTime();
        linkedList.add(tamanho/2, 1);
        fim = System.nanoTime();
        System.out.println("linkedList add meio: " + (fim - inicio) + "ns");

        System.out.println("\n\n--- Cenario 3:\n");
        inicio = System.nanoTime();
        arrayList.add(1);
        fim = System.nanoTime();
        System.out.println("arrayList  add fim: " + (fim - inicio) + "ns");

        inicio = System.nanoTime();
        linkedList.add(1);
        fim = System.nanoTime();
        System.out.println("linkedList add fim: " + (fim - inicio) + "ns");

        System.out.println("\n\n--- Cenario 4:\n");
        inicio = System.nanoTime();
        arrayList.add(0, 1);
        fim = System.nanoTime();
        System.out.println("arrayList  add inicio: " + (fim - inicio) + "ns");

        inicio = System.nanoTime();
        linkedList.add(0, 1);
        fim = System.nanoTime();
        System.out.println("linkedList add inicio: " + (fim - inicio) + "ns");

        System.out.println("\n\n--- Cenario 5:\n");
        inicio = System.nanoTime();
        arrayList.remove(tamanho/2);
        fim = System.nanoTime();
        System.out.println("ArrayList  remove meio: " + (fim - inicio) + "ns");

        inicio = System.nanoTime();
        linkedList.remove(tamanho/2);
        fim = System.nanoTime();
        System.out.println("linkedList remove meio: " + (fim - inicio) + "ns");

        System.out.println("\n\n--- Cenario 6:\n");
        inicio = System.nanoTime();
        arrayList.remove(arrayList.size() - 1);
        fim = System.nanoTime();
        System.out.println("arrayList  remove fim:  " + (fim - inicio) + "ns");

        inicio = System.nanoTime();
        linkedList.remove(linkedList.size() - 1);
        fim = System.nanoTime();
        System.out.println("linkedList remove fim:  " + (fim - inicio) + "ns");

        System.out.println("\n\n--- Cenario 7:\n");
        inicio = System.nanoTime();
        arrayList.remove(0);
        fim = System.nanoTime();
        System.out.println("arrayList  remove inicio: " + (fim - inicio) + "ns");

        inicio = System.nanoTime();
        linkedList.remove(0);
        fim = System.nanoTime();
        System.out.println("linkedList remove inicio: " + (fim - inicio) + "ns");

        System.out.println("\n\n\nCenário: Percorrer a lista e inserir um item a cada 10 passos.");
        System.out.println("Tamanho inicial: " + tamanho + " elementos.\n");

        System.out.println("Rodando ArrayList");
        inicio = System.nanoTime();

        ListIterator<Integer> itArray = arrayList.listIterator();
        int countA = 0;
        while(itArray.hasNext()) {
            itArray.next();
            countA++;
            if (countA % 10 == 0) {
                itArray.add(999);
            }
        }

        fim = System.nanoTime();
        long tempoArray = fim - inicio;
        System.out.printf("ArrayList:  %,15d ns %n", tempoArray);


        System.out.println("Rodando LinkedList");
        inicio = System.nanoTime();

        ListIterator<Integer> itLinked = linkedList.listIterator();
        int countL = 0;
        while(itLinked.hasNext()) {
            itLinked.next();
            countL++;
            if (countL % 10 == 0) {
                itLinked.add(999);
            }
        }

        fim = System.nanoTime();
        long tempoLinked = fim - inicio;
        System.out.printf("LinkedList: %,15d ns %n", tempoLinked);

        System.out.println("\n------------------------------------------------");
        double diferenca = (double) tempoArray / tempoLinked;
        System.out.printf("LinkedList foi %.2f vezes mais rápida que o ArrayList.%n", diferenca);
    }
}