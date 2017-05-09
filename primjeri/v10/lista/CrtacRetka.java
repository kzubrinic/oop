package lista;
import java.awt.Component;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class CrtacRetka extends JLabel implements ListCellRenderer<Object>{
	     // This is the only method defined by ListCellRenderer.
	     // We just reconfigure the JLabel each time we're called.
		@Override
		public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index,
				boolean isSelected, boolean cellHasFocus) {
			 Student2 s = (Student2)value;
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
