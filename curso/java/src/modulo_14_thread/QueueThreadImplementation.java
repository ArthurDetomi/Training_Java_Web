package modulo_14_thread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QueueThreadImplementation extends Thread {

    private static ConcurrentLinkedQueue<ThreadQueueObject> queue = new ConcurrentLinkedQueue<>();

    public static void add(ThreadQueueObject threadQueueObject) {
        queue.add(threadQueueObject);
    }

    @Override
    public void run() {
        Iterator iteraction = queue.iterator();

        synchronized (iteraction) { // Bloquear o acesso a essa lista por outros processos
            while (iteraction.hasNext()) {
                ThreadQueueObject currentThreadObject = (ThreadQueueObject) iteraction.next();

                // Processar 10 mil notas fiscais
                // Gerar uma lista enorme de PDF
                // Gerar envio de email em massa
                System.out.println("------------");
                System.out.println(currentThreadObject.getName());
                System.out.println(currentThreadObject.getEmail());


                iteraction.remove();

                // Dar um tempo para descarga de memória
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        try {
            Thread.sleep(1000); // Processou toda a lista dá um tempo para limpeza de memória
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
