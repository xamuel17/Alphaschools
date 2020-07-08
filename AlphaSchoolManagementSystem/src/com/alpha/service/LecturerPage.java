package com.alpha.service;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import com.alpha.model.LectLoginModel;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;

public class LecturerPage extends JFrame {

	private JPanel contentPane;
	JLabel lblclock;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @param llm 
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
	public LecturerPage(LectLoginModel llm) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 732, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 732, 548);
		
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 102));
		panel_1.setLayout(null);
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_1.setBounds(0, 5, 720, 522);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(null);
		panel_2.setBackground(new Color(0, 0, 102));
		panel_2.setBounds(0, 0, 172, 533);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JButton button = new JButton("Dashboard");
		button.setBounds(0, 150, 172, 33);
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Tahoma", Font.BOLD, 13));
		button.setBorder(new LineBorder(Color.BLACK, 1, true));
		button.setBackground(Color.WHITE);
		panel_2.add(button);
		
		JButton button_1 = new JButton("Messages");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Messages mg = new Messages(llm);
				setVisible(false);
				mg.setVisible(true);
			}
		});
		button_1.setBounds(0, 187, 172, 33);
		button_1.setForeground(new Color(0, 0, 0));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		button_1.setBackground(Color.WHITE);
		panel_2.add(button_1);
		
		JButton btnSetExamQuestions = new JButton("Set Exam Questions");
		btnSetExamQuestions.setBounds(0, 225, 172, 33);
		btnSetExamQuestions.setForeground(Color.BLACK);
		btnSetExamQuestions.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSetExamQuestions.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnSetExamQuestions.setBackground(Color.WHITE);
		panel_2.add(btnSetExamQuestions);
		
		JButton btnComputeResult = new JButton("Compute Result");
		btnComputeResult.setBounds(0, 264, 172, 33);
		btnComputeResult.setForeground(Color.BLACK);
		btnComputeResult.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnComputeResult.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnComputeResult.setBackground(Color.WHITE);
		panel_2.add(btnComputeResult);
		
		JButton btnLectureNote = new JButton("Lecture Note");
		btnLectureNote.setBounds(0, 303, 172, 33);
		btnLectureNote.setForeground(Color.BLACK);
		btnLectureNote.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLectureNote.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnLectureNote.setBackground(Color.WHITE);
		panel_2.add(btnLectureNote);
		
		JButton btnEditSyllabus = new JButton("Edit Syllabus");
		btnEditSyllabus.setBounds(0, 341, 172, 33);
		btnEditSyllabus.setForeground(Color.BLACK);
		btnEditSyllabus.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEditSyllabus.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnEditSyllabus.setBackground(Color.WHITE);
		panel_2.add(btnEditSyllabus);
		
		JButton button_6 = new JButton("View Attendance");
		button_6.setBounds(0, 380, 172, 33);
		button_6.setForeground(Color.BLACK);
		button_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_6.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		button_6.setBackground(Color.WHITE);
		panel_2.add(button_6);
		
		JButton button_7 = new JButton("Library");
		button_7.setBounds(0, 418, 172, 33);
		button_7.setForeground(Color.BLACK);
		button_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_7.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		button_7.setBackground(Color.WHITE);
		panel_2.add(button_7);
		
		JButton button_8 = new JButton("LogOut");
		button_8.setBounds(0, 456, 172, 33);
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogIn hg = new LogIn();
				setVisible(false);
				hg.setVisible(true);
				
			}
		});
		button_8.setForeground(Color.BLACK);
		button_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		button_8.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		button_8.setBackground(Color.WHITE);
		panel_2.add(button_8);
		
		JLabel lblNewLabel = new JLabel("Welcome "+llm.getLect_fName().toUpperCase());
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Garamond", Font.BOLD, 12));
		lblNewLabel.setBounds(26, 26, 136, 14);
		panel_2.add(lblNewLabel);
		
		 lblclock = new JLabel();
		 lblclock.setFont(new Font("Verdana", Font.BOLD, 7));
		clock();
		lblclock.setForeground(Color.WHITE);
		lblclock.setBounds(26, 106, 136, 33);
		panel_2.add(lblclock);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(164, -15, 556, 154);
		panel_1.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(10, 11, 530, 132);
		panel_3.add(panel_4);
		
		JLabel label = new JLabel("ALPHA ");
		label.setForeground(new Color(0, 0, 153));
		label.setFont(new Font("Segoe Marker", Font.BOLD, 99));
		label.setBounds(100, 11, 387, 124);
		panel_4.add(label);
		
		JLabel lblLecturer = new JLabel("Lecturer");
		lblLecturer.setForeground(Color.BLACK);
		lblLecturer.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLecturer.setBounds(368, 96, 81, 14);
		panel_4.add(lblLecturer);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.BLUE);
		panel_5.setBounds(0, 144, 556, 22);
		panel_3.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(174, 150, 546, 363);
		panel_1.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(null);
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(0, 0, 552, 84);
		panel_6.add(panel_7);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBorder(new LineBorder(Color.BLACK, 2, true));
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(10, 11, 233, 47);
		panel_7.add(panel_9);
		
		JLabel label_3 = new JLabel("Students: ");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		label_3.setBackground(Color.WHITE);
		label_3.setBounds(30, 22, 98, 14);
		panel_9.add(label_3);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBorder(new LineBorder(Color.BLACK, 2, true));
		panel_10.setBackground(Color.WHITE);
		panel_10.setBounds(295, 11, 233, 47);
		panel_7.add(panel_10);
		
		JLabel lblLecturer_1 = new JLabel("Lecturer:");
		lblLecturer_1.setForeground(Color.BLACK);
		lblLecturer_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblLecturer_1.setBackground(Color.WHITE);
		lblLecturer_1.setBounds(22, 23, 98, 14);
		panel_10.add(lblLecturer_1);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(0, 0, 102));
		panel_8.setBounds(0, 82, 552, 297);
		panel_6.add(panel_8);
		panel_8.setLayout(null);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(0, 0, 102));
		panel_12.setBounds(0, 0, 162, 33);
		panel_8.add(panel_12);
		panel_12.setLayout(null);
		
		JLabel lblNoticeboard = new JLabel("NOTICEBOARD:");
		lblNoticeboard.setForeground(Color.WHITE);
		lblNoticeboard.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNoticeboard.setBounds(10, 11, 142, 14);
		panel_12.add(lblNoticeboard);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.BLACK);
		panel_11.setBounds(164, 139, 556, 10);
		panel_1.add(panel_11);
	}
}
