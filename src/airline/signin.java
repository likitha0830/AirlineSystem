package airline;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class signin extends JFrame implements ActionListener {
	private static final String Username = null;
	private static final String password = null;
	private static final String DOB = null;
	private static final String repassword = null;
	private static final String ddate = null;
	JButton rt, sb, cls;
	JTextField lbutxt;
	JPasswordField lbptxt, lbrptxt;
	JDateChooser dcdate;

	public signin() {
		JLabel hd = new JLabel("Signin/Register");
		hd.setBounds(110, 05, 150, 28);
		hd.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(hd);

		JLabel lbun = new JLabel("Username");
		lbun.setBounds(30, 40, 80, 20);
		lbun.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lbun);
		lbutxt = new JTextField();
		lbutxt.setBounds(180, 40, 160, 20);
		add(lbutxt);

		JLabel lbpw = new JLabel("DOB");
		lbpw.setBounds(30, 80, 80, 20);
		lbpw.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lbpw);

		dcdate = new JDateChooser();
		dcdate.setBounds(180, 80, 160, 20);
		add(dcdate);

		JLabel dob = new JLabel("password");
		dob.setBounds(30, 120, 100, 20);
		dob.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(dob);

		lbptxt = new JPasswordField();
		lbptxt.setBounds(180, 120, 160, 20);
		add(lbptxt);

		JLabel rp = new JLabel("Reenter password");
		rp.setBounds(30, 160, 180, 20);
		rp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(rp);

		lbrptxt = new JPasswordField();
		lbrptxt.setBounds(180, 160, 160, 20);
		add(lbrptxt);

		rt = new JButton("Reset");
		rt.setBounds(70, 200, 90, 20);
		add(rt);
		rt.addActionListener(this);

		sb = new JButton("Submit");
		sb.setBounds(220, 200, 90, 20);
		add(sb);
		sb.addActionListener(this);

		cls = new JButton("Close");
		cls.setBounds(150, 240, 90, 20);
		add(cls);
		cls.addActionListener(this);

		setSize(400, 350);
		setLocation(800, 300);
		setLayout(null);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == sb) {
			if (lbutxt.getText().isEmpty() || dcdate.getDate() == null || lbptxt.getText().isEmpty()
					|| lbrptxt.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Fill all the Reqirements");
			} else {
				String Username = lbutxt.getText();

				String ddate = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
				String password = lbptxt.getText();
				String repassword = lbrptxt.getText();

				JOptionPane.showMessageDialog(null, "Registration Successfully");
				setVisible(false);

				try

				{
					Conn conn = new Conn();

					String query = "insert into signin values('" + Username + "', '" + ddate + "','" + password + "','"
							+ repassword + "')";// DML
// command

					conn.s.executeUpdate(query);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		} else if (e.getSource() == cls)

		{
			setVisible(false);
		}

		else if (e.getSource() == rt) {
			lbutxt.setText(null);
			lbptxt.setText(null);

			lbrptxt.setText(null);
			dcdate.setDate(null);
		}
	}

	public static void main(String[] args) {
		signin f = new signin();

	}
}