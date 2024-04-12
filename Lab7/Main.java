import java.util.ArrayList;
import java.util.List;
import java.util.Random;

interface Condicion {
    boolean cumpleCondicion(int numero);
}

class CondicionMultiplo implements Condicion {
    private final int multiplo;

    public CondicionMultiplo(int multiplo) {
        this.multiplo = multiplo;
    }

    @Override
    public boolean cumpleCondicion(int numero) {
        return numero % multiplo == 0;
    }
}

class AndCondition implements Condicion {
    private final Condicion condicion1;
    private final Condicion condicion2;

    public AndCondition(Condicion condicion1, Condicion condicion2) {
        this.condicion1 = condicion1;
        this.condicion2 = condicion2;
    }

    @Override
    public boolean cumpleCondicion(int numero) {
        return condicion1.cumpleCondicion(numero) && condicion2.cumpleCondicion(numero);
    }
}

class VisualizadorCondicional {
    public void mostrar(String mensaje, List<Integer> numeros, Condicion condicion) {
        System.out.println("====== " + mensaje + " ======");
        for (int numero : numeros) {
            if (condicion.cumpleCondicion(numero)) {
                System.out.println(numero);
            }
        }
        System.out.println("=====================");
    }
}

public class Main {
    public static void main(String[] args) {
        // Mostrar nombre
        System.out.println("Lab 007 Ingenieria de SOftware");
        System.out.println("@autor Juan Agustin Apaza");
        System.out.println("@version 0.1");
        System.out.println("@date 04/12/2024");

        List<Integer> numeros = generateRandomNumbers();
        VisualizadorCondicional visualizador = new VisualizadorCondicional();

        visualizador.mostrar("PARES Y MÚLTIPLOS DE 4", numeros,
                new AndCondition(new CondicionMultiplo(2), new CondicionMultiplo(4)));
    }

    public static List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            randomNumbers.add(random.nextInt(100));
        }

        return randomNumbers;
    }
}
