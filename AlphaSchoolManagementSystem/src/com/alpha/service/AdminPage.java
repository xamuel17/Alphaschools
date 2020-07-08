package com.alpha.service;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import com.alpha.model.LoginModel;

import java.awt.SystemColor;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPage extends JFrame {

	private JPanel contentPane;
	public JLabel lblClock;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AdminPage frame = new AdminPage();
//					frame.setVisible(true);
//					
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
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
				 lblClock.setText( "Time:"+hour+ ":" +minute+ ":" +second+"\n"+"    "+ "Date:"+day+"/" + month + "/" + year ) ;
				
			
				sleep(1000);
					}
				}catch(InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		};
		 clock.start();
		}

	
	
	public AdminPage(LoginModel lg) {
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 5, 720, 522);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 172, 513);
		panel_1.setLayout(null);
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(0, 0, 102));
		panel.add(panel_1);
		
		JButton button = new JButton("Dashboard");
		button.setForeground(new Color(153, 0, 0));
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.setBorder(new LineBorder(Color.WHITE, 1, true));
		button.setBackground(Color.WHITE);
		button.setBounds(0, 150, 172, 33);
		panel_1.add(button);
		
		JButton button_1 = new JButton("Messages");
		button_1.setForeground(new Color(153, 0, 0));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_1.setBorder(null);
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(0, 187, 172, 33);
		panel_1.add(button_1);
		
		JButton btnAddStudent = new JButton("Registration");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration rp = new Registration(lg);
				rp.comboFill();
				
				setVisible(false);
				rp.setVisible(true);
			}
		});
		btnAddStudent.setForeground(new Color(153, 0, 0));
		btnAddStudent.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAddStudent.setBorder(null);
		btnAddStudent.setBackground(Color.WHITE);
		btnAddStudent.setBounds(0, 225, 172, 33);
		panel_1.add(btnAddStudent);
		
		JButton btnAddTeacher = new JButton("Add Admin");
		btnAddTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegAdmin rg = new RegAdmin(lg);
				setVisible(false);
				rg.setVisible(true);
			}
		});
		btnAddTeacher.setForeground(new Color(153, 0, 0));
		btnAddTeacher.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAddTeacher.setBorder(null);
		btnAddTeacher.setBackground(Color.WHITE);
		btnAddTeacher.setBounds(0, 264, 172, 33);
		panel_1.add(btnAddTeacher);
		
		JButton btnDeptReg = new JButton("Dept Registration");
		btnDeptReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepartmentRegistration ar = new DepartmentRegistration(lg);
				setVisible(false);
				ar.setVisible(true);
			}
		});
		btnDeptReg.setForeground(new Color(153, 0, 0));
		btnDeptReg.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDeptReg.setBorder(null);
		btnDeptReg.setBackground(Color.WHITE);
		btnDeptReg.setBounds(0, 303, 172, 33);
		panel_1.add(btnDeptReg);
		
		JButton button_7 = new JButton("Library");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_7.setForeground(new Color(153, 0, 0));
		button_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_7.setBorder(null);
		button_7.setBackground(Color.WHITE);
		button_7.setBounds(0, 347, 172, 33);
		panel_1.add(button_7);
		
		JButton btnLogout = new JButton("LogOut");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogIn hn = new LogIn();
				setVisible(false);
				hn.setVisible(true);
			}
		});
		btnLogout.setForeground(new Color(153, 0, 0));
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogout.setBorder(null);
		btnLogout.setBackground(Color.WHITE);
		btnLogout.setBounds(0, 391, 172, 33);
		panel_1.add(btnLogout);
	
		
		lblClock = 
				new JLabel();
	
		clock();
	
		lblClock.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 7));
		lblClock.setForeground(Color.WHITE);
		lblClock.setBounds(10, 110, 139, 26);
		panel_1.add(lblClock);
		
		JLabel lblFullname = new JLabel("Welcome "+ lg.getfName().toUpperCase());
		lblFullname.setFont(new Font("Garamond", Font.BOLD, 13));
		lblFullname.setForeground(Color.WHITE);
		lblFullname.setBounds(10, 22, 139, 14);
		panel_1.add(lblFullname);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(164, -15, 550, 154);
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 11, 530, 132);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblAlpha = new JLabel("ALPHA ");
		lblAlpha.setForeground(new Color(0, 0, 153));
		lblAlpha.setFont(new Font("Segoe Marker", Font.BOLD, 99));
		lblAlpha.setBounds(100, 11, 387, 124);
		panel_3.add(lblAlpha);
		
		JLabel lblAdmin = new JLabel("ADMIN");
		lblAdmin.setForeground(Color.RED);
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAdmin.setBounds(368, 96, 81, 14);
		panel_3.add(lblAdmin);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(0, 0, 102));
		panel_10.setBounds(0, 144, 550, 22);
		panel_2.add(panel_10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(174, 150, 540, 363);
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(new Color(255, 0, 0)));
		panel_4.setBackground(Color.WHITE);
		panel.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new LineBorder(new Color(0, 0, 102), 2));
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBounds(0, 0, 552, 84);
		panel_4.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new LineBorder(Color.RED, 2, true));
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(10, 11, 146, 66);
		panel_5.add(panel_6);
		
		JLabel label_4 = new JLabel("Admin: ");
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		label_4.setBackground(Color.WHITE);
		label_4.setBounds(35, 22, 73, 14);
		panel_6.add(label_4);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(new LineBorder(Color.RED, 2, true));
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(193, 11, 146, 66);
		panel_5.add(panel_7);
		
		JLabel label_5 = new JLabel("Students: ");
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Times New Roman", Font.BOLD, 13));
		label_5.setBackground(Color.WHITE);
		label_5.setBounds(30, 22, 98, 14);
		panel_7.add(label_5);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new LineBorder(Color.RED, 2, true));
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(377, 11, 146, 66);
		panel_5.add(panel_8);
		
		JLabel label_6 = new JLabel("Teachers: ");
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Times New Roman", Font.BOLD, 13));
		label_6.setBackground(Color.WHITE);
		label_6.setBounds(22, 23, 98, 14);
		panel_8.add(label_6);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(0, 0, 102));
		panel_11.setBounds(0, 83, 552, 280);
		panel_4.add(panel_11);
		panel_11.setLayout(null);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(0, 0, 102));
		panel_12.setBounds(0, 0, 152, 37);
		panel_11.add(panel_12);
		panel_12.setLayout(null);
		
		JLabel lblNoticeboard = new JLabel("NOTICEBOARD");
		lblNoticeboard.setForeground(Color.WHITE);
		lblNoticeboard.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNoticeboard.setBounds(10, 11, 132, 14);
		panel_12.add(lblNoticeboard);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(null);
		panel_13.setBackground(new Color(0, 0, 102));
		panel_13.setBounds(0, 198, 552, 71);
		panel_11.add(panel_13);
		panel_13.setLayout(null);
		
		JButton btnManageLecturerRecord = new JButton("Manage Lecturer Record");
		btnManageLecturerRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageLectRecord mr = new ManageLectRecord(lg);
				setVisible(false);
				mr.setVisible(true);
				
			}
		});
		btnManageLecturerRecord.setBorder(new LineBorder(new Color(0, 0, 153)));
		btnManageLecturerRecord.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnManageLecturerRecord.setForeground(new Color(255, 255, 255));
		btnManageLecturerRecord.setBackground(new Color(0, 0, 153));
		btnManageLecturerRecord.setBounds(38, 34, 206, 29);
		panel_13.add(btnManageLecturerRecord);
		
		JButton btnManageStudentRecord = new JButton("Manage Student Record");
		btnManageStudentRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageStudRecord ms = new ManageStudRecord(lg);
				setVisible(false);
				ms.setVisible(true);
			}
		});
		btnManageStudentRecord.setForeground(new Color(255, 255, 255));
		btnManageStudentRecord.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnManageStudentRecord.setBorder(new LineBorder(new Color(0, 0, 153)));
		btnManageStudentRecord.setBackground(new Color(0, 0, 153));
		btnManageStudentRecord.setBounds(313, 34, 206, 29);
		panel_13.add(btnManageStudentRecord);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.RED);
		panel_9.setBounds(164, 139, 550, 10);
		panel.add(panel_9);
	}
}
