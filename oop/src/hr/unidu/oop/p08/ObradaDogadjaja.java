package hr.unidu.oop.p08;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;

import javax.swing.JButton;

/**
 * @author Krunoslav �ubrini�
 * 28. tra 2015.
 */
public class ObradaDogadjaja extends JFrame {
    private JLabel l;

    public static void main(String[] args) {
        try {
            SwingUtilities.invokeAndWait(() -> {
                ObradaDogadjaja window = new ObradaDogadjaja();
                window.pack();
                window.setLocationRelativeTo(null);
                window.setVisible(true);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ObradaDogadjaja() {
        initialize();
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l = new JLabel("0");
        // JPanel komponente centrira pa je to najjednostavniji na�in
        // da se ova labela pozicionira centrirano.
        JPanel p = new JPanel();
        p.add(l);
        // Ako nam centriranje nije važno moglo bi izravno: add(l,
        // BorderLayout.NORTH);
        add(p, BorderLayout.NORTH);

        JButton t = new JButton("Pove�aj");
        add(t, BorderLayout.SOUTH);
        // Neimenovani razred koji implementira sučelje ActionListener
//		t.addActionListener(new ActionListener() {
//			// U sučelju ActionListener definirana je metoda actionPerformed
//			public void actionPerformed(ActionEvent arg0) {
//				int v = Integer.valueOf(l.getText())+1;
//				l.setText(Integer.toString(v));
//			}
//		});
        // U sučelju ActionListener definirana je metoda actionPerformed.
        // Sučelje je funkcijsko i ima samo jdnu metodu pa se u Javi ver
        // >= 8 može zamijeniti lambda izrazom.
        t.addActionListener(e -> {
            int v = Integer.valueOf(l.getText()) + 1;
            l.setText(Integer.toString(v));
        });
    }
}
