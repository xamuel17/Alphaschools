package com.alpha.service;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Point;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import com.alpha.database.DatabaseConnect;
import com.alpha.model.StudLoginModel;

import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class StudentPage extends JFrame {
public JComboBox<String> cbo1;
	private JPanel contentPane;
	private JLabel lblWelcome;
	private JLabel lblclock;
	private JTextField txtSubject;
	private JTextField txtEmail;
	private JTextPane txtPmsg; 
	private String studDeptId,lecDeptEmail; 
	 private String studLevel;
	 private String studMatno ;
	 private  JPanel panReply;
	 private JPanel panFeedback ;
	 private 	JComboBox<String> cbo2;
	 private String  email,lecEmail;
	 private JTextArea txtMessage;
	/**
	 * Launch the application.
	 */
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement pstmt;
	private JTextField txtReply;
	private JTextField textField;
	public void clock() 
	{
		Thread clock = new Thread()
		{
			public void run() {
			
				try {
					while(true) {
					Calendar cal = new GregorianCalendar();
					 int day = cal.get(Calendar.DAY_OF_MONTH);
					 int month = cal.get(Calendar.MONTH);
					 int year = cal.get(Calendar.YEAR);
					 
					 int second =cal.get(Calendar.SECOND);
					 int minute = cal.get(Calendar.MINUTE);
					 int hour= cal.get(Calendar.HOUR);
				 lblclock.setText( "Time:"+hour+ ":" +minute+ ":" +second+"\n"+"    "+ "Date:"+day+"/" + month + "/" + year ) ;
				
			
				sleep(1000);
					}
				}catch(InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		};
		 clock.start();
		}


	/**
	 * Create the frame.
	 */
	public StudentPage(StudLoginModel stlg) {
		addWindowListener(new WindowAdapter() {
			@Override
			
			
			public void windowOpened(WindowEvent arg0) {
				try {
					DatabaseConnect obj =  new DatabaseConnect();
					con = obj.getConnection();
					 stmt = con.createStatement();
					 String sql ="SELECT * FROM lecturer";
					 
					 rs= stmt.executeQuery(sql);
					 
					 while(rs.next()) {
						 
						 String lecDeptId = rs.getString("dept_id");
						  lecDeptEmail=rs.getString("email");
						  
						 
					 cbo1.addItem(lecDeptEmail);	
					
					
					 //cbo2.addItem(lecDeptEmail);	
					 }
					
				}catch(Exception e) {
					e.printStackTrace();
					
				}
			}
		});
		setResizable(false);
		setTitle("Alpha Student");
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 172, 513);
		panel.setBorder(null);
		panel.setBackground(new Color(0, 0, 102));
		contentPane.add(panel);
		 panel.setLayout(null);
		
		

		 JLabel lblWelcome = new JLabel("Welcome "+ stlg.getStud_fName().toUpperCase());
		 lblWelcome.setBounds(10, 11, 162, 14);
		//lblWelcome.setText();
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(lblWelcome);
		
		JButton btnM = new JButton("FeedBack");
		btnM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panReply.setVisible(false);
				
				
			}
		});
		btnM.setBounds(0, 187, 172, 33);
		btnM.setForeground(Color.BLACK);
		btnM.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnM.setBorder(new LineBorder(Color.ORANGE, 1, true));
		btnM.setBackground(Color.WHITE);
		panel.add(btnM);
		
		JButton btnSyllabus = new JButton("Read Message");
		btnSyllabus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
			}
		});
		btnSyllabus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				panReply.setVisible(true);
				 

			
				
			}
		});
		btnSyllabus.setBounds(0, 225, 172, 33);
		btnSyllabus.setForeground(Color.BLACK);
		btnSyllabus.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSyllabus.setBorder(new LineBorder(Color.ORANGE, 1, true));
		btnSyllabus.setBackground(Color.WHITE);
		panel.add(btnSyllabus);
		
		JButton btnResult = new JButton("CGPA Calculator");
		btnResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				cgpaCalculator cg = new cgpaCalculator();
				cg.setVisible(true);
				
			}
		});
		btnResult.setBounds(0, 264, 172, 33);
		btnResult.setForeground(Color.BLACK);
		btnResult.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnResult.setBorder(new LineBorder(Color.ORANGE, 1, true));
		btnResult.setBackground(Color.WHITE);
		panel.add(btnResult);
		
		JButton btnResultChecker = new JButton("Result Checker");
		btnResultChecker.setBounds(0, 303, 172, 33);
		btnResultChecker.setForeground(Color.BLACK);
		btnResultChecker.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnResultChecker.setBorder(new LineBorder(Color.ORANGE, 1, true));
		btnResultChecker.setBackground(Color.WHITE);
		panel.add(btnResultChecker);
		
		JButton btnExam = new JButton("Exam");
		btnExam.setBounds(0, 341, 172, 33);
		btnExam.setForeground(Color.BLACK);
		btnExam.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExam.setBorder(new LineBorder(Color.ORANGE, 1, true));
		btnExam.setBackground(Color.WHITE);
		panel.add(btnExam);
		
		JButton btnExit = new JButton("LogOut");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				LogIn lg = new LogIn();
				
				lg.setVisible(true);
				 
				 setVisible(false);
				
			}

			
		});
		btnExit.setBounds(0, 380, 172, 33);
		btnExit.setForeground(Color.BLACK);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExit.setBorder(new LineBorder(Color.ORANGE, 1, true));
		btnExit.setBackground(Color.WHITE);
		panel.add(btnExit);
		
		 lblclock = new JLabel("");
		 lblclock.setFont(new Font("Verdana", Font.BOLD, 7));
		 lblclock.setForeground(Color.WHITE);
		clock();
		lblclock.setBounds(10, 115, 162, 24);
		panel.add(lblclock);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(164, -15, 566, 154);
		panel_1.setBackground(new Color(0, 0, 102));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 11, 566, 132);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblAlpha = new JLabel("ALPHA");
		lblAlpha.setForeground(new Color(0, 0, 153));
		lblAlpha.setFont(new Font("Segoe Marker", Font.BOLD, 99));
		lblAlpha.setBounds(97, 34, 414, 98);
		panel_2.add(lblAlpha);
		
		JLabel lblStudent = new JLabel("Student");
		lblStudent.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStudent.setForeground(new Color(255, 153, 51));
		lblStudent.setBounds(365, 104, 83, 14);
		panel_2.add(lblStudent);
		
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(new Color(0, 0, 0));
		panel_3.setBackground(new Color(0, 0, 102));
		panel_3.setBorder(new LineBorder(new Color(255, 153, 51), 1, true));
		panel_3.setBounds(174, 150, 556, 363);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 552, 72);
		panel_4.setBorder(null);
		panel_4.setBackground(Color.WHITE);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 102), 2, true));
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(10, 11, 532, 47);
		panel_4.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblStudents = new JLabel("Students: ");
		lblStudents.setForeground(Color.BLACK);
		lblStudents.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblStudents.setBackground(Color.BLUE);
		lblStudents.setBounds(30, 22, 98, 14);
		panel_6.add(lblStudents);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 0, 102));
		panel_5.setBounds(0, 70, 169, 28);
		panel_3.add(panel_5);
		panel_5.setLayout(null);
		 
	panReply = new JPanel();
	
	panReply.setBounds(10, 101, 523, 251);
	panel_3.add(panReply);
	panReply.setVisible(false);
	panReply.setBackground(SystemColor.textInactiveText);
	panReply.setLayout(null);
	
	JLabel lblFrom = new JLabel("FROM:");
	lblFrom.setForeground(SystemColor.text);
	lblFrom.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblFrom.setBounds(10, 11, 46, 14);
	panReply.add(lblFrom);
	
	JLabel lblRe = new JLabel("RE:");
	lblRe.setForeground(Color.WHITE);
	lblRe.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblRe.setBounds(10, 36, 46, 14);
	panReply.add(lblRe);
	
	txtReply = new JTextField();
	txtReply.setDisabledTextColor(Color.GRAY);
	txtReply.setColumns(10);
	txtReply.setBounds(48, 36, 423, 20);
	panReply.add(txtReply);
	
	txtMessage = new JTextArea();
	txtMessage.setBounds(48, 67, 423, 136);
	panReply.add(txtMessage);
	
	JButton btnClose = new JButton("Close");
	btnClose.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			panReply.setVisible(false);
		}
	});
	btnClose.setForeground(SystemColor.text);
	btnClose.setBackground(SystemColor.activeCaption);
	btnClose.setFont(new Font("Tahoma", Font.BOLD, 11));
	btnClose.setBounds(380, 214, 91, 23);
	panReply.add(btnClose);
	
	cbo2 = new JComboBox();
	cbo2.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			try {
				DatabaseConnect obj =  new DatabaseConnect();
				con = obj.getConnection();
				 stmt = con.createStatement();
				 String email = stlg.getEmail(); 
				 
				String sql ="SELECT * FROM feedback WHERE student_email= '"+email+"'";
				 
				 pstmt = con.prepareStatement(sql);
				 rs = pstmt.executeQuery();
				 
				 if(rs.next()) {				 
					   String lec = rs.getString("lecturer_email");
					   	String reply = rs.getString("subject");
					   	String response = rs.getString("lecturer_response");
				 
				 //cbo2.addItem(lec);	
				 txtReply.setText(reply);
				 txtMessage.setText(response);
				 }
				
			}catch(Exception e) {
				e.printStackTrace();
				
			}	
		}
	});
	
	
	cbo2.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent arg0) {
			if(arg0.getSource()==cbo2) {
				//txtEmailS.setText(cboInbox.getSelectedItem());
				lecEmail = cbo2.getSelectedItem().toString();
			
			
			try {
				DatabaseConnect obj =  new DatabaseConnect();
				con = obj.getConnection();
				 
				 String sql = "SELECT * FROM feedback WHERE student_email ='"+lecEmail+"' ";
				 pstmt = con.prepareStatement(sql);
				 
					System.out.println(new DatabaseConnect().getConnection());
				
				 
				rs= pstmt.executeQuery(sql);
				if(rs.next()) {
					
					String reply = rs.getString("subject");
					String message = rs.getString("message");
		
					
				
					txtReply.setText(reply);
					txtMessage.setText(message);
				}
				else {
					//JOptionPane.showMessageDialog(null, "Messages is Empty.", "", JOptionPane.ERROR_MESSAGE);	
					
					
				}
			}catch(Exception e) {
				e.printStackTrace();
				
				
				
			}
			}
		}
	});
	cbo2.setBounds(48, 7, 145, 22);
	panReply.add(cbo2);
	
	JButton btnNextMessage = new JButton("Next Message");
	btnNextMessage.setBounds(218, 214, 123, 23);
	panReply.add(btnNextMessage);
	
	textField = new JTextField();
	textField.setBounds(218, 8, 210, 20);
	panReply.add(textField);
	textField.setColumns(10);
		
		 panFeedback = new JPanel();
		 panFeedback.setBackground(Color.GRAY);
		panFeedback.setBounds(10, 103, 523, 249);
		panel_3.add(panFeedback);
		panFeedback.setLayout(null);
		
		JLabel lblSubject = new JLabel("Subject:");
		lblSubject.setForeground(new Color(0, 0, 102));
		lblSubject.setBackground(new Color(0, 0, 102));
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSubject.setBounds(10, 69, 72, 14);
		panFeedback.add(lblSubject);
		
		txtSubject = new JTextField();
		txtSubject.setBackground(new Color(255, 255, 204));
		txtSubject.setBounds(77, 67, 269, 20);
		panFeedback.add(txtSubject);
		txtSubject.setColumns(10);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setForeground(new Color(0, 0, 102));
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMessage.setBounds(10, 98, 72, 14);
		panFeedback.add(lblMessage);
		
		 txtPmsg = new JTextPane();
		 txtPmsg.setDisabledTextColor(Color.GRAY);
		 txtPmsg.setBorder(new LineBorder(SystemColor.activeCaption));
		txtPmsg.setBackground(SystemColor.activeCaptionText);
		txtPmsg.setBounds(77, 98, 269, 110);
		panFeedback.add(txtPmsg);
		
		JLabel lblStudentName = new JLabel("Email:");
		lblStudentName.setForeground(new Color(0, 0, 102));
		lblStudentName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStudentName.setBounds(24, 12, 45, 14);
		panFeedback.add(lblStudentName);
		
		JLabel lblTo = new JLabel("To:");
		lblTo.setForeground(new Color(0, 0, 102));
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTo.setBounds(50, 36, 102, 14);
		panFeedback.add(lblTo);
		
		JButton btnSend = new JButton("Send");
		btnSend.setForeground(Color.WHITE);
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSend.setBackground(SystemColor.activeCaption);
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!txtPmsg.getText().equals("")  && !txtSubject.getText().equals("")&& !txtEmail.getText().equals("") ) {
					
					String cbo = cbo1.getSelectedItem().toString();
					 email=txtEmail.getText();
					String subject=txtSubject.getText();		
					String message =txtPmsg.getText();
					int  id = Integer.parseInt(studDeptId);
					int level =Integer.parseInt(studLevel);
					String matno= studMatno;
					try {
						

						con = new DatabaseConnect().getConnection();
					String sql = "INSERT INTO feedback (dept_id,level,matno,student_email,lecturer_email,subject,message) VALUES('"+id+"','"+level+"','"+matno+"', '"+email+"','"+cbo+"','"+subject+"','"+message+"')";				
					
					 pstmt= con.prepareStatement(sql);
						//bind paramters
					
						
						if(pstmt.executeUpdate(sql)>0) {
							
							  JOptionPane.showMessageDialog(null, "Message Successfully sent!"); 
							  txtPmsg.setText("");
							  txtSubject.setText("");
							
						}else {
							  JOptionPane.showMessageDialog(null, "Error occurred. Recheck input."); 
							
						}
					}catch(Exception e) {
						e.printStackTrace();
						  JOptionPane.showMessageDialog(null, "Unable to connect to database.");
						
					}
				}else {
					
					
					JOptionPane.showMessageDialog(null, "Some fields are empty!", "Validation", JOptionPane.INFORMATION_MESSAGE);
					
				}
				
			}
		});
		btnSend.setBounds(371, 81, 117, 23);
		panFeedback.add(btnSend);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClear.setBackground(SystemColor.activeCaption);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  txtPmsg.setText("");
				  txtSubject.setText("");
				  cbo1.setSelectedItem(null);
				
			}
		});
		btnClear.setBounds(371, 111, 117, 23);
		panFeedback.add(btnClear);
		
		txtEmail = new JTextField(stlg.getEmail());
		txtEmail.setEnabled(false);
		txtEmail.setBounds(77, 9, 179, 20);
		panFeedback.add(txtEmail);
		txtEmail.setColumns(10);
		
		 cbo1 = new JComboBox();
		 cbo1.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent arg0) {
		 		
		 		
		 	}
		 	@Override
		 	public void mouseEntered(MouseEvent e) {
		 		
		 		try {
		 			DatabaseConnect obj =  new DatabaseConnect();
		 			con = obj.getConnection();
		 			String name =stlg.getStud_fName();
					
					
				
					 String sql ="SELECT * FROM student WHERE username =?";
					 pstmt = con.prepareStatement(sql);
					 
					 pstmt.setString(1,name );
					
					 rs= pstmt.executeQuery();
					 while(rs.next()) {
						 
						 studDeptId = rs.getString(5);
						 studLevel=rs.getString(4);
						 studMatno = rs.getString(7);
						 
					
					 }
					
				}catch(Exception arg) {
					arg.printStackTrace();
					
				}
		 		
		 		
		 	}
		 });
		cbo1.setBounds(77, 35, 179, 21);
		panFeedback.add(cbo1);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 153, 51));
		panel_8.setBorder(null);
		panel_8.setBounds(146, 120, 584, 29);
		contentPane.add(panel_8);
	}
}
