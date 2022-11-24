
package Arrays_data_estructure;

import java.awt.EventQueue;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Jhontabo
 */
   

public class Prueba extends JPanel {

	/**
	 * Create the panel.
	 */
	public Prueba() {
		setLayout(null);
		
		JRadioButton tm_1 = new JRadioButton("TAMAÑO 1");
		tm_1.setBounds(25, 26, 103, 21);
		add(tm_1);
		
		JRadioButton tm_2 = new JRadioButton("TAMAÑO 2");
		tm_2.setBounds(25, 59, 103, 21);
		add(tm_2);
		
		JRadioButton TM_3 = new JRadioButton("TAMAÑO 3");
		TM_3.setBounds(25, 95, 103, 21);
		add(TM_3);

	}
        public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba frame = new Prueba();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
    

