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
import com.alpha.model.LectLoginModel;
import com.alpha.model.LecturerDetails;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Messages extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmailS;
	private JTextField txtSubS;
	private JTextField txtemailR;
	private JTextField txtSubR;
	private JTextField textField;
	private JComboBox<String> cboInbox;
	 private String matno,subject,message;
	 
	 private JTextArea textAreaR;
private Connection con;
private String sEmail;
private PreparedStatement pstmt;
private Statement stmt;
private ResultSet rs;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Messages frame = new Messages();
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
	public Messages(LectLoginModel llm) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				//String em = llm.getEmail();
				
			}
		});
		setBackground(Color.WHITE);
		setTitle("Message");
		setBounds(100, 100, 766, 643);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlShadow);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 23, 524, 243);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblFrom = new JLabel("From:");
		lblFrom.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFrom.setBounds(10, 11, 46, 14);
		panel.add(lblFrom);
		
		txtEmailS = new JTextField();
		txtEmailS.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtEmailS.setEnabled(false);
		txtEmailS.setBorder(new LineBorder(Color.BLACK));
		txtEmailS.setBounds(44, 8, 204, 20);
		panel.add(txtEmailS);
		txtEmailS.setColumns(10);
		
		JTextArea textAreaS = new JTextArea();
		textAreaS.setBorder(new LineBorder(Color.BLACK));
		textAreaS.setBounds(10, 73, 504, 147);
		panel.add(textAreaS);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSubject.setBounds(10, 39, 46, 14);
		panel.add(lblSubject);
		
		txtSubS = new JTextField();
		txtSubS.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtSubS.setEnabled(false);
		txtSubS.setColumns(10);
		txtSubS.setBorder(new LineBorder(Color.BLACK));
		txtSubS.setBounds(54, 39, 440, 20);
		panel.add(txtSubS);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setForeground(SystemColor.activeCaptionText);
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMessage.setBounds(10, 0, 104, 25);
		contentPane.add(lblMessage);
		
		JLabel lblReply = new JLabel("Reply");
		lblReply.setForeground(SystemColor.text);
		lblReply.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblReply.setBounds(10, 320, 46, 14);
		contentPane.add(lblReply);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 341, 524, 266);
		contentPane.add(panel_1);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTo.setBounds(32, 11, 46, 14);
		panel_1.add(lblTo);
		
		txtemailR = new JTextField();
		txtemailR.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtemailR.setEnabled(false);
		txtemailR.setColumns(10);
		txtemailR.setBorder(new LineBorder(Color.BLACK));
		txtemailR.setBounds(55, 8, 204, 20);
		panel_1.add(txtemailR);
		
		textAreaR = new JTextArea();
		textAreaR.setBorder(new LineBorder(Color.BLACK));
		textAreaR.setBounds(10, 73, 504, 147);
		panel_1.add(textAreaR);
		
		JLabel label_1 = new JLabel("Subject");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(10, 39, 46, 14);
		panel_1.add(label_1);
		
		txtSubR = new JTextField();
		txtSubR.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtSubR.setEnabled(false);
		txtSubR.setColumns(10);
		txtSubR.setBorder(new LineBorder(Color.BLACK));
		txtSubR.setBounds(54, 39, 440, 20);
		panel_1.add(txtSubR);
		
		JButton btnRespond = new JButton("Respond");
		btnRespond.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			if (!textAreaR.getText().equals("")) {
				try {
					String res = textAreaR.getText();
					DatabaseConnect obj =  new DatabaseConnect();
		 			con = obj.getConnection();
		 			
		 			String sql =  "UPDATE feedback "
			                + "SET lecturer_response = '"+res+"' WHERE student_email ='"+sEmail+"'";
		 			pstmt= con.prepareStatement(sql);
		 			
		 			 pstmt.executeUpdate(sql);
		 			System.out.println(new DatabaseConnect().getConnection());
		 			//pstmt.setString(1, res);
		 			
		 			if(pstmt.executeUpdate(sql) > 0) {
		 				cboInbox.removeItemAt(1);
		 				textAreaR.setText("");
		 				 JOptionPane.showMessageDialog(null, "Message Successfully sent!"); 
		 			}else {
		 				
		 				JOptionPane.showMessageDialog(null, "Sending Failed!"); 
		 				
		 			}
					
					
				}catch(Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Could not connect to database","", JOptionPane.ERROR_MESSAGE);	
					
				}
			}	else {
				
				JOptionPane.showMessageDialog(null, "Empty field.", "Validate", JOptionPane.INFORMATION_MESSAGE);
			}
			}
		});
		btnRespond.setForeground(SystemColor.activeCaptionText);
		btnRespond.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRespond.setBackground(SystemColor.activeCaption);
		btnRespond.setBounds(401, 231, 91, 23);
		panel_1.add(btnRespond);
		
		textField = new JTextField(llm.getEmail());
		textField.setDisabledTextColor(new Color(255, 0, 0));
		textField.setEnabled(false);
		textField.setColumns(10);
		textField.setBorder(new LineBorder(Color.BLACK));
		textField.setBounds(543, 23, 144, 20);
		contentPane.add(textField);
		
		JLabel lblEnterEmailAddress = new JLabel("Email Address");
		lblEnterEmailAddress.setForeground(Color.WHITE);
		lblEnterEmailAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEnterEmailAddress.setBounds(543, 6, 144, 14);
		contentPane.add(lblEnterEmailAddress);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			btnSearch.setVisible(false);
			}
		});
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lectEmail = llm.getEmail();
				try {
		 			DatabaseConnect obj =  new DatabaseConnect();
		 			con = obj.getConnection();
		 			//String name =stlg.getStud_fName();
					
					
							
				
					 String sql ="SELECT * FROM feedback WHERE lecturer_email=?";
					 pstmt = con.prepareStatement(sql);
				
					 pstmt.setString(1,lectEmail);
					
					 rs= pstmt.executeQuery();
					 while(rs.next()) {
						 
						 matno = rs.getString("matno");
						  sEmail = rs.getString("student_email");
						 
						subject = rs.getString("subject");
						message= rs.getString("message");
						
					 cboInbox.addItem( sEmail.toString() );
					 
						
					 }
					
				}catch(Exception arg) {
					arg.printStackTrace();
					JOptionPane.showMessageDialog(null, "Unable to Connect to Database", "Error", JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		});
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSearch.setBackground(SystemColor.activeCaption);
		btnSearch.setBounds(544, 45, 91, 23);
		contentPane.add(btnSearch);
		
		cboInbox = new JComboBox();
		cboInbox.addItem("");
		cboInbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		cboInbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				if(arg0.getSource()==cboInbox) {
					//txtEmailS.setText(cboInbox.getSelectedItem());
					String tempE = cboInbox.getSelectedItem().toString();
					//String tempS=subject;
					//txtSubS.setText(subject);
					
					try {
			 			DatabaseConnect obj =  new DatabaseConnect();
			 			con = obj.getConnection();
			 			
						 String sql ="SELECT * FROM feedback WHERE student_email=?";
						 pstmt = con.prepareStatement(sql);
					
						 pstmt.setString(1,tempE);
						
						 rs= pstmt.executeQuery();
						 while(rs.next()) {
							 
							
							  sEmail = rs.getString("student_email");
							
							subject = rs.getString("subject");
							message= rs.getString("message");
							
							txtEmailS.setText(tempE);
							txtSubS.setText(subject);	
							textAreaS.setText(message);
							txtemailR.setText(tempE);
							txtSubR.setText(subject);
							textAreaR.setText("");
							
						 }
						
					}catch(Exception arg) {
						arg.printStackTrace();
						JOptionPane.showMessageDialog(null, "Unable to Connect to Database", "Error", JOptionPane.INFORMATION_MESSAGE);
						
					}
					
					   
				}
			}
		});
		cboInbox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
		});
		cboInbox.setBorder(new LineBorder(SystemColor.activeCaption));
		cboInbox.setBounds(544, 94, 206, 22);
		contentPane.add(cboInbox);
		
		JLabel lblInbox = new JLabel("Inbox");
		lblInbox.setForeground(Color.WHITE);
		lblInbox.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInbox.setBounds(554, 79, 133, 14);
		contentPane.add(lblInbox);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LecturerPage lp = new LecturerPage(llm);
				setVisible(false);
				lp.setVisible(true);
			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExit.setBackground(SystemColor.activeCaption);
		btnExit.setBounds(544, 169, 143, 23);
		contentPane.add(btnExit);
	}
}
