package airline;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Cancel extends JFrame implements ActionListener {

	JTextField tfPNR;
	JLabel tfname, cancellationno, lblfcode, lbldateoftravel;
	JButton fetchButton, flight;

	public Cancel() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		Random random = new Random();

		JLabel heading = new JLabel("CANCELLATION");
		heading.setBounds(180, 20, 250, 35);
		heading.setFont(new Font("Tahoma", Font.BOLD, 28));
		add(heading);

// ImageIcon i1 = new
// ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/cancel.jpg"));
// Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
// ImageIcon i3 = new ImageIcon(i2);
// JLabel image = new JLabel(i3);
// image.setBounds(470, 120, 250, 250);
// add(image);

		JLabel lblaadhar = new JLabel("PNR Number");
		lblaadhar.setBounds(60, 80, 150, 25);
		lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblaadhar);

		tfPNR = new JTextField();
		tfPNR.setBounds(220, 80, 150, 25);
		add(tfPNR);

		fetchButton = new JButton("Show Details");
		fetchButton.setBackground(Color.BLACK);
		fetchButton.setForeground(Color.WHITE);
		fetchButton.setBounds(380, 80, 120, 25);
		fetchButton.addActionListener(this);
		add(fetchButton);

		JLabel lblname = new JLabel("Name");
		lblname.setBounds(60, 130, 150, 25);
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblname);

		tfname = new JLabel();
		tfname.setBounds(220, 130, 150, 25);
		add(tfname);

		JLabel lblnationality = new JLabel("Cancellation No");
		lblnationality.setBounds(60, 180, 150, 25);
		lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblnationality);

		cancellationno = new JLabel("" + random.nextInt(1000000));
		cancellationno.setBounds(220, 180, 150, 25);
		add(cancellationno);

		JLabel lbladdress = new JLabel("Flight Code");
		lbladdress.setBounds(60, 230, 150, 25);
		lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lbladdress);

		lblfcode = new JLabel();
		lblfcode.setBounds(220, 230, 150, 25);
		add(lblfcode);

		JLabel lblgender = new JLabel("Date");
		lblgender.setBounds(60, 280, 150, 25);
		lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblgender);

		lbldateoftravel = new JLabel();
		lbldateoftravel.setBounds(220, 280, 150, 25);
		add(lbldateoftravel);

		flight = new JButton("Cancel");
		flight.setBackground(Color.BLACK);
		flight.setForeground(Color.WHITE);
		flight.setBounds(220, 330, 120, 25);
		flight.addActionListener(this);
		add(flight);

		setSize(600, 450);
		setLocation(650, 200);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == fetchButton) {
			String PNR = tfPNR.getText();

			try {
				Conn conn = new Conn();

				String query = "select * from reservation where PNR = '" + PNR + "'";

				ResultSet rs = conn.s.executeQuery(query);

				if (rs.next()) {
					tfname.setText(rs.getString("name"));
					lblfcode.setText(rs.getString("flightcode"));
					lbldateoftravel.setText(rs.getString("ddate"));
				} else {
					JOptionPane.showMessageDialog(null, "Please enter correct PNR");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (ae.getSource() == flight) {
			String Name = tfname.getText();
			String PNR = tfPNR.getText();
			String CancelNo = cancellationno.getText();
			String fcode = lblfcode.getText();
			String date = lbldateoftravel.getText();

			try {
				Conn conn = new Conn();

				String query = "insert into cancel values('" + PNR + "', '" + Name + "', '" + CancelNo + "', '" + fcode
						+ "', '" + date + "')";

				conn.s.executeUpdate(query);
				conn.s.executeUpdate("delete from reservation where PNR = '" + PNR + "'");

				JOptionPane.showMessageDialog(null, "Ticket Cancelled");
				setVisible(false);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new Cancel();
	}
}