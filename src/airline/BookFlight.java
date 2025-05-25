package airline;

import java.awt.Choice;
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

import com.toedter.calendar.JDateChooser;

public class BookFlight extends JFrame implements ActionListener {

	JTextField tfaadhar;
	JLabel tfname, tfnationality, tfaddress, labelgender, labelfname, labelfcode;
	JButton bookflight, fetchButton, flight;
	Choice source, dstination;
	JDateChooser dcdate;

	public BookFlight() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JLabel heading = new JLabel("Book Flight");
		heading.setBounds(180, 13, 500, 35);
		heading.setFont(new Font("Tahoma", Font.BOLD, 36));
		heading.setForeground(Color.black);
		add(heading);

		JLabel lblaadhar = new JLabel("Aadhar");
		lblaadhar.setBounds(60, 80, 150, 25);
		lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblaadhar);

		tfaadhar = new JTextField();
		tfaadhar.setBounds(220, 80, 150, 25);
		add(tfaadhar);

		fetchButton = new JButton("Fetch User");
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

		JLabel lblnationality = new JLabel("Nationality");
		lblnationality.setBounds(60, 180, 150, 25);
		lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblnationality);

		tfnationality = new JLabel();
		tfnationality.setBounds(220, 180, 150, 25);
		add(tfnationality);

		JLabel lbladdress = new JLabel("Address");
		lbladdress.setBounds(60, 230, 150, 25);
		lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lbladdress);

		tfaddress = new JLabel();
		tfaddress.setBounds(220, 230, 150, 25);
		add(tfaddress);

		JLabel lblgender = new JLabel("Gender");
		lblgender.setBounds(60, 280, 150, 25);
		lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblgender);

		labelgender = new JLabel("Gender");
		labelgender.setBounds(220, 280, 150, 25);
		add(labelgender);

		JLabel lblsource = new JLabel("src");
		lblsource.setBounds(60, 330, 150, 25);
		lblsource.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblsource);

		source = new Choice(); // for selection purpouse
		source.setBounds(220, 330, 150, 25);
// source.add("Mysore");
// source.add("Bnglr");// selection
		add(source);

		JLabel lbldst = new JLabel("dst");
		lbldst.setBounds(60, 380, 150, 25);
		lbldst.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lbldst);

		dstination = new Choice();
		dstination.setBounds(220, 380, 150, 25);
		add(dstination);

		try {
			Conn c = new Conn();
			String query = "select * from f_details";
			ResultSet rs = c.s.executeQuery(query);

			while (rs.next()) {
				source.add(rs.getString("src"));
				dstination.add(rs.getString("dst"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		flight = new JButton("Fetch Flights");
		flight.setBackground(Color.BLACK);
		flight.setForeground(Color.WHITE);
		flight.setBounds(380, 380, 120, 25);
		flight.addActionListener(this);
		add(flight);

		JLabel lblfname = new JLabel("Flight Name");
		lblfname.setBounds(60, 430, 150, 25);
		lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblfname);

		labelfname = new JLabel();
		labelfname.setBounds(220, 430, 150, 25);
		add(labelfname);

		JLabel lblfcode = new JLabel("Flight Code");
		lblfcode.setBounds(60, 480, 150, 25);
		lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblfcode);

		labelfcode = new JLabel();
		labelfcode.setBounds(220, 480, 150, 25);
		add(labelfcode);

		JLabel lbldate = new JLabel("Date of Travel");
		lbldate.setBounds(60, 530, 150, 25);
		lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lbldate);

		dcdate = new JDateChooser();
		dcdate.setBounds(220, 530, 150, 25);
		add(dcdate);

// ImageIcon i1 = new
// ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/details.jpg"));
// Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
// ImageIcon image = new ImageIcon(i2);
// JLabel lblimage = new JLabel(image);
// lblimage.setBounds(550, 80, 500, 410);
// add(lblimage);

		bookflight = new JButton("Book Flight");
		bookflight.setBackground(Color.BLACK);
		bookflight.setForeground(Color.WHITE);
		bookflight.setBounds(220, 580, 150, 25);
		bookflight.addActionListener(this);
		add(bookflight);

		setSize(600, 700);
		setLocation(650, 180);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == fetchButton) {
			String aadhar = tfaadhar.getText();

			try {
				Conn conn = new Conn();

				String query = "select * from passenger where aadhar = '" + aadhar + "'";

				ResultSet rs = conn.s.executeQuery(query);

				if (rs.next()) {
					tfname.setText(rs.getString("name"));
					tfnationality.setText(rs.getString("nationality"));
					tfaddress.setText(rs.getString("address"));
					labelgender.setText(rs.getString("gender"));
				} else {
					JOptionPane.showMessageDialog(null, "Please enter correct aadhar");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (ae.getSource() == flight) {
			String src = source.getSelectedItem();
			String dst = dstination.getSelectedItem();
			try {
				Conn conn = new Conn();

				String query = "select * from f_details where src = '" + src + "' and dst = '" + dst + "'";

				ResultSet rs = conn.s.executeQuery(query);

				if (rs.next()) {
					labelfname.setText(rs.getString("f_name"));
					labelfcode.setText(rs.getString("f_code"));
				} else {
					JOptionPane.showMessageDialog(null, "No Flights Found");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			Random random = new Random();

			String aadhar = tfaadhar.getText();
			String name = tfname.getText();
			String nationality = tfnationality.getText();
			String flightname = labelfname.getText();
			String flightcode = labelfcode.getText();
			String src = source.getSelectedItem();
			String des = dstination.getSelectedItem();
			String ddate = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();

			try {
				Conn conn = new Conn();

				String query = "insert into reservation values('PNR-" + random.nextInt(1000000) + "', 'Ticket"
						+ random.nextInt(10000) + "', '" + aadhar + "', '" + name + "', '" + nationality + "', '"
						+ flightname + "', '" + flightcode + "', '" + src + "', '" + des + "', '" + ddate + "')";

				conn.s.executeUpdate(query);

				JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");
				setVisible(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new BookFlight();
	}
}
