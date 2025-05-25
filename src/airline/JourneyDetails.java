package airline;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

public class JourneyDetails extends JFrame implements ActionListener {
	JTable table;
	JTextField pnr;
	JButton show;

	public JourneyDetails() {

		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JLabel subheading = new JLabel("Journey Details");
		subheading.setBounds(300, 10, 250, 30);
		subheading.setFont(new Font("Tahoma", Font.BOLD, 26));
		subheading.setForeground(Color.black);
		add(subheading);

		JLabel lblpnr = new JLabel("PNR Details");
		lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblpnr.setBounds(50, 60, 100, 25);
		add(lblpnr);

		pnr = new JTextField();
		pnr.setBounds(160, 60, 110, 25);
		add(pnr);

		show = new JButton("Show Details");
		show.setBackground(Color.BLACK);
		show.setForeground(Color.WHITE);
		show.setBounds(290, 60, 120, 25);
		show.addActionListener(this);
		add(show);

		table = new JTable();

		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(1, 110, 781, 150);
		jsp.setBackground(Color.WHITE);
		add(jsp);

		setSize(800, 310);
		setLocation(600, 300);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		try {
			Conn conn = new Conn();
			ResultSet rs = conn.s.executeQuery("select * from reservation where PNR = '" + pnr.getText() + "'");

			if (!rs.isBeforeFirst()) {
				JOptionPane.showMessageDialog(null, "No Information Found");
				return;
			}
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new JourneyDetails();
	}
}
