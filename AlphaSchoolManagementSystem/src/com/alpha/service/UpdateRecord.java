package com.alpha.service;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.border.LineBorder;

import com.alpha.database.DatabaseConnect;
import com.alpha.model.LoginModel;

public class UpdateRecord extends JFrame {

	private JPanel contentPane;
	private JTextField txtmatnoS;
	private JTextField txtfnameU;
	private JTextField txtlnameU;
	private JTextField txtMatnoU;
	private JTextField txtunameU;
	private JTextField txtpassU;
	private JLabel lblResult;
	private String	sfname, slname,sMatric,sUsername,sPass,hlevel;
private String level[] = {hlevel,"100","200","300","400","500","600"} ;
private String name,Level;



private int sreg_id,sdept_id;

private Connection conn;
private PreparedStatement statement= null;
private ResultSet result = null;
private HashMap<String, Integer> hmap = new HashMap<>();
private JComboBox cbolevel;


private JComboBox cbolevelU,cboDeptU;
	/**
	 * Launch the application.
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
		 cboDeptU.addItem(name);
		// cbolevel.addItem(name);
	
		}
	}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Unable to get data from database");
			ex.printStackTrace();
		}
		
		
	
	
	}
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UpdateRecord frame = new UpdateRecord();
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
	public UpdateRecord(LoginModel lg) {
	
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 566, 408);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 102)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 540, 119);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSlevel = new JLabel("Level:");
		lblSlevel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSlevel.setBounds(10, 11, 71, 14);
		panel.add(lblSlevel);
		
		JLabel lblMatricNo = new JLabel("Matric no:");
		lblMatricNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMatricNo.setBounds(259, 11, 71, 14);
		panel.add(lblMatricNo);
		
		txtmatnoS = new JTextField();
		txtmatnoS.setColumns(10);
		txtmatnoS.setBounds(325, 8, 123, 20);
		panel.add(txtmatnoS);
		
		JButton btnSearch = new JButton("Search");
	
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if( !txtmatnoS.getText().equals("") ) {
				try {
					DatabaseConnect obj = new DatabaseConnect();
					conn = obj.getConnection();
					
					String sql = "SELECT * FROM student WHERE  matric_no=? AND level=?" ;
				
					
					//create prepared statement
					statement = conn.prepareStatement(sql);
					

					//set parameters
				
					statement.setString(1, txtmatnoS.getText());
					 statement.setString(2, cbolevel.getSelectedItem().toString());
					 
					
					
					// store values in result set
					
					result = statement.executeQuery();
					if(result.next() ) {
				
						sfname =result.getString("first_name");
						 slname=result.getString("last_name");
						 hlevel = result.getString("level");
						sMatric = result.getString("matric_no");
						sUsername=result.getString("username");
						sPass=result.getString("password");
					sreg_id=result.getInt("reg_id");
					sdept_id=result.getInt("dept_id");	
					lblResult.setText("Record Found!! ");
						
						
						txtfnameU.setText(sfname);
						txtlnameU.setText(slname);
						txtMatnoU.setText(sMatric);
						txtunameU.setText(sUsername);
						txtpassU.setText(sPass);
						//txtlevelU.setText(hlevel);
						cbolevelU.setSelectedItem(hlevel);
						
						//cboDeptU.setSelectedIndex(deptid);
						
					} 
					
					else{
						lblResult.setText("No Record Found!! ");
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
			}
		});
		btnSearch.setBackground(new Color(0, 0, 102));
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSearch.setBounds(321, 66, 141, 23);
		panel.add(btnSearch);
		
	 lblResult = new JLabel("");
		lblResult.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblResult.setBounds(64, 80, 167, 39);
		panel.add(lblResult);
		
		 cbolevel = new JComboBox(level);
		cbolevel.setBorder(null);
		cbolevel.setBounds(64, 8, 157, 20);
		panel.add(cbolevel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 102)));
		panel_1.setBounds(10, 152, 540, 183);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(0, 0, 102));
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdate.setBounds(312, 129, 93, 23);
		panel_1.add(btnUpdate);
		
		JLabel label = new JLabel("Firstname:");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(10, 11, 71, 14);
		panel_1.add(label);
		
		txtfnameU = new JTextField();
		txtfnameU.setColumns(10);
		txtfnameU.setBounds(79, 8, 141, 20);
		panel_1.add(txtfnameU);
		
		JLabel lblLastname = new JLabel("Lastname:");
		lblLastname.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLastname.setBounds(243, 14, 71, 14);
		panel_1.add(lblLastname);
		
		txtlnameU = new JTextField();
		txtlnameU.setColumns(10);
		txtlnameU.setBounds(312, 11, 141, 20);
		panel_1.add(txtlnameU);
		
		JLabel lblMatricNo_1 = new JLabel("Matric no");
		lblMatricNo_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMatricNo_1.setBounds(10, 39, 71, 14);
		panel_1.add(lblMatricNo_1);
		
		txtMatnoU = new JTextField();
		txtMatnoU.setColumns(10);
		txtMatnoU.setBounds(79, 36, 141, 20);
		panel_1.add(txtMatnoU);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsername.setBounds(243, 42, 71, 14);
		panel_1.add(lblUsername);
		
		txtunameU = new JTextField();
		txtunameU.setColumns(10);
		txtunameU.setBounds(312, 39, 141, 20);
		panel_1.add(txtunameU);
		
		txtpassU = new JTextField();
		txtpassU.setColumns(10);
		txtpassU.setBounds(79, 64, 141, 20);
		panel_1.add(txtpassU);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(10, 67, 71, 14);
		panel_1.add(lblPassword);
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLevel.setBounds(243, 67, 71, 14);
		panel_1.add(lblLevel);
		
		JLabel lblDepartment = new JLabel("Dept.");
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDepartment.setBounds(10, 101, 71, 14);
		panel_1.add(lblDepartment);
		
	 
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			}
		});
		btnExit.setBackground(new Color(0, 0, 102));
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExit.setBounds(415, 129, 93, 23);
		panel_1.add(btnExit);
		
		 cbolevelU = new JComboBox(level);
		cbolevelU.setBounds(312, 70, 141, 20);
		panel_1.add(cbolevelU);
		
		cboDeptU = new JComboBox();
		cboDeptU.setBounds(79, 98, 141, 20);
		panel_1.add(cboDeptU);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					DatabaseConnect obj = new DatabaseConnect();
					conn = obj.getConnection();
					
					
					
					String  fn = txtfnameU.getText();
					String ln= txtlnameU.getText();
					String mn=txtMatnoU.getText();
					String un=txtunameU.getText();
					String pu= txtpassU.getText();
					String lu=cbolevelU.getSelectedItem().toString();
					
					 sdept_id =cboDeptU.getSelectedIndex();
					int deptid =cboDeptU.getSelectedIndex();
		            ArrayList<String> keyList = new ArrayList<>(hmap.keySet());
				     String key = keyList.get(deptid);
				     sdept_id = hmap.get(key);	
					
				
					
					String sql = "DELETE FROM student WHERE reg_id ='"+sreg_id+"'";
					
				
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
		btnDelete.setBounds(205, 129, 93, 23);
		panel_1.add(btnDelete);
		comboFill();
		//////////////////////////////////////////////////////////////////////
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageStudRecord mr = new ManageStudRecord(lg);
			setVisible(false);
				
				//mr.setVisible(true);
			
			try {
				
				DatabaseConnect obj = new DatabaseConnect();
				conn = obj.getConnection();
				
				
				
				String  fn = txtfnameU.getText();
				String ln= txtlnameU.getText();
				String mn=txtMatnoU.getText();
				String un=txtunameU.getText();
				String pu= txtpassU.getText();
				String lu=cbolevelU.getSelectedItem().toString();
				
				 sdept_id =cboDeptU.getSelectedIndex();
				int deptid =cboDeptU.getSelectedIndex();
	            ArrayList<String> keyList = new ArrayList<>(hmap.keySet());
			     String key = keyList.get(deptid);
			     sdept_id = hmap.get(key);	
				
			
				
				String sql = "UPDATE student "
		                + "SET first_name = '"+fn+"',last_name='"+ln+"',matric_no = '"+mn+"',dept_id ='"+sdept_id+"',username='"+un+"',password='"+pu+"'"
		                + "WHERE reg_id ='"+sreg_id+"'";
				
			
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
	}
}
