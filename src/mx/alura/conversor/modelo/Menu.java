package mx.alura.conversor.modelo;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setTitle("MEN\u00DA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 364, 216);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Selecciona el tipo de conversor");
		lblNewLabel.setBounds(32, 32, 257, 13);
		contentPane.add(lblNewLabel);

		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(32, 55, 136, 21);
		contentPane.add(comboBox);

		comboBox.addItem("MONEDA");
		comboBox.addItem("TEMPERATURA");
		comboBox.addItem("LONGITUD");
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					dispose();
					Conversor_Principal frameConversor = new Conversor_Principal(comboBox.getSelectedItem());
					frameConversor.setVisible(true);
			}
		});
		btnNewButton.setBounds(204, 55, 85, 21);
		contentPane.add(btnNewButton);
	}
}
