package modulo_14_thread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ScreenTimeThread extends JDialog {
    // Painel de componentes
    private JPanel jPanel = new JPanel(new GridBagLayout());

    private JLabel timeDescription = new JLabel("Time Thread 1");
    private JTextField showTime = new JTextField();

    private JLabel secondTimeDescription = new JLabel("Time Thread 2");
    private JTextField secondShowTime = new JTextField();

    private JButton startButton = new JButton("Start");
    private JButton stopButton = new JButton("Stop");

    private Runnable oneThread = new Runnable() {
        @Override
        public void run() {
            while (true) {
                showTime.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm.ss")
                        .format(Calendar.getInstance().getTime()));

                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    };
    private Runnable secondThread = new Runnable() {
        @Override
        public void run() {
            while (true) {
                secondShowTime.setText(new SimpleDateFormat("dd-MM-yyyy hh:mm:ss")
                        .format(Calendar.getInstance().getTime()));

                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    };

    private Thread threadOneTime;
    private Thread threadTwoTime;

    public ScreenTimeThread() {
        setLocationRelativeTo(null);
        setSize(new Dimension(240, 240));
        setTitle("Tela time com Thread");
        setResizable(false);

        // Controlador de posicionamento de componentes
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;

        // Para cada componente faça
        gridBagConstraints.insets = new Insets(5, 10, 5, 5);

        gridBagConstraints.anchor = GridBagConstraints.WEST;

        timeDescription.setPreferredSize(new Dimension(200, 25));
        jPanel.add(timeDescription, gridBagConstraints);

        // Mostra tempo 1
        showTime.setPreferredSize(new Dimension(200, 25));
        // Para colocar o showTime mais para cima
        gridBagConstraints.gridy++;
        showTime.setEditable(false);
        jPanel.add(showTime, gridBagConstraints);

        secondTimeDescription.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;
        jPanel.add(secondTimeDescription, gridBagConstraints);

        secondShowTime.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;
        secondShowTime.setEditable(false);
        jPanel.add(secondShowTime, gridBagConstraints);

        // Voltando largura para 1
        gridBagConstraints.gridwidth = 1;

        // Posicionando botão Start
        startButton.setPreferredSize(new Dimension(92, 25));
        gridBagConstraints.gridy++;
        jPanel.add(startButton, gridBagConstraints);

        // Posicionando botão Stop
        stopButton.setPreferredSize(new Dimension(92, 25));
        gridBagConstraints.gridx++;
        jPanel.add(stopButton, gridBagConstraints);

        startButton.addActionListener(new ActionListener() {
            // Executa o clique no botão
            @Override
            public void actionPerformed(ActionEvent e) {
                threadOneTime = new Thread(oneThread);
                threadOneTime.start();

                threadTwoTime = new Thread(secondThread);
                threadTwoTime.start();

                stopButton.setEnabled(true);
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                threadOneTime.stop();
                threadTwoTime.stop();
                stopButton.setEnabled(false);
            }
        });

        stopButton.setEnabled(false);

        // Adiciona painel a tela
        add(jPanel, BorderLayout.WEST);

        // Torna tela visível, ou seja, deverá ter sido montada anteriormente
        setVisible(true);
    }

}
