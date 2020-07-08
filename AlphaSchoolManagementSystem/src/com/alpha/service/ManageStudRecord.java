package com.alpha.service;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.alpha.database.DatabaseConnect;
import com.alpha.model.LoginModel;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ManageStudRecord extends JFrame {

	private JPanel contentPane;
	private JTextField txtStudname;
	private JTable table;
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	
	 //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Get No blank Input<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	 String getNonBlankInput(String prompt) {
		   String input = JOptionPane.showInputDialog(prompt);

		   while (input.equals("")) {
		      JOptionPane.showMessageDialog(null, "Cannot accept blank entries!");
		      input = JOptionPane.showInputDialog(prompt);
		   }

		   return input;
		}
		//>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	
	public ManageStudRecord(LoginModel lg ) {
	
		setResizable(false);
		setBackground(new Color(0, 0, 102));
		setTitle("STUDENT RECORD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 712, 457);
		setBounds(100, 100, 873, 445);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(0, 0, 102));
		panel.setBounds(10, 11, 833, 407);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 102));
		panel_1.setBounds(0, 0, 833, 396);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 11, 823, 374);
		panel_1.add(panel_2);
		
		JLabel lblStud = new JLabel("STUDENT NAME");
		lblStud.setForeground(new Color(0, 0, 102));
		lblStud.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStud.setBounds(22, 11, 109, 14);
		panel_2.add(lblStud);
		
		txtStudname = new JTextField();
		txtStudname.setColumns(10);
		txtStudname.setBounds(136, 9, 185, 20);
		panel_2.add(txtStudname);
		
		JButton txtSsearch = new JButton("Search");
		txtSsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(!txtStudname.getText().equals("")) {
					try {
						DatabaseConnect obj = new DatabaseConnect();
						conn = obj.getConnection();
				
						String sql = "SELECT first_name,last_name,level,dept_id,matric_no,username,password FROM student WHERE first_name=? ";
						stmt = conn.prepareStatement(sql);
						stmt.setString(1, txtStudname.getText());

						rs = stmt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
//						if(rs.next()) {
//						 	
//						}
//						else {
//							JOptionPane.showMessageDialog(null, "Invalid login details.", "", JOptionPane.ERROR_MESSAGE);	
//						}
							
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "Could not connect to database", "", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "All fields are required.", "", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
				
				
				
				
			}
		});
		txtSsearch.setForeground(new Color(255, 255, 255));
		txtSsearch.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtSsearch.setBackground(new Color(0, 0, 102));
		txtSsearch.setBounds(336, 8, 89, 23);
		panel_2.add(txtSsearch);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(10, 33, 690, 319);
		panel_2.add(panel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 153));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"", "", "", "", "", "", ""
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(86);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(86);
		table.getColumnModel().getColumn(1).setMinWidth(28);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(41);
		table.getColumnModel().getColumn(2).setMinWidth(35);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(51);
		table.getColumnModel().getColumn(3).setMinWidth(51);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setMinWidth(20);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(86);
		table.getColumnModel().getColumn(5).setMinWidth(20);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(6).setPreferredWidth(86);
		table.getColumnModel().getColumn(6).setMinWidth(20);
		scrollPane.setViewportView(table);
		panel_3.setLayout(gl_panel_3);
		
		JButton btnSupdate = new JButton("Update");
		btnSupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
				UpdateRecord up = new UpdateRecord(lg);
				
				setVisible(true);
				
				up.setVisible(true);
				
			}
		});
		btnSupdate.setForeground(new Color(255, 255, 255));
		btnSupdate.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSupdate.setBackground(new Color(0, 0, 102));
		btnSupdate.setBounds(699, 105, 114, 23);
		panel_2.add(btnSupdate);
		
		JButton btnSsearch = new JButton("Search Dept");
		btnSsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				
			
				
				
					try {
						String input= getNonBlankInput("Enter Department ID");
						int cinput = Integer.parseInt(input);
						DatabaseConnect obj = new DatabaseConnect();
						conn = obj.getConnection();
				
						//String sql = "SELECT * FROM student WHERE dept_id=? ";
						String sql = "SELECT first_name,last_name,level,dept_id,matric_no,username,password FROM student WHERE dept_id=? ";
						stmt = conn.prepareStatement(sql);
						stmt.setInt(1, cinput);

						rs = stmt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
//						if(rs.next()) {
//						 	
//						}
//						else {
//							JOptionPane.showMessageDialog(null, "Invalid login details.", "", JOptionPane.ERROR_MESSAGE);	
//						}
							
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "Could not connect to database", "", JOptionPane.ERROR_MESSAGE);
					}
				
				
				
				
				
			}
		});
		btnSsearch.setForeground(new Color(255, 255, 255));
		btnSsearch.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSsearch.setBackground(new Color(0, 0, 102));
		btnSsearch.setBounds(699, 139, 114, 23);
		panel_2.add(btnSsearch);
		
		JButton btnSexit = new JButton("Exit");
		btnSexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage gh = new AdminPage(lg);
				setVisible(false);
				gh.setVisible(true);
			}
		});
		btnSexit.setForeground(new Color(255, 255, 255));
		btnSexit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSexit.setBackground(new Color(0, 0, 102));
		btnSexit.setBounds(699, 203, 114, 23);
		panel_2.add(btnSexit);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					DatabaseConnect obj = new DatabaseConnect();
					conn = obj.getConnection();
			
					String sql = "SELECT first_name,last_name,dept_id,username,password FROM student";
					stmt = conn.prepareStatement(sql);
					

					rs = stmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
//					if(rs.next()) {
//					 	
//					}
//					else {
//						JOptionPane.showMessageDialog(null, "Invalid login details.", "", JOptionPane.ERROR_MESSAGE);	
//					}
						
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Could not connect to database", "", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
				
			
		});
		btnView.setForeground(Color.WHITE);
		btnView.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnView.setBackground(new Color(0, 0, 102));
		btnView.setBounds(699, 169, 114, 23);
		panel_2.add(btnView);
	}
}
