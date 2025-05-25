package airline;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class customer extends JFrame implements ActionListener {

	JTextField tfname, tfphone, tfaadhar, tfnationality, tfaddress;
	JRadioButton rbmale, rbfemale;

	public customer() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
		heading.setBounds(130, 20, 500, 35);
		heading.setFont(new Font("Tahoma", Font.BOLD, 32));
		heading.setForeground(Color.black);
		add(heading);

		JLabel lblname = new JLabel("Name");
		lblname.setBounds(70, 80, 150, 25);
		lblname.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblname);

		tfname = new JTextField();
		tfname.setBounds(220, 80, 150, 25);
		add(tfname);

		JLabel lblnationality = new JLabel("Nationality");
		lblnationality.setBounds(70, 130, 150, 25);
		lblnationality.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblnationality);

		tfnationality = new JTextField();
		tfnationality.setBounds(220, 130, 150, 25);
		add(tfnationality);

		JLabel lblaadhar = new JLabel("Aadhar Number");
		lblaadhar.setBounds(70, 180, 150, 25);
		lblaadhar.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblaadhar);

		tfaadhar = new JTextField();
		tfaadhar.setBounds(220, 180, 150, 25);
		add(tfaadhar);

		JLabel lbladdress = new JLabel("Address");
		lbladdress.setBounds(70, 230, 150, 25);
		lbladdress.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lbladdress);

		tfaddress = new JTextField();
		tfaddress.setBounds(220, 230, 150, 25);
		add(tfaddress);

		JLabel lblgender = new JLabel("Gender");
		lblgender.setBounds(70, 280, 150, 25);
		lblgender.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblgender);

		ButtonGroup gendergroup = new ButtonGroup(); // for selecting only one button

		rbmale = new JRadioButton("Male"); // for round shape & check box for box shape
		rbmale.setBounds(220, 280, 70, 25);
		rbmale.setBackground(Color.WHITE);
		add(rbmale);

		rbfemale = new JRadioButton("Female");
		rbfemale.setBounds(300, 280, 70, 25);
		rbfemale.setBackground(Color.WHITE);
		add(rbfemale);

		gendergroup.add(rbmale);
		gendergroup.add(rbfemale);

		JLabel lblphone = new JLabel("Phone");
		lblphone.setBounds(70, 330, 150, 25);
		lblphone.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblphone);

		tfphone = new JTextField();
		tfphone.setBounds(220, 330, 150, 25);
		add(tfphone);

		JButton save = new JButton("Submit");
		save.setBackground(Color.BLACK);
		save.setForeground(Color.WHITE);
		save.setBounds(220, 380, 150, 30);
		save.addActionListener(this);
		add(save);

		ImageIcon i1 = new ImageIcon(getClass().getResource("custm.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(430, 10, 200, 300);
		add(image);

		setSize(900, 600);
		setLocation(500, 250);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		String name = tfname.getText();
		String nationality = tfnationality.getText();
		String phone = tfphone.getText();
		String address = tfaddress.getText();
		String aadhar = tfaadhar.getText();
		String gender = null;
		if (rbmale.isSelected()) {
			gender = "Male";
		} else {
			gender = "Female";
		}

		try {
			Conn conn = new Conn();

			String query = "insert into passenger values('" + name + "', '" + nationality + "', '" + phone + "', '"
					+ address + "', '" + aadhar + "', '" + gender + "')"; // DML command

			conn.s.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
			setVisible(false);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new customer();
	}
}
