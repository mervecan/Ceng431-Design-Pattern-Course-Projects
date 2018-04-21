import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class LoginViewController {

	private JFrame frame;
	private JTextField txtUserName;
	private JTextField txtPassword;
	private JButton btnLogin;
	private JButton btnRegister;
	private User userModel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginViewController window = new LoginViewController();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the application.
	 */
	public LoginViewController() {
		initialize();
		userModel = new User();
		btnLogin.addActionListener(new LoginListener());
		btnRegister.addActionListener(new RegisterListener());
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		txtUserName = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtUserName, 74, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, txtUserName, 22, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		springLayout.putConstraint(SpringLayout.WEST, lblUsername, 27, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblUsername, -13, SpringLayout.NORTH, txtUserName);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		springLayout.putConstraint(SpringLayout.NORTH, lblPassword, 30, SpringLayout.SOUTH, txtUserName);
		springLayout.putConstraint(SpringLayout.WEST, lblPassword, 0, SpringLayout.WEST, txtUserName);
		frame.getContentPane().add(lblPassword);
		
		txtPassword = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, txtPassword, 27, SpringLayout.SOUTH, lblPassword);
		springLayout.putConstraint(SpringLayout.WEST, txtPassword, 0, SpringLayout.WEST, txtUserName);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		btnLogin = new JButton("Login");
		springLayout.putConstraint(SpringLayout.WEST, btnLogin, 0, SpringLayout.WEST, txtUserName);
		springLayout.putConstraint(SpringLayout.SOUTH, btnLogin, -24, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(btnLogin);
		
		btnRegister = new JButton("Register");
		springLayout.putConstraint(SpringLayout.NORTH, btnRegister, 0, SpringLayout.NORTH, btnLogin);
		springLayout.putConstraint(SpringLayout.WEST, btnRegister, 7, SpringLayout.EAST, btnLogin);
		frame.getContentPane().add(btnRegister);
	}
	
	class LoginListener implements ActionListener {
		String userName = "";
		String password = "";
		@Override
		public void actionPerformed(ActionEvent e) {
			userName = txtUserName.getText();
			password = txtPassword.getText();
			boolean result = userModel.login(userName, password);
			if(result) {
				new SecondFrame();
			}				
		}
	}
	
	class RegisterListener implements ActionListener {
		String userName = "";
		String password = "";
		@Override
		public void actionPerformed(ActionEvent e) {
			userName = txtUserName.getText();
			password = txtPassword.getText();
			boolean result = userModel.register(userName, password);
			System.out.println("result"+ result);
			if(result) {
				new SecondFrame();
			}				
		}
	}
	
	public class SecondFrame {
		private JFrame f = new JFrame("Second");
		
		public SecondFrame() {
		
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setSize(300,300);
			f.setVisible(true);
		}
	}
	
	}

