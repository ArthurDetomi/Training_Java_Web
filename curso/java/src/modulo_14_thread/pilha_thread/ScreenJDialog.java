package modulo_14_thread.pilha_thread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenJDialog extends JDialog {

    private JPanel jPanel = new JPanel(new GridBagLayout());

    private JLabel nameDescription = new JLabel("Name:");
    private JTextField jTextName = new JTextField();

    private JLabel emailDescription = new JLabel("E-mail:");
    private JTextField jTextEmail = new JTextField();

    private JButton addListButton = new JButton("Add List");
    private JButton stopButton = new JButton("Stop");

    private QueueThreadImplementation queueThread = new QueueThreadImplementation();

    public ScreenJDialog() {
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

        nameDescription.setPreferredSize(new Dimension(200, 25));
        jPanel.add(nameDescription, gridBagConstraints);

        // Mostra tempo 1
        jTextName.setPreferredSize(new Dimension(200, 25));
        // Para colocar o showTime mais para cima
        gridBagConstraints.gridy++;
        jPanel.add(jTextName, gridBagConstraints);

        emailDescription.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;
        jPanel.add(emailDescription, gridBagConstraints);

        jTextEmail.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;
        jPanel.add(jTextEmail, gridBagConstraints);

        // Voltando largura para 1
        gridBagConstraints.gridwidth = 1;

        // Posicionando botão Start
        addListButton.setPreferredSize(new Dimension(92, 25));
        gridBagConstraints.gridy++;
        jPanel.add(addListButton, gridBagConstraints);

        // Posicionando botão Stop
        stopButton.setPreferredSize(new Dimension(92, 25));
        gridBagConstraints.gridx++;
        jPanel.add(stopButton, gridBagConstraints);

        // Executa o clique no botão
        addListButton.addActionListener(e -> {
            if (queueThread == null) {
                queueThread = new QueueThreadImplementation();
                queueThread.start();
            }

            // Simulando envio de 100 emails
            for (int i = 0; i < 100; i++) {
                String sendName = jTextName.getText() + " - " + i;
                String sendEmail = jTextEmail.getText() + " - " + i;

                ThreadQueueObject tqo = new ThreadQueueObject(sendName, sendEmail);
                queueThread.add(tqo);
            }
        });

        stopButton.addActionListener(e -> {
            queueThread.stop();
            queueThread = null;
        });


        queueThread.start();
        // Adiciona painel a tela
        add(jPanel, BorderLayout.WEST);

        // Torna tela visível, ou seja, deverá ter sido montada anteriormente
        setVisible(true);
    }

}
