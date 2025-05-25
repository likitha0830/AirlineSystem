package airline;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class pay extends JFrame implements ActionListener {
	JButton bt;

	public pay() {

		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		ImageIcon qr = new ImageIcon(getClass().getResource("QRcode.PNG"));
		JLabel image = new JLabel(qr);
		image.setBounds(100, 60, 600, 900);
		image.setSize(700, 750);
		add(image);

		JLabel heading = new JLabel("QRCODE SCANNER");
		heading.setBounds(200, 820, 1200, 100);
		heading.setForeground(Color.BLACK);
		heading.setFont(new Font("Tahoma", Font.BOLD, 50));
		add(heading);

		bt = new JButton("Pay");
		bt.setBounds(1250, 50, 100, 25);
		bt.setBackground(Color.BLACK);
		bt.setForeground(Color.WHITE);
		bt.addActionListener(this);
		add(bt);

		setSize(1900, 1000);
		setLocation(20, 10);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == bt) {
			try {
				JOptionPane.showMessageDialog(null, "Payment SuccessFull");

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {
		new pay();
	}
}