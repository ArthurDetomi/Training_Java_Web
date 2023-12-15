package modulo_14_thread;

import javax.swing.*;
import java.awt.*;

public class ScreenTimeThread extends JDialog {
    // Painel de componentes
    private JPanel jPanel = new JPanel(new GridBagLayout());
    private JLabel timeDescription = new JLabel("Time Thread 1");
    private JTextField showTime = new JTextField();
    private JLabel secondTimeDescription = new JLabel("Time Thread 2");
    private JTextField secondShowTime = new JTextField();

    public ScreenTimeThread() {
        setLocationRelativeTo(null);
        setSize(new Dimension(240, 240));
        setTitle("Tela time com Thread");
        setResizable(false);

        // Controlador de posicionamento de componentes
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;

        timeDescription.setPreferredSize(new Dimension(200, 25));
        jPanel.add(timeDescription, gridBagConstraints);

        showTime.setPreferredSize(new Dimension(200, 25));

        // Para colocar o showTime mais para cima
        gridBagConstraints.gridy++;
        jPanel.add(showTime, gridBagConstraints);

        secondTimeDescription.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;
        jPanel.add(secondTimeDescription, gridBagConstraints);

        secondShowTime.setPreferredSize(new Dimension(200, 25));
        gridBagConstraints.gridy++;
        jPanel.add(secondShowTime, gridBagConstraints);

        add(jPanel, BorderLayout.WEST);
        // Torna tela visível, ou seja, deverá ter sido montada anteriormente
        setVisible(true);
    }

}
