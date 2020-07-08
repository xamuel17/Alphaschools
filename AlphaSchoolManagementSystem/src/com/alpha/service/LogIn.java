package com.alpha.service;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.border.LineBorder;

import com.alpha.database.DatabaseConnect;
import com.alpha.model.LectLoginModel;
import com.alpha.model.LecturerDetails;
import com.alpha.model.LoginModel;
import com.alpha.model.StudLoginModel;
import com.alpha.model.StudentDetails;
import com.alpha.model.UserDetails;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.MouseEvent;
import java.awt.Component;

public class LogIn extends JFrame {
	private JTextField txtLect_Id;
	private JPasswordField txtLectPass;
	private JTextField txtstud_Id, txtemail;
	private JPasswordField txtstud_Pass;
	private JTextField textField_2;
	private JPasswordField passwordField_2;
	//private StudentPage stud_page;
	public String stud_id;
	private Connection con;
	private PreparedStatement stmt = null;
	private ResultSet result = null;
	/**
	 * Launch the application.
	 */
	
	
//public void studname() {
//stud_id= txtstud_Id.getText();
//
//		
//	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	public LogIn() {
		setLocationRelativeTo(null);
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		setResizable(false);
		setPreferredSize(new Dimension(1280, 720));
		
		setTitle("LogIn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 433);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setLocation(new Point(500, 700));
		contentPane.setBorder(null);
		contentPane.setLocation(700, 400);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 630, 104);
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAlphaEducate = new JLabel("ALPHA ");
		lblAlphaEducate.setBounds(133, 6, 388, 88);
		lblAlphaEducate.setBackground(Color.BLUE);
		lblAlphaEducate.setForeground(new Color(0, 0, 102));
		lblAlphaEducate.setFont(new Font("Segoe Marker", Font.BOLD, 99));
		panel.add(lblAlphaEducate);
		
		JLabel lblPro = new JLabel("PRO");
		lblPro.setBounds(401, 70, 41, 16);
		lblPro.setForeground(new Color(0, 0, 255));
		lblPro.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblPro);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 103, 630, 265);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		tabbedPane.setPreferredSize(new Dimension(7, 7));
		//tabbedPane.setBackground(new Color(0, 0, 102));
		tabbedPane.setForeground(Color.WHITE);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(tabbedPane);
		
		JPanel panel_Admin = new JPanel();
		panel_Admin.setForeground(Color.BLUE);
		panel_Admin.setBorder(null);
		panel_Admin.setBackground(Color.WHITE);
		tabbedPane.addTab("ADMIN LOGIN", null, panel_Admin, null);
		tabbedPane.setForegroundAt(0, Color.WHITE);
		tabbedPane.setBackgroundAt(0, Color.GRAY);
		panel_Admin.setLayout(null);
		
		JLabel lblAdminId_1 = new JLabel("ADMIN ID");
		lblAdminId_1.setBounds(10, 28, 81, 14);
		lblAdminId_1.setForeground(new Color(153, 0, 0));
		lblAdminId_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAdminId_1.setBackground(SystemColor.activeCaptionText);
		panel_Admin.add(lblAdminId_1);
		
		JLabel lblPassword_2 = new JLabel("PASSWORD");
		lblPassword_2.setBounds(10, 60, 81, 14);
		lblPassword_2.setForeground(new Color(153, 0, 0));
		lblPassword_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPassword_2.setBackground(Color.RED);
		panel_Admin.add(lblPassword_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(101, 26, 242, 20);
		textField_2.setBorder(new LineBorder(new Color(153, 0, 0)));
		panel_Admin.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnLogin_2 = new JButton("LOGIN");
		btnLogin_2.setBounds(101, 91, 89, 23);
		btnLogin_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!textField_2.getText().equals("") && !passwordField_2.getText().equals("")) {
					try {
						DatabaseConnect obj = new DatabaseConnect();
						con = obj.getConnection();
						
						System.out.println(new DatabaseConnect().getConnection());
						
						String sql = "SELECT * FROM admin WHERE username=? AND password=?";
						stmt = con.prepareStatement(sql);
						stmt.setString(1, textField_2.getText());
						stmt.setString(2, passwordField_2.getText());
						result = stmt.executeQuery();
						if(result.next()) {
						 LoginModel lg = UserDetails.loginDetails(result.getString("first_name"), result.getString("last_name"),result.getInt("admin_id"));
							
						 setVisible(false);
							AdminPage  ap = new AdminPage(lg);
							new Registration(lg);
							 ap.setVisible(true);	
						}
						else {
							JOptionPane.showMessageDialog(null, "Invalid login details.", "", JOptionPane.ERROR_MESSAGE);	
						}
							
					}
					catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Could not connect to database", "", JOptionPane.ERROR_MESSAGE);
						System.out.print(e);
						e.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "All fields are required.", "", JOptionPane.ERROR_MESSAGE);
				}
			
			
			}
		});
		btnLogin_2.setForeground(Color.WHITE);
		btnLogin_2.setBackground(new Color(153, 0, 0));
		btnLogin_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_Admin.add(btnLogin_2);
		
		JButton btnCancel_2 = new JButton("CANCEL");
		btnCancel_2.setBounds(221, 91, 89, 23);
		btnCancel_2.setForeground(Color.WHITE);
		btnCancel_2.setBackground(new Color(153, 0, 0));
		btnCancel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancel_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_Admin.add(btnCancel_2);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(101, 57, 242, 23);
		passwordField_2.setBorder(new LineBorder(new Color(153, 0, 0)));
		panel_Admin.add(passwordField_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 253, 635, 21);
		panel_1.setBackground(new Color(0, 0, 102));
		panel_Admin.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 240, 625, 23);
		panel_2.setBackground(new Color(204, 102, 0));
		panel_Admin.add(panel_2);
		
		JPanel panel_Student = new JPanel();
		panel_Student.setForeground(Color.GRAY);
		panel_Student.setBackground(Color.WHITE);
		tabbedPane.addTab("STUDENT LOGIN", null, panel_Student, "student login");
		tabbedPane.setBackgroundAt(1, Color.GRAY);
		panel_Student.setLayout(null);
		
		JLabel lblStudentId = new JLabel("STUDENT ID");
		lblStudentId.setForeground(new Color(204, 102, 0));
		lblStudentId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblStudentId.setBounds(10, 25, 95, 14);
		panel_Student.add(lblStudentId);
		
		JLabel lblPassword_1 = new JLabel("PASSWORD");
		lblPassword_1.setForeground(new Color(204, 102, 0));
		lblPassword_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPassword_1.setBounds(10, 64, 95, 14);
		panel_Student.add(lblPassword_1);
		
		txtstud_Id = new JTextField();
		txtstud_Id.setBorder(new LineBorder(new Color(204, 102, 0)));
		txtstud_Id.setDisabledTextColor(new Color(144, 238, 144));
		txtstud_Id.setBackground(Color.WHITE);
		txtstud_Id.setBounds(115, 23, 238, 23);
		panel_Student.add(txtstud_Id);
		txtstud_Id.setColumns(10);
		stud_id = txtstud_Id.getText();
		txtstud_Pass = new JPasswordField();
		txtstud_Pass.setBorder(new LineBorder(new Color(204, 102, 0)));
		txtstud_Pass.setBackground(Color.WHITE);
		txtstud_Pass.setBounds(115, 57, 238, 23);
		panel_Student.add(txtstud_Pass);
		
		JButton btbStudentLogin = new JButton("LOGIN");
		btbStudentLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!txtstud_Id.getText().equals("") && !txtstud_Pass.getText().equals("")) {
				try {
					//Get connection 
					DatabaseConnect obj =  new DatabaseConnect();
					con = obj.getConnection();
				
					// Execute SQl query statement
					String sql = "SELECT * FROM student WHERE username = ? AND password=?";
					stmt = con.prepareStatement(sql);
					stmt.setString(1,txtstud_Id.getText());
					stmt.setString(2, txtstud_Pass.getText());
					
					//Extract data from result set
					result = stmt.executeQuery();
					if(result.next()) {
						StudLoginModel slm = StudentDetails.loginDetails(result.getString("username"), result.getString("password"), result.getString("email"));
						setVisible(false);
						StudentPage  sp = new StudentPage(slm);
						 sp.setVisible(true);
						 
						
								 
						 
					} else {
						JOptionPane.showMessageDialog(null,  "Invalid login details", "",JOptionPane.ERROR_MESSAGE);
						
					}
				
					}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,  "could not connect to database","Attention!", JOptionPane.ERROR_MESSAGE);
				}
				
				}
				
				else {
					JOptionPane.showMessageDialog(null,"All fields are required","",JOptionPane.ERROR_MESSAGE);
					
				}	
				 
			}
			
		});
		btbStudentLogin.setForeground(Color.WHITE);
		btbStudentLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btbStudentLogin.setBackground(new Color(204, 102, 0));
		btbStudentLogin.setBounds(115, 109, 89, 23);
		panel_Student.add(btbStudentLogin);
		
		JButton btnCancel_1 = new JButton("CANCEL");
		btnCancel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancel_1.setForeground(Color.WHITE);
		btnCancel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancel_1.setBackground(new Color(204, 102, 0));
		btnCancel_1.setBounds(228, 109, 89, 23);
		panel_Student.add(btnCancel_1);
		
		JPanel panel_Teach = new JPanel();
		panel_Teach.setBackground(Color.WHITE);
		tabbedPane.addTab("LECTURER LOGIN", null, panel_Teach, null);
		tabbedPane.setForegroundAt(2, Color.WHITE);
		tabbedPane.setBackgroundAt(2, Color.GRAY);
		panel_Teach.setLayout(null);
		
		JLabel lblLect_Id = new JLabel("LECTURER  ID");
		lblLect_Id.setForeground(new Color(0, 0, 51));
		lblLect_Id.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblLect_Id.setBounds(10, 21, 128, 14);
		panel_Teach.add(lblLect_Id);
		
		txtLect_Id = new JTextField();
		txtLect_Id.setBackground(Color.WHITE);
		txtLect_Id.setBorder(new LineBorder(new Color(0, 0, 102)));
		txtLect_Id.setBounds(108, 19, 231, 20);
		panel_Teach.add(txtLect_Id);
		txtLect_Id.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(new Color(0, 0, 51));
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPassword.setBounds(20, 59, 92, 14);
		panel_Teach.add(lblPassword);
		
		txtLectPass = new JPasswordField();
		txtLectPass.setBackground(Color.WHITE);
		txtLectPass.setBorder(new LineBorder(new Color(0, 0, 102)));
		txtLectPass.setBounds(108, 57, 231, 20);
		panel_Teach.add(txtLectPass);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if(!txtLect_Id.getText().equals("") && !txtLectPass.getText().equals("")) {
				try {
					//get connection
					DatabaseConnect obj = new DatabaseConnect();
					con = obj.getConnection();
					
					// Execute query
					String sql = "SELECT * FROM lecturer WHERE username =? AND password =?";
					
					
					
					// execute prepare statement
					stmt = con.prepareStatement(sql);
					
					// get value to statement
					stmt.setString(1, txtLect_Id.getText());
					stmt.setString(2, txtLectPass.getText() );
					
					//extract data frm result set
					result = stmt.executeQuery();
				// this line of code points at the row, to check if there's a row with the input data	
				if(result.next()){
					LectLoginModel llm= LecturerDetails.LectloginDetails(result.getString("username"), result.getString("password"), result.getString("email"));
					setVisible(false);
					LecturerPage lp = new LecturerPage(llm);
					
					lp.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Invalid login details.", "", JOptionPane.ERROR_MESSAGE);
				}
					
				}catch (Exception ex) {
					
					System.out.print(ex);
					//JOptionPane.showMessageDialog(null, "Could not connect to database", "", JOptionPane.ERROR_MESSAGE);
					
				}
				
				
			}else {
				JOptionPane.showMessageDialog(null, "All fields are required.", "", JOptionPane.ERROR_MESSAGE);
				
				
			}
			
			
		}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(0, 0, 102));
		btnLogin.setBounds(114, 105, 89, 23);
		panel_Teach.add(btnLogin);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBackground(new Color(0, 0, 102));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBounds(228, 105, 89, 23);
		panel_Teach.add(btnCancel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 102));
		panel_3.setBounds(0, 384, 630, 21);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(204, 102, 0));
		panel_4.setBounds(0, 362, 630, 21);
		contentPane.add(panel_4);
	}
}
