package airline;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Home extends JFrame implements ActionListener {

	JButton lg, si, d, t, p;

	public Home() {
		setLayout(null);

		ImageIcon i1 = new ImageIcon(getClass().getResource("aircraft.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(0, 0, 1920, 980);
		add(image);
		setVisible(true);

		JLabel heading = new JLabel("AIR INDIA WELCOMES YOU....");
		heading.setBounds(600, 80, 2000, 200);
		heading.setForeground(Color.LIGHT_GRAY);
		heading.setFont(new Font("Tahoma", Font.BOLD, 50));
		image.add(heading);

		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);

		si = new JButton("Signin");
		menubar.add(si);
		si.addActionListener(this);

		lg = new JButton("Login");
		menubar.add(lg);
		lg.addActionListener(this);

		d = new JButton("Details");
		menubar.add(d);
		d.addActionListener(this);

		JLabel d = new JLabel("Details");
		d.setBounds(110, 05, 150, 28);
		d.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(d);

		t = new JButton("Ticket");
		menubar.add(t);
		t.addActionListener(this);

		JLabel t = new JLabel("Ticket");
		t.setBounds(110, 05, 150, 28);
		t.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(t);

		p = new JButton("Payment");
		menubar.add(p);
		p.addActionListener(this);

		JLabel p = new JLabel("payment");
		p.setBounds(110, 05, 150, 28);
		p.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(p);

		JMenuItem flightDetails = new JMenuItem("Flight Details");
		flightDetails.addActionListener(this);
		flightDetails.setFont(new Font("Tahoma", Font.PLAIN, 16));
		d.add(flightDetails);

		JMenuItem customerDetails = new JMenuItem("Add Customer Details");
		customerDetails.addActionListener(this);
		customerDetails.setFont(new Font("Tahoma", Font.PLAIN, 16));
		d.add(customerDetails);

		JMenuItem bookFlight = new JMenuItem("Book Flight");
		bookFlight.addActionListener(this);
		bookFlight.setFont(new Font("Tahoma", Font.PLAIN, 16));
		d.add(bookFlight);

		JMenuItem journeyDetails = new JMenuItem("Journey Details");
		journeyDetails.addActionListener(this);
		journeyDetails.setFont(new Font("Tahoma", Font.PLAIN, 16));
		d.add(journeyDetails);

		JMenuItem boardingPass = new JMenuItem("Boarding Pass");
		boardingPass.addActionListener(this);
		boardingPass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t.add(boardingPass);

		JMenuItem ticketCancellation = new JMenuItem("Cancel Ticket");
		ticketCancellation.addActionListener(this);
		ticketCancellation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t.add(ticketCancellation);

//		JMenuItem tct = new JMenuItem("Ticket");
//		tct.addActionListener(this);
		// tct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		// ticket.add(tct);

		JMenuItem py = new JMenuItem("Pay");
		py.addActionListener(this);
		py.setFont(new Font("Tahoma", Font.PLAIN, 16));
		p.add(py);

		JMenuItem pymtdtls = new JMenuItem("Payment Details");
		pymtdtls.addActionListener(this);
		pymtdtls.setFont(new Font("Tahoma", Font.PLAIN, 16));
		p.add(pymtdtls);

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == si) {
			new signin();
		}
		if (ae.getSource() == lg) {
			new Login();
		}

		String text = ae.getActionCommand();

		if (text.equals("Add Customer Details")) {
			new customer();
		} else if (text.equals("Flight Details")) {
			new FlightInfo();
		} else if (text.equals("Book Flight")) {
			new BookFlight();
		} else if (text.equals("Journey Details")) {
			new JourneyDetails();
		} else if (text.equals("Cancel Ticket")) {
			new Cancel();
		} else if (text.equals("Boarding Pass")) {
			new BoardingPass();
		} else if (text.equals("Payment Details")) {
			new pay();
		} else if (text.equals("Pay")) {
			new pay();
		}

	}

	public static void main(String[] args) {
		new Home();
	}
}