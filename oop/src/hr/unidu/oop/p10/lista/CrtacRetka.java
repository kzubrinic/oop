package hr.unidu.oop.p10.lista;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import hr.unidu.oop.p10.Osoba;

public class CrtacRetka extends JLabel implements ListCellRenderer<Object>{
	     // Kod svakog pristupa ovoj labeli mijenja se njezin sadržaj i izgled
		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index,
			 boolean isSelected, boolean cellHasFocus) {
			 Osoba s = (Osoba)value;
	         setText(s.toString());
	         setIcon(new ImageIcon(s.getSlika()));
	         if (isSelected) {
	             setBackground(list.getSelectionBackground());
	             setForeground(list.getSelectionForeground());
	         } else {
	             setBackground(list.getBackground());
	             setForeground(list.getForeground());
	         }
	         setEnabled(list.isEnabled());
	         setFont(list.getFont());
	         setOpaque(true);
	         return this;
	}
}
