package com.alpha.service;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.alpha.database.DatabaseConnect;
import com.alpha.model.LoginModel;
import com.alpha.model.UserDetails;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.*;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTable;
import net.proteanit.sql.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ScrollPaneConstants;

public class ManageLectRecord extends JFrame {

	private JPanel contentPane;
	private JTextField txtLname;
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	private JTable table_1;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @return 
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
	
	public ManageLectRecord(LoginModel lg) {
		setResizable(false);
		
		setTitle("LECTURER RECORD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 445);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 102));
		panel.setBounds(0, 11, 832, 385);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 11, 832, 363);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLecturerName = new JLabel("LECTURER NAME :");
		lblLecturerName.setForeground(new Color(0, 0, 102));
		lblLecturerName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLecturerName.setBounds(22, 11, 109, 14);
		panel_1.add(lblLecturerName);
		
		txtLname = new JTextField();
		txtLname.setBounds(136, 9, 185, 20);
		panel_1.add(txtLname);
		txtLname.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(!txtLname.getText().equals("")) {
					try {
						DatabaseConnect obj = new DatabaseConnect();
						conn = obj.getConnection();
				
						String sql = "SELECT firstname,lastname,dept_id,username,password FROM lecturer WHERE firstname=? ";
						stmt = conn.prepareStatement(sql);
						stmt.setString(1, txtLname.getText());

						rs = stmt.executeQuery();
						table_1.setModel(DbUtils.resultSetToTableModel(rs));
//						if(rs.next()) {
//						 	
//						}
//						else {
//							JOptionPane.showMessageDialog(null, "Invalid login details.", "", JOptionPane.ERROR_MESSAGE);	
//						}
							
					}
					catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Could not connect to database", "", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "All fields are required.", "", JOptionPane.ERROR_MESSAGE);
				}
			
			}
		});
		btnSearch.setBackground(new Color(0, 0, 102));
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSearch.setBounds(336, 8, 89, 23);
		panel_1.add(btnSearch);
		
		JPanel panel_2 = new JPanel();
		
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 36, 700, 319);
		panel_2.setVisible(true);
		panel_1.add(panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(24, Short.MAX_VALUE))
		);
		
		table_1 = new JTable();
		table_1.setAutoscrolls(true);
		table_1.setPreferredScrollableViewportSize(new Dimension(500,100));
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table_1.setGridColor(Color.BLACK);
		table_1.setForeground(new Color(0, 0, 0));
		table_1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"", "", "", "", ""
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_1.getColumnModel().getColumn(0).setResizable(false);
		table_1.getColumnModel().getColumn(0).setPreferredWidth(86);
		table_1.getColumnModel().getColumn(0).setMinWidth(50);
		table_1.getColumnModel().getColumn(1).setResizable(false);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(90);
		table_1.getColumnModel().getColumn(1).setMinWidth(50);
		table_1.getColumnModel().getColumn(2).setResizable(false);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(47);
		table_1.getColumnModel().getColumn(2).setMinWidth(25);
		table_1.getColumnModel().getColumn(3).setResizable(false);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(3).setMinWidth(50);
		table_1.getColumnModel().getColumn(4).setResizable(false);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(90);
		table_1.getColumnModel().getColumn(4).setMinWidth(50);
		scrollPane.setViewportView(table_1);
		
		panel_2.setLayout(gl_panel_2);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					DatabaseConnect obj = new DatabaseConnect();
					conn = obj.getConnection();
			
					String sql = "SELECT firstname,lastname,dept_id,username,password FROM lecturer  ";
					stmt = conn.prepareStatement(sql);
					

					rs = stmt.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
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
		btnView.setBackground(new Color(0, 0, 102));
		btnView.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnView.setBounds(700, 94, 122, 23);
		panel_1.add(btnView);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			UpdateLectRecord upl = new UpdateLectRecord(lg);
			setVisible(true);
			upl.setVisible(true);
			}
		});
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setBackground(new Color(0, 0, 102));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdate.setBounds(700, 128, 122, 23);
		panel_1.add(btnUpdate);
		
		JButton btnLsearch = new JButton("Search Dept.");
		btnLsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
			
			
				try {
					String input= getNonBlankInput("Enter Department ID");
					int cinput = Integer.parseInt(input);
					
					DatabaseConnect obj = new DatabaseConnect();
					conn = obj.getConnection();
			
					String sql = "SELECT * FROM lecturer WHERE dept_id=? ";
					stmt = conn.prepareStatement(sql);
					stmt.setInt(1, cinput);

					rs = stmt.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
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
		btnLsearch.setForeground(Color.WHITE);
		btnLsearch.setBackground(new Color(0, 0, 102));
		btnLsearch.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLsearch.setBounds(700, 162, 122, 23);
		panel_1.add(btnLsearch);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminPage pg = new AdminPage(lg);
				setVisible(false);
				pg.setVisible(true);
			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExit.setBackground(new Color(0, 0, 102));
		btnExit.setBounds(700, 196, 122, 23);
		panel_1.add(btnExit);
	}
}
