package com.alpha.service;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.alpha.database.DatabaseConnect;
import com.alpha.model.Department;
import com.alpha.model.LoginModel;

import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class RegAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField txtAd_Fname;
	private JTextField txtAd_Lname;
	private JTextField txtAd_email;
	private JTextField txtAd_Uname;
	private JTextField txtAd_Pho;
	private JPasswordField txtAd_Pass;
	private String firstname;
	private String lastname;
	private String email;
	private String username;
	private String phoneno;
	private String password;
	private  int sum;
	private Connection con;
	private PreparedStatement stmt = null;
	private ResultSet result = null;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public RegAdmin(LoginModel lg) {
		setResizable(false);
		setTitle("Admin Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 102));
		panel.setBounds(0, 0, 624, 26);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 32, 624, 424);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(null);
		panel_3.setBounds(79, 0, 384, 434);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 102));
		panel_4.setLayout(null);
		panel_4.setBounds(10, 23, 294, 332);
		panel_3.add(panel_4);
		
		JLabel label = new JLabel("FIRST NAME");
		label.setForeground(Color.WHITE);
		label.setBackground(Color.WHITE);
		label.setFont(new Font("Times New Roman", Font.BOLD, 11));
		label.setBounds(10, 43, 76, 14);
		panel_4.add(label);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.RED);
		panel_5.setBounds(0, 0, 294, 18);
		panel_4.add(panel_5);
		
		JLabel lblAdminRegistration = new JLabel("Admin Registration");
		lblAdminRegistration.setForeground(Color.WHITE);
		lblAdminRegistration.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAdminRegistration.setBounds(10, 0, 128, 14);
		panel_5.add(lblAdminRegistration);
		
		JLabel label_2 = new JLabel("LAST NAME");
		label_2.setForeground(Color.WHITE);
		label_2.setBackground(Color.WHITE);
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 11));
		label_2.setBounds(10, 74, 76, 14);
		panel_4.add(label_2);
		
		JLabel label_3 = new JLabel("Email");
		label_3.setForeground(Color.WHITE);
		label_3.setBackground(Color.WHITE);
		label_3.setFont(new Font("Times New Roman", Font.BOLD, 11));
		label_3.setBounds(10, 105, 76, 14);
		panel_4.add(label_3);
		
		txtAd_Fname = new JTextField();
		txtAd_Fname.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtAd_Fname.setColumns(10);
		txtAd_Fname.setBackground(Color.WHITE);
		txtAd_Fname.setBounds(93, 40, 180, 20);
		panel_4.add(txtAd_Fname);
		
		txtAd_Lname = new JTextField();
		txtAd_Lname.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtAd_Lname.setColumns(10);
		txtAd_Lname.setBackground(Color.WHITE);
		txtAd_Lname.setBounds(93, 71, 180, 20);
		panel_4.add(txtAd_Lname);
		
		txtAd_email = new JTextField();
		txtAd_email.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtAd_email.setColumns(10);
		txtAd_email.setBackground(Color.WHITE);
		txtAd_email.setBounds(93, 102, 180, 20);
		panel_4.add(txtAd_email);
		
		JLabel label_4 = new JLabel("USERNAME");
		label_4.setForeground(Color.WHITE);
		label_4.setBackground(Color.WHITE);
		label_4.setFont(new Font("Times New Roman", Font.BOLD, 11));
		label_4.setBounds(10, 136, 76, 14);
		panel_4.add(label_4);
		
		txtAd_Uname = new JTextField();
		txtAd_Uname.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtAd_Uname.setColumns(10);
		txtAd_Uname.setBackground(Color.WHITE);
		txtAd_Uname.setBounds(93, 133, 180, 20);
		panel_4.add(txtAd_Uname);
		
		JLabel label_5 = new JLabel("PASSWORD");
		label_5.setForeground(Color.WHITE);
		label_5.setBackground(Color.WHITE);
		label_5.setFont(new Font("Times New Roman", Font.BOLD, 11));
		label_5.setBounds(10, 167, 76, 14);
		panel_4.add(label_5);
		
		JLabel label_6 = new JLabel("PHONE No.");
		label_6.setForeground(Color.WHITE);
		label_6.setBackground(Color.WHITE);
		label_6.setFont(new Font("Times New Roman", Font.BOLD, 11));
		label_6.setBounds(10, 199, 76, 14);
		panel_4.add(label_6);
		
		txtAd_Pho = new JTextField();
		txtAd_Pho.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtAd_Pho.setColumns(10);
		txtAd_Pho.setBackground(Color.WHITE);
		txtAd_Pho.setBounds(93, 195, 180, 20);
		panel_4.add(txtAd_Pho);
		
		JButton btnAd_Reg = new JButton("Register!");
		btnAd_Reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(!txtAd_Fname.getText().equals("") && !txtAd_Lname.getText().equals("") && !txtAd_email.getText().equals("") && !txtAd_Pho.getText().equals("") && !txtAd_Pass.getText().equals("")) {
					DatabaseConnect obj = new DatabaseConnect();
					 String sql;
				try {
					//Get connection
				
					con = obj.getConnection();
					
					  firstname= txtAd_Fname.getText();
					  lastname=txtAd_Lname.getText();
					 email= txtAd_email.getText();
					 username =  txtAd_Uname.getText();
					 password = txtAd_Pass.getText();
					  phoneno = txtAd_Pho.getText();
					  
					  sql ="SELECT * FROM admin WHERE first_name=? AND email =? AND phoneNo=? AND username =?";
					 stmt = con.prepareStatement(sql);
					 // bind parameters
					 stmt.setString(1,txtAd_Fname.getText());
					 stmt.setString(2,txtAd_email.getText());
					 stmt.setString(3,txtAd_Pho.getText());
					 stmt.setString(4,txtAd_Uname.getText());
						result = stmt.executeQuery();
						if(result.next()) {
							JOptionPane.showMessageDialog(null, "Admin Profile Already Exists!"); 
							
						}
						
							 
						
						
						else {  
							 sql = "INSERT INTO admin(first_name,last_name,email,username,password,phoneNo) VALUES('"+firstname+"','"+lastname+"','"+email+"','"+username+"','"+password+"','"+phoneno+"')";
						
			
				//prepare statement
					 stmt = con.prepareStatement(sql);
					 //bind parameters to the query
//					 stmt.setString(1, "dd");
//					 stmt.setString(2, "dd");
//					 stmt.setString(3, "dd");
//					 stmt.setString(4, "dd");
//					 stmt.setString(5, "dd");
//					 stmt.setString(6, "dd");
					 
					
					 if(stmt.executeUpdate(sql) > 0) {
						 JOptionPane.showMessageDialog(null, "Admin Successfully Registered!"); 
						 
					 }
					 else {
						 JOptionPane.showMessageDialog(null, "Registration failed!"); 	 
					 }
						} 
					
				}catch(SQLException e) {
					//System.out.println(firstname+"-->"+lastname+"--->"+email+"--->"+username+"--->"+phoneno+"--->"+password);
					System.out.println(e.toString());
					e.printStackTrace();
				}
				} else{
					JOptionPane.showMessageDialog(null, "Some fields are empty,Try again!", "Validation", JOptionPane.WARNING_MESSAGE);
		
				} 
				
				
			}
			
		});
		btnAd_Reg.setForeground(Color.WHITE);
		btnAd_Reg.setFont(new Font("Garamond", Font.BOLD, 17));
		btnAd_Reg.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAd_Reg.setBackground(new Color(0, 51, 255));
		btnAd_Reg.setBounds(93, 236, 83, 23);
		panel_4.add(btnAd_Reg);
		
		txtAd_Pass = new JPasswordField();
		txtAd_Pass.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtAd_Pass.setColumns(10);
		txtAd_Pass.setBackground(Color.WHITE);
		txtAd_Pass.setBounds(93, 164, 180, 20);
		panel_4.add(txtAd_Pass);
		
		JButton button = new JButton("Exit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage adp = new AdminPage(lg);
				setVisible(false);
				adp.setVisible(true);
				
			}
		});
		button.setBounds(186, 236, 87, 23);
		panel_4.add(button);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Garamond", Font.BOLD, 17));
		button.setBackground(new Color(165, 42, 42));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 102));
		panel_2.setBounds(0, 469, 624, 26);
		contentPane.add(panel_2);
	}

}
