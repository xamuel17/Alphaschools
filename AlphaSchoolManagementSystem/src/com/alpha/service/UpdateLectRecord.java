package com.alpha.service;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import com.alpha.database.DatabaseConnect;
import com.alpha.model.LoginModel;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class UpdateLectRecord extends JFrame {

	private JPanel contentPane;
	private JTextField txtLid;
	private JTextField txtLfname;
	private JTextField txtLlname;
	private JTextField txtLemail;
	private JTextField txtLuname;
	private JTextField txtLpass;
	private JTextField txtLname;
	
	
	private Connection conn;
	private PreparedStatement statement= null;
	private ResultSet result = null;
	private HashMap<String, Integer> hmap = new HashMap<>();
	private JComboBox cbolevel;
	private JComboBox cboLdept;
	private JLabel lblMessage;
	
	//lecturer details
	private String fname,lname,email,uname,pass,name;
	private int dept,staff_id;
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
			 cboLdept.addItem(name);
			// cbolevel.addItem(name);
		
			}
		}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Unable to get data from database");
				ex.printStackTrace();
			}
			
			
		
		
		}
	public UpdateLectRecord(LoginModel lg) {
		setUndecorated(true);
		setTitle("Update Lecturer Record");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 566, 408);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 566, 408);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 102)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 11, 540, 120);
		panel.add(panel_1);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setBounds(10, 11, 71, 14);
		panel_1.add(lblName);
		
		JLabel lblStaffId = new JLabel("Staff ID:");
		lblStaffId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStaffId.setBounds(259, 11, 71, 14);
		panel_1.add(lblStaffId);
		
		txtLid = new JTextField();
		txtLid.setColumns(10);
		txtLid.setBounds(316, 8, 132, 20);
		panel_1.add(txtLid);
		
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				if( !txtLname.getText().equals("") && !txtLid.getText().equals("") ) {
					try {
						DatabaseConnect obj = new DatabaseConnect();
						conn = obj.getConnection();
						
						String sql = "SELECT * FROM lecturer WHERE  firstname=? AND staff_id=?" ;
					
						
						//create prepared statement
						statement = conn.prepareStatement(sql);
						

						//set parameters
					
						statement.setString(1, txtLname.getText());
						 statement.setString(2, txtLid.getText());
						 
						
						
						// store values in result set
						
						result = statement.executeQuery();
						if(result.next() ) {
					
							fname =result.getString("firstname");
							 lname=result.getString("lastname");
							 email = result.getString("email");
						
							uname=result.getString("username");
							pass=result.getString("password");
						dept=result.getInt("dept_id");
						staff_id = result.getInt("staff_id");


						lblMessage.setText("Record Found!! ");
							
							
							txtLfname.setText(fname);
							txtLlname.setText(lname);
							txtLemail.setText(email);
							txtLuname.setText(uname);
							txtLpass.setText(pass);
							
							
							
							//cboDeptU.setSelectedIndex(deptid);
							
						} 
						
						else{
							lblMessage.setText("No Record Found!! ");
						}
					}catch(Exception ex) {
						
						JOptionPane.showMessageDialog(null, "Could not connect to database","", JOptionPane.ERROR_MESSAGE);
						
						ex.printStackTrace();
						System.out.println(ex);
					}	
						
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Fields must not be empty.","Empty Field", JOptionPane.INFORMATION_MESSAGE);
						
					}
				
				
				
				/////
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBackground(new Color(0, 0, 102));
		button.setBounds(316, 67, 141, 23);
		panel_1.add(button);
		
		 lblMessage = new JLabel("");
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMessage.setBounds(64, 80, 167, 39);
		panel_1.add(lblMessage);
		
		txtLname = new JTextField();
		txtLname.setColumns(10);
		txtLname.setBounds(53, 8, 158, 20);
		panel_1.add(txtLname);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 102)));
		panel_2.setBounds(10, 153, 540, 183);
		panel.add(panel_2);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				ManageLectRecord mr = new ManageLectRecord(null);
				setVisible(false);
					
					//mr.setVisible(true);
				
				try {
					
					DatabaseConnect obj = new DatabaseConnect();
					conn = obj.getConnection();
					
					
					
					String  fn = txtLname.getText();
					String ln= txtLlname.getText();
					String em=txtLemail.getText();
					String un=txtLuname.getText();
					String pu= txtLpass.getText();
					String lu=cboLdept.getSelectedItem().toString();
					
					int  sdept_id =cboLdept.getSelectedIndex();
					int deptid =cboLdept.getSelectedIndex();
		            ArrayList<String> keyList = new ArrayList<>(hmap.keySet());
				     String key = keyList.get(deptid);
				     sdept_id = hmap.get(key);	
					
				
					
					String sql = "UPDATE lecturer "
			                + "SET firstname = '"+fn+"',lastname='"+ln+"',email = '"+em+"',dept_id ='"+sdept_id+"',username='"+un+"',password='"+pu+"'"
			                + "WHERE staff_id ='"+staff_id+"'";
					
				
					statement = conn.prepareStatement(sql);
					
					
					  statement.executeUpdate(sql);
					if(statement.executeUpdate(sql) > 0 ) {
						JOptionPane.showMessageDialog(null, "Update Successful!" );
						
					}else {
						JOptionPane.showMessageDialog(null, "Update Failed!" );
					}
				
				}catch(Exception ex) {
					
					JOptionPane.showMessageDialog(null, "Could not connect to database" );
					ex.printStackTrace();
					System.out.print(ex);
				}
				}
				
				
			
		});
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdate.setBackground(new Color(0, 0, 102));
		btnUpdate.setBounds(312, 129, 93, 23);
		panel_2.add(btnUpdate);
		
		JLabel label_3 = new JLabel("Firstname:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(10, 11, 71, 14);
		panel_2.add(label_3);
		
		txtLfname = new JTextField();
		txtLfname.setColumns(10);
		txtLfname.setBounds(79, 8, 141, 20);
		panel_2.add(txtLfname);
		
		JLabel label_4 = new JLabel("Lastname:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(243, 14, 71, 14);
		panel_2.add(label_4);
		
		txtLlname = new JTextField();
		txtLlname.setColumns(10);
		txtLlname.setBounds(312, 11, 141, 20);
		panel_2.add(txtLlname);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(10, 39, 71, 14);
		panel_2.add(lblEmail);
		
		txtLemail = new JTextField();
		txtLemail.setColumns(10);
		txtLemail.setBounds(79, 36, 141, 20);
		panel_2.add(txtLemail);
		
		JLabel label_6 = new JLabel("UserName");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_6.setBounds(243, 42, 71, 14);
		panel_2.add(label_6);
		
		txtLuname = new JTextField();
		txtLuname.setColumns(10);
		txtLuname.setBounds(312, 39, 141, 20);
		panel_2.add(txtLuname);
		
		txtLpass = new JTextField();
		txtLpass.setColumns(10);
		txtLpass.setBounds(79, 64, 141, 20);
		panel_2.add(txtLpass);
		
		JLabel label_7 = new JLabel("Password");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_7.setBounds(10, 67, 71, 14);
		panel_2.add(label_7);
		
		JLabel label_9 = new JLabel("Dept.");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_9.setBounds(243, 70, 71, 14);
		panel_2.add(label_9);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ManageLectRecord mg = new ManageLectRecord(lg);
				setVisible(false);
				//mg.setVisible(true);
			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExit.setBackground(new Color(0, 0, 102));
		btnExit.setBounds(415, 129, 93, 23);
		panel_2.add(btnExit);
		
		 cboLdept = new JComboBox();
		cboLdept.setBounds(312, 70, 141, 20);
		panel_2.add(cboLdept);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
	try {
					
					DatabaseConnect obj = new DatabaseConnect();
					conn = obj.getConnection();
					
					
					
					String  fn = txtLname.getText();
					String ln= txtLlname.getText();
					String em=txtLemail.getText();
					String un=txtLuname.getText();
					String pu= txtLpass.getText();
					String lu=cboLdept.getSelectedItem().toString();
					
					int  sdept_id =cboLdept.getSelectedIndex();
					int deptid =cboLdept.getSelectedIndex();
		            ArrayList<String> keyList = new ArrayList<>(hmap.keySet());
				     String key = keyList.get(deptid);
				     sdept_id = hmap.get(key);	
					
				
					
					String sql = "DELETE FROM lecturer WHERE staff_id ='"+staff_id+"'";
					
				
					statement = conn.prepareStatement(sql);
					
					
					  statement.executeUpdate(sql);
					if(statement.executeUpdate(sql) > 0 ) {
						JOptionPane.showMessageDialog(null, "Delete Failed!" );
						
					}else {
						JOptionPane.showMessageDialog(null, "Delete Successful!" );
					}
				
				}catch(Exception ex) {
					
					JOptionPane.showMessageDialog(null, "Could not connect to database" );
					ex.printStackTrace();
					System.out.print(ex);
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.setBackground(new Color(0, 0, 102));
		btnDelete.setBounds(209, 129, 93, 23);
		panel_2.add(btnDelete);
		comboFill();
	}
}
