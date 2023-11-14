package modulo_14_thread;

public class ThreadTraining {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            // Dá um tempo
            Thread.sleep(2000L);

            // Executando com um tempo de parada
            System.out.println("Executando alguma rotina, envio email");
        }

        System.out.println("Chegou ao fim do teste");
    }

}
