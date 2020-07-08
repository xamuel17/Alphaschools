package com.alpha.service;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.alpha.database.DatabaseConnect;
import com.alpha.model.LoginModel;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class DepartmentRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField txtReg_Fac;
	private JTextField txtRec_Dep;
	private JTextField txtReg_Hod;
	private JTextArea textArea;
	private JButton button_2;
private String fac,dep,hod;
private int numlec;
private Connection con;
private PreparedStatement stmt=null;
private ResultSet rs=null;
private JTextField txtReg_lec;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DepartmentRegistration frame = new DepartmentRegistration();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */


//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//String getNonBlankInput(String prompt) {
//	   String input = JOptionPane.showInputDialog(prompt);
//
//	   while (dep_code.equals("")) {
//	      JOptionPane.showMessageDialog(null, "Cannot accept blank entries!");
//	      dep_code = JOptionPane.showInputDialog(prompt);
//	   }
//
//	   return input;
//	}
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>



	public DepartmentRegistration(LoginModel lg) {
		setTitle("Department Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 523);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 40, 490, 402);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setFont(new Font("Verdana", Font.BOLD, 11));
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 102));
		panel_1.setBounds(74, 29, 294, 332);
		panel.add(panel_1);
		
		JLabel lblFaculty = new JLabel("FACULTY");
		lblFaculty.setForeground(new Color(255, 255, 255));
		lblFaculty.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblFaculty.setBounds(10, 43, 76, 14);
		panel_1.add(lblFaculty);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(204, 0, 0));
		panel_2.setBounds(0, 0, 294, 18);
		panel_1.add(panel_2);
		
		JLabel lblDepartmentRegistration = new JLabel("Department Registration");
		lblDepartmentRegistration.setForeground(Color.WHITE);
		lblDepartmentRegistration.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDepartmentRegistration.setBounds(10, 0, 227, 14);
		panel_2.add(lblDepartmentRegistration);
		
		JLabel lblDepartment = new JLabel("DEPARTMENT");
		lblDepartment.setForeground(new Color(255, 255, 255));
		lblDepartment.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblDepartment.setBounds(10, 74, 76, 14);
		panel_1.add(lblDepartment);
		
		JLabel lblDeptCode = new JLabel("Head Of Dept");
		lblDeptCode.setForeground(new Color(255, 255, 255));
		lblDeptCode.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblDeptCode.setBounds(10, 129, 76, 14);
		panel_1.add(lblDeptCode);
		
		txtReg_Fac = new JTextField();
		txtReg_Fac.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
			
			}
		});
		txtReg_Fac.setColumns(10);
		txtReg_Fac.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtReg_Fac.setBackground(new Color(255, 255, 255));
		txtReg_Fac.setBounds(93, 40, 180, 20);
		panel_1.add(txtReg_Fac);
		
		txtRec_Dep = new JTextField();
		txtRec_Dep.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) 
			{
			
			}
		});
		
		txtRec_Dep.setColumns(10);
		txtRec_Dep.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtRec_Dep.setBackground(new Color(255, 255, 255));
		txtRec_Dep.setBounds(93, 71, 180, 20);
		panel_1.add(txtRec_Dep);
		
		txtReg_Hod = new JTextField();
		
		txtReg_Hod.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				button_2.setVisible(true);
			}
		});
		txtReg_Hod.setColumns(10);
		txtReg_Hod.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtReg_Hod.setBackground(new Color(255, 255, 255));
		txtReg_Hod.setBounds(93, 126, 180, 20);
		panel_1.add(txtReg_Hod);
		
		JButton btnReg = new JButton("Register!");
		btnReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if(!txtReg_Fac.getText().equals("") && !txtRec_Dep.getText().equals("") && !txtReg_Hod.getText().equals("")&&!txtReg_lec.getText().equals("") && !txtReg_Hod.getText().equals("") ) {
				String sql;
				try {
					//get connection
					DatabaseConnect obj = new DatabaseConnect();
					con = obj.getConnection();
					
					// sql query
					
					 sql ="SELECT * FROM dept_registration WHERE department =? AND faculty =?";
					 stmt = con.prepareStatement(sql);
					 // bind parameters
					 stmt.setString(1,dep);
					 stmt.setString(2, fac);
					 
					
						rs = stmt.executeQuery();
						if(rs.next()) {
							JOptionPane.showMessageDialog(null, "Department Already Exists!"); 
							
						}
				   else {
					sql = "INSERT  INTO dept_registration (faculty,department,no_of_lecturers,hod_name)VALUES('"+fac+"','"+dep+"','"+numlec+"','"+hod+"')";
					//prepare statement
					stmt=con.prepareStatement(sql); 
//					stmt.setString(1, fac);
//					stmt.setString(2, dep);
//					stmt.setString(3, dep_code);
					 //execute query
					 if(stmt.executeUpdate(sql) > 0) {
						 JOptionPane.showMessageDialog(null, "Admin Successfully Registered!"); 
					 }
					 else {
						 JOptionPane.showMessageDialog(null, "Registration failed!"); 	 
					 }
					}
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Could not connect to database.", "Error", JOptionPane.ERROR_MESSAGE);
					System.out.println(e.toString());
					e.printStackTrace();
					
				}
				
			}	
			else {
				JOptionPane.showMessageDialog(null, "Field cannot be empty.", "Validate", JOptionPane.INFORMATION_MESSAGE);
				
			}
				
				
			}
		});
		btnReg.setForeground(Color.WHITE);
		btnReg.setFont(new Font("Garamond", Font.BOLD, 17));
		btnReg.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnReg.setBackground(new Color(0, 51, 255));
		btnReg.setBounds(93, 264, 83, 23);
		panel_1.add(btnReg);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage ap = new AdminPage(lg);
				setVisible(false);
				ap.setVisible(true);			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Garamond", Font.BOLD, 17));
		btnExit.setBackground(new Color(165, 42, 42));
		btnExit.setBounds(183, 264, 87, 23);
		panel_1.add(btnExit);
		
		 button_2 = new JButton(">>>");
		button_2.setVisible(false);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				fac =txtReg_Fac.getText().toUpperCase();
				dep = txtRec_Dep.getText().toUpperCase();
				hod=txtReg_Hod.getText().toUpperCase();
				numlec = Integer.parseInt(txtReg_lec.getText());
				
				
				textArea.setText("FACULTY: " + fac+ "\n"
								+ "DEPARTMENT: " +dep+"\n"
								+ "No.Of Lecturers: " + numlec+"\n"
								+"HOD: " +hod);
				}catch(Exception ex) {
					
					JOptionPane.showMessageDialog(null, "Wrong values. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button_2.setForeground(new Color(255, 255, 255));
		button_2.setFont(new Font("Tahoma", Font.BOLD, 8));
		button_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		button_2.setBackground(new Color(0, 0, 102));
		button_2.setBounds(239, 157, 34, 15);
		panel_1.add(button_2);
		
		 textArea = new JTextArea();
		 textArea.setForeground(new Color(255, 255, 255));
		 textArea.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textArea.setBorder(null);
		textArea.setBackground(new Color(153, 153, 255));
		textArea.setBounds(10, 177, 263, 76);
		panel_1.add(textArea);
		
		JLabel lblNoOfLectures = new JLabel("No. Of Lectures");
		lblNoOfLectures.setForeground(new Color(255, 255, 255));
		lblNoOfLectures.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblNoOfLectures.setBounds(10, 99, 94, 14);
		panel_1.add(lblNoOfLectures);
		
		txtReg_lec = new JTextField();
		
		txtReg_lec.setColumns(10);
		txtReg_lec.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtReg_lec.setBackground(Color.WHITE);
		txtReg_lec.setBounds(93, 96, 180, 20);
		panel_1.add(txtReg_lec);
		panel_1.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtReg_Fac, txtRec_Dep, txtReg_lec, txtReg_Hod, button_2}));
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtReg_Fac, txtRec_Dep, txtReg_Hod, button_2, btnReg, btnExit, textArea}));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtReg_Fac, txtRec_Dep, txtReg_lec, txtReg_Hod, button_2}));
	}
}
