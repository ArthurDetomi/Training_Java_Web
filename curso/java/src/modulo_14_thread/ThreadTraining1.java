package modulo_14_thread;

import javax.swing.*;

public class ThreadTraining1 {


    public static void main(String[] args) throws InterruptedException {
        //  Thread processando em paralelo do envio de email
        Thread threadEmail = new Thread(thread1);
        threadEmail.start();

        //  Thread processando em paralelo do envio de nota fiscal
        Thread threadNota = new Thread(thread2);
        threadNota.start();

        JOptionPane.showMessageDialog(null, "Sistema continua executando");
    }

    private final static Runnable thread1 = new Runnable() {
        @Override
        public void run() {
            // Código da rotina
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Executando alguma rotina, envio email");
            }
        }
    };

    private static final Runnable thread2 = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(4000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Executando alguma rotina, envio nota fiscal");
            }
        }
    };

}
