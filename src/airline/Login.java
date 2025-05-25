package airline;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
	private static final String Username = null;
	private static final String password = null;
	JButton rt, sb, cls;
	JTextField lbutxt;
	JPasswordField lbptxt;

	public Login() {
		JLabel hd = new JLabel("Login");
		hd.setBounds(150, 05, 80, 28);
		hd.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(hd);

		JLabel lbun = new JLabel("Username");
		lbun.setBounds(30, 40, 80, 20);
		add(lbun);
		lbutxt = new JTextField();
		lbutxt.setBounds(130, 40, 160, 20);
		add(lbutxt);

		JLabel lbpw = new JLabel("Password");
		lbpw.setBounds(30, 80, 80, 30);
		add(lbpw);
		lbptxt = new JPasswordField();
		lbptxt.setBounds(130, 80, 160, 20);
		add(lbptxt);

		rt = new JButton("Reset");
		rt.setBounds(40, 140, 90, 20);
		add(rt);
		rt.addActionListener(this);

		sb = new JButton("Submit");
		sb.setBounds(180, 140, 90, 20);
		add(sb);
		sb.addActionListener(this);

		cls = new JButton("Close");
		cls.setBounds(110, 180, 90, 20);
		add(cls);
		cls.addActionListener(this);

		setSize(350, 280);
		setLocation(800, 300);
		setLayout(null);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sb) {
			if (lbutxt.getText().isEmpty() || lbptxt.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Fill all the Reqirements");
			} else {
				String Username = lbutxt.getText();
				String password = lbptxt.getText();

				try {
					Conn c = new Conn();

					String query = "select * from signin where username='" + Username + "' and password='" + password
							+ "'";
					ResultSet rs = c.s.executeQuery(query);

					if (rs.next()) {
						new Home();
						setVisible(false);
					} else {
						setVisible(false);
						JOptionPane.showMessageDialog(null, "Invalid user password");
						setVisible(false);
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		} else if (e.getSource() == cls) {
			setVisible(false);
		}

		else if (e.getSource() == rt) {
			lbutxt.setText(null);
			lbptxt.setText(null);

		}
	}

	public static void main(String[] args) {
		Login f = new Login();

	}
}