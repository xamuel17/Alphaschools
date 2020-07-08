package com.alpha.service;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.border.LineBorder;

import com.alpha.database.DatabaseConnect;
import com.alpha.model.Department;
import com.alpha.model.LoginModel;
import com.alpha.model.UserDetails;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.sql.*;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField txtLect_Fname;
	private JTextField txtLect_Lname;
	private JTextField txtLect_email;
	private JTextField txtLect_Uname;
	private JTextField txtLect_pho;
	private JTextField txtLect_Pass;
	private JTextField txtStud_Fname;
	private JTextField txtStud_Lname;
	private JTextField txtStud_email;
	private JTextField txtStud_Uname;
	private JTextField txtStud_Pho;
	private JTextField txtStud_Pass;
	private JComboBox cboLect_Dept, cboStud_Dept;
	private JLabel lblDeptNam;
	
	//lecturer input
	private String Lfname;
	private String Llname,department;
	private String Lemail;
	private String Luname;
	private String  Lphone;
	private String Lpass,name,title;
	private int sum;
	private int ldept_id;
	private int adminId;
	
	
	//Student input
	private String name1,title1;
	private String sfname,slname, semail,suname,sphone,spass,sdept_id,slevel,smatric; 
	private Connection conn;
	private PreparedStatement statement= null;
	private ResultSet result = null;
	private JComboBox cboslevel;
	private String level[] = {"", "100", "200", "300", "400", "500", "600"};
	private JTextField txtsMat;
	private HashMap<String, Integer> hmap = new HashMap<>();
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public void comboFill() {
		try {
			//get connection
			DatabaseConnect obj = new DatabaseConnect();
			conn = obj.getConnection();
			
			
			String sql = "select * from dept_registration ";
			statement = conn.prepareStatement(sql);
			result = statement.executeQuery(sql);
			while(result.next()){
			 name = result.getString("department");
			 hmap.put(name, result.getInt("dept_id"));
			 cboLect_Dept.addItem(name);
			 cboStud_Dept.addItem(name);
			 
			 }
			
			
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Unable to get data from database");
			ex.printStackTrace();
		}
		
		
	}
	
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	
	
	public Registration(LoginModel lg) {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 102));
		panel.setBounds(0, 0, 739, 483);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(43, 239, 321, -178);
		panel.add(tabbedPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		panel_2.setBackground(new Color(255, 0, 0));
		panel_2.setBounds(0, 0, 739, 37);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblRegisteration = new JLabel("REGISTRATION");
		lblRegisteration.setForeground(new Color(255, 255, 255));
		lblRegisteration.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblRegisteration.setBounds(10, 0, 170, 37);
		panel_2.add(lblRegisteration);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(23, 48, 283, 370);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblFirstName = new JLabel("FIRST NAME");
		lblFirstName.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblFirstName.setBounds(10, 43, 76, 14);
		panel_3.add(lblFirstName);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(51, 102, 204));
		panel_4.setBounds(0, 0, 283, 18);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblLecturer = new JLabel("LECTURER");
		lblLecturer.setForeground(new Color(255, 255, 255));
		lblLecturer.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLecturer.setBounds(10, 0, 128, 14);
		panel_4.add(lblLecturer);
		
		JLabel lblLastMname = new JLabel("LAST NAME");
		lblLastMname.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblLastMname.setBounds(10, 74, 76, 14);
		panel_3.add(lblLastMname);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblEmail.setBounds(10, 105, 76, 14);
		panel_3.add(lblEmail);
		
		txtLect_Fname = new JTextField();
		txtLect_Fname.setBackground(new Color(204, 255, 255));
		txtLect_Fname.setBounds(93, 40, 180, 20);
		panel_3.add(txtLect_Fname);
		txtLect_Fname.setColumns(10);
		
		txtLect_Lname = new JTextField();
		txtLect_Lname.setBackground(new Color(204, 255, 255));
		txtLect_Lname.setColumns(10);
		txtLect_Lname.setBounds(93, 71, 180, 20);
		panel_3.add(txtLect_Lname);
		
		txtLect_email = new JTextField();
		txtLect_email.setBackground(new Color(204, 255, 255));
		txtLect_email.setColumns(10);
		txtLect_email.setBounds(93, 102, 180, 20);
		panel_3.add(txtLect_email);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblUsername.setBounds(10, 136, 76, 14);
		panel_3.add(lblUsername);
		
		txtLect_Uname = new JTextField();
		txtLect_Uname.setBackground(new Color(204, 255, 255));
		txtLect_Uname.setColumns(10);
		txtLect_Uname.setBounds(93, 133, 180, 20);
		panel_3.add(txtLect_Uname);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblPassword.setBounds(10, 167, 76, 14);
		panel_3.add(lblPassword);
		
		JLabel lblPhoneNo = new JLabel("PHONE No.");
		lblPhoneNo.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblPhoneNo.setBounds(10, 199, 76, 14);
		panel_3.add(lblPhoneNo);
		
		txtLect_pho = new JTextField();
		txtLect_pho.setColumns(10);
		txtLect_pho.setBackground(new Color(204, 255, 255));
		txtLect_pho.setBounds(93, 195, 180, 20);
		panel_3.add(txtLect_pho);
		
		JLabel lblDept = new JLabel("DEPT");
		lblDept.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblDept.setBounds(10, 235, 76, 14);
		panel_3.add(lblDept);
		
		JButton btnLect_Reg = new JButton("Register!");
		btnLect_Reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql;
				if(!txtLect_Fname.getText().equals("") && !txtLect_Lname.getText().equals("") && !txtLect_Uname.getText().equals("") && !txtLect_pho.getText().equals("") &&!txtLect_Pass.getText().equals("")){
					try {
						
				 Lfname= txtLect_Fname.getText();
				Llname = txtLect_Lname.getText();
				Lemail =  txtLect_email.getText();
				 Luname =txtLect_Uname.getText();
				Lphone= txtLect_pho.getText();
			 Lpass= txtLect_Pass.getText();
			 int deptid =cboLect_Dept.getSelectedIndex();
	            ArrayList<String> keyList = new ArrayList<>(hmap.keySet());
			     String key = keyList.get(deptid);
			     ldept_id = hmap.get(key);
			    
				adminId = lg.getAdminRegId();
			
				// get a connection
				DatabaseConnect obj = new DatabaseConnect();
				conn= obj.getConnection();
			  System.out.println("DEPT ID: "+ldept_id+"---ADMIN ID: "+adminId);
			  
			  
			  
			  
			  
			  
			  
			  sql ="SELECT * FROM lecturer WHERE phoneno=? AND email =?";
				 statement = conn.prepareStatement(sql);
				 // bind parameters
				 statement.setString(1,txtLect_pho.getText());
				 statement.setString(2, txtLect_email.getText());
				
					result = statement.executeQuery();
					if(result.next()) {
						JOptionPane.showMessageDialog(null, "Lecturer Profile Already Exists!"); 
						
					}
			  
			  
			  
					else {
			  
				// execute query
			 sql = "insert into lecturer"
						+ "(firstname,lastname,email,username,password,phoneno,admin_id,dept_id) "
						+ "values('"+Lfname+"','"+Llname+"','"+Lemail+"','"+Luname+"','"+Lpass+"','"+Lphone+"','"+adminId+"','"+ldept_id+"')";
		
				// create a statement
				 statement= conn.prepareStatement(sql);
				
			  if(statement.executeUpdate(sql) > 0) {
				  JOptionPane.showMessageDialog(null, "lecturer Successfully Registered!"); 
			  }
			  else {
				  JOptionPane.showMessageDialog(null, "Error occurred. Recheck input.");   
			  }
					}
				}catch(Exception ex){
					ex.printStackTrace();
					//JOptionPane.showMessageDialog(null, "Connection to database failed","Error!", JOptionPane.ERROR_MESSAGE);
				}
				}else {
					
					JOptionPane.showMessageDialog(null, "Some fields are empty!", "Validation", JOptionPane.INFORMATION_MESSAGE);
				}
				
				}
		});
		btnLect_Reg.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnLect_Reg.setForeground(new Color(255, 255, 255));
		btnLect_Reg.setFont(new Font("Garamond", Font.BOLD, 17));
		btnLect_Reg.setBackground(new Color(0, 51, 255));
		btnLect_Reg.setBounds(79, 270, 113, 23);
		panel_3.add(btnLect_Reg);
		
		txtLect_Pass = new JTextField();
		txtLect_Pass.setColumns(10);
		txtLect_Pass.setBackground(new Color(204, 255, 255));
		txtLect_Pass.setBounds(93, 164, 180, 20);
		panel_3.add(txtLect_Pass);
		
		 cboLect_Dept = new JComboBox();
		 cboLect_Dept.addKeyListener(new KeyAdapter() {
		 	@Override
		 	public void keyReleased(KeyEvent arg0) {
		 	
		 	}
		 	
		 });
		 cboLect_Dept.addItemListener(new ItemListener() {
		 	public void itemStateChanged(ItemEvent arg0) {
		
		 	
					
					
					
					
					}
		 });
		cboLect_Dept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		cboLect_Dept.setBackground(new Color(204, 255, 255));
		cboLect_Dept.setBounds(93, 232, 180, 20);
		panel_3.add(cboLect_Dept);
		
		 lblDeptNam = new JLabel("");
		lblDeptNam.setBounds(30, 321, 46, 14);
		panel_3.add(lblDeptNam);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(392, 48, 283, 370);
		panel.add(panel_5);
		
		JLabel label = new JLabel("FIRST NAME");
		label.setFont(new Font("Times New Roman", Font.BOLD, 11));
		label.setBounds(10, 43, 76, 14);
		panel_5.add(label);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(204, 102, 0));
		panel_6.setBounds(0, 0, 283, 18);
		panel_5.add(panel_6);
		
		JLabel lblStudent = new JLabel("STUDENT");
		lblStudent.setForeground(Color.WHITE);
		lblStudent.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStudent.setBounds(10, 0, 128, 14);
		panel_6.add(lblStudent);
		
		JLabel label_2 = new JLabel("LAST NAME");
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 11));
		label_2.setBounds(10, 74, 76, 14);
		panel_5.add(label_2);
		
		JLabel label_3 = new JLabel("Email");
		label_3.setFont(new Font("Times New Roman", Font.BOLD, 11));
		label_3.setBounds(10, 105, 76, 14);
		panel_5.add(label_3);
		
		txtStud_Fname = new JTextField();
		txtStud_Fname.setColumns(10);
		txtStud_Fname.setBackground(new Color(255, 255, 153));
		txtStud_Fname.setBounds(93, 40, 180, 20);
		panel_5.add(txtStud_Fname);
		
		txtStud_Lname = new JTextField();
		txtStud_Lname.setColumns(10);
		txtStud_Lname.setBackground(new Color(255, 255, 153));
		txtStud_Lname.setBounds(93, 71, 180, 20);
		panel_5.add(txtStud_Lname);
		
		txtStud_email = new JTextField();
		txtStud_email.setColumns(10);
		txtStud_email.setBackground(new Color(255, 255, 153));
		txtStud_email.setBounds(93, 102, 180, 20);
		panel_5.add(txtStud_email);
		
		JLabel label_4 = new JLabel("USERNAME");
		label_4.setFont(new Font("Times New Roman", Font.BOLD, 11));
		label_4.setBounds(10, 136, 76, 14);
		panel_5.add(label_4);
		
		txtStud_Uname = new JTextField();
		txtStud_Uname.setColumns(10);
		txtStud_Uname.setBackground(new Color(255, 255, 153));
		txtStud_Uname.setBounds(93, 133, 180, 20);
		panel_5.add(txtStud_Uname);
		
		JLabel label_5 = new JLabel("PASSWORD");
		label_5.setFont(new Font("Times New Roman", Font.BOLD, 11));
		label_5.setBounds(10, 167, 76, 14);
		panel_5.add(label_5);
		
		JLabel label_6 = new JLabel("PHONE No.");
		label_6.setFont(new Font("Times New Roman", Font.BOLD, 11));
		label_6.setBounds(10, 199, 76, 14);
		panel_5.add(label_6);
		
		txtStud_Pho = new JTextField();
		txtStud_Pho.setColumns(10);
		txtStud_Pho.setBackground(new Color(255, 255, 153));
		txtStud_Pho.setBounds(93, 195, 180, 20);
		panel_5.add(txtStud_Pho);
		
		JLabel lblDeptCode = new JLabel("DEPT CODE");
		lblDeptCode.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblDeptCode.setBounds(10, 224, 76, 14);
		panel_5.add(lblDeptCode);
		
		JButton btnStud_Reg = new JButton("Register!");
		btnStud_Reg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String sql;
				
				
				if(!txtStud_Fname.getText().equals("") && !txtStud_Lname.getText().equals("") && !txtStud_Uname.getText().equals("") && !txtStud_Pho.getText().equals("") &&!txtStud_Pass.getText().equals("")&&!txtsMat.getText().equals("")){
					try {
						
				 sfname= txtStud_Fname.getText();
				slname = txtStud_Lname.getText();
				slevel=cboslevel.getSelectedItem().toString();
				semail =  txtStud_email.getText();
				 suname =txtStud_Uname.getText();
				sphone= txtStud_Pho.getText();
				smatric = txtsMat.getText();
			 spass= txtStud_Pass.getText();
			 sdept_id =cboStud_Dept.getSelectedItem().toString();
			 int deptid =cboStud_Dept.getSelectedIndex();
	            ArrayList<String> keyList = new ArrayList<>(hmap.keySet());
			     String key = keyList.get(deptid);
			     ldept_id = hmap.get(key);
			    
			  
				adminId = lg.getAdminRegId();
				// get a connection
				DatabaseConnect obj = new DatabaseConnect();
				conn= obj.getConnection();
				
				
				 
				  sql ="SELECT * FROM student WHERE level=? AND matric_no =?";
					 statement = conn.prepareStatement(sql);
					 // bind parameters
					 statement.setString(1,cboslevel.getSelectedItem().toString());
					 statement.setString(2,txtsMat.getText());
					
						result = statement.executeQuery();
						if(result.next()) {
							JOptionPane.showMessageDialog(null, "Student Profile Already Exists!"); 
							
						}
				
				
				
				else {
				// execute query
				 sql = "insert into student"
						+ "(first_name,last_name,level,dept_id,email,matric_no,username,password,admin_id) "
						+ "values('"+sfname+"','"+slname+"','"+slevel+"','"+ldept_id+"','"+semail+"','"+smatric+"','"+suname+"','"+spass+"','"+adminId+"')";
		
				// create a statement
				 statement= conn.prepareStatement(sql);
				
			  if(statement.executeUpdate(sql) > 0) {
				  JOptionPane.showMessageDialog(null, "Student Successfully Registered!"); 
			  }
			  else {
				  JOptionPane.showMessageDialog(null, "Error occurred. Recheck input.");   
			  }
				}
				}catch(Exception ex){
					//ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Connection to database failed","Error!", JOptionPane.ERROR_MESSAGE);
				}
					
				}else {
					
					JOptionPane.showMessageDialog(null, "Some fields are empty!", "Validation", JOptionPane.INFORMATION_MESSAGE);
				}
				////////////////////////////////////////////////////////////////////////////////
			}
		});
		btnStud_Reg.setForeground(Color.WHITE);
		btnStud_Reg.setFont(new Font("Garamond", Font.BOLD, 17));
		btnStud_Reg.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnStud_Reg.setBackground(new Color(0, 51, 255));
		btnStud_Reg.setBounds(71, 321, 113, 23);
		panel_5.add(btnStud_Reg);
		
		txtStud_Pass = new JTextField();
		txtStud_Pass.setColumns(10);
		txtStud_Pass.setBackground(new Color(255, 255, 153));
		txtStud_Pass.setBounds(93, 164, 180, 20);
		panel_5.add(txtStud_Pass);
		
		JLabel lblLevel = new JLabel("LEVEL");
		lblLevel.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblLevel.setBounds(10, 254, 76, 14);
		panel_5.add(lblLevel);
		
		 cboslevel = new JComboBox(level);
		cboslevel.setBackground(new Color(255, 255, 153));
		cboslevel.setBounds(93, 251, 76, 20);
		panel_5.add(cboslevel);
		
		cboStud_Dept = new JComboBox();
		cboStud_Dept.setBackground(new Color(255, 255, 153));
		cboStud_Dept.setBounds(93, 221, 180, 20);
		panel_5.add(cboStud_Dept);
		
		JLabel lblMatricNo = new JLabel("MATRIC NO.");
		lblMatricNo.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblMatricNo.setBounds(10, 289, 76, 14);
		panel_5.add(lblMatricNo);
		
		txtsMat = new JTextField();
		txtsMat.setColumns(10);
		txtsMat.setBackground(new Color(255, 255, 153));
		txtsMat.setBounds(93, 286, 180, 20);
		panel_5.add(txtsMat);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage apg = new AdminPage(lg);
				setVisible(false);
				apg.setVisible(true);
			}
		});
		btnExit.setBackground(new Color(165, 42, 42));
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setFont(new Font("Stencil", Font.PLAIN, 25));
		btnExit.setBounds(288, 435, 155, 37);
		panel.add(btnExit);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), null));
		panel_1.setBackground(new Color(255, 0, 0));
		panel_1.setBounds(0, 480, 739, 38);
		contentPane.add(panel_1);
	}
}
