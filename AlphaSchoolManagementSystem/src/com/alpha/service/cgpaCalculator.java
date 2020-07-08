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
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.TextEvent;
import java.awt.print.PrinterException;
import java.lang.reflect.Array;

import javax.swing.JScrollBar;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class cgpaCalculator extends JFrame {
	private JTextField textField_Name;
	private JTextField textField_Reg,JTextField_Reg;
	//private String level;
	private JComboBox comboBox_Dept,comboBox_Reg,comboBox_Sem;
	private 	JLabel lblNewLabel;
	public JLabel lblClock ;
	private String name,grade,regNo,sem;
	private String courseReg,msg2,bLevel;
	private JButton btnGo;
	private String cRegVal ;
	private 	JTextArea textArea;
	private int cop,reg,  convUnit;
	private double gpa,sumUnits;
	/**
	 * Launch the application.
	 */
	 String dept[] = {"Select Item", "Computer Science", "Botany", "Physics", "Mathematics", "Food Science", "Nutrition and dietetics"};
	String level[]= {"Select Item","100L", "200L", "300L", "400L","500L","600L"};
	String semester[] = {"1st Semester", "2nd Semester"};
	private String JTextField ;
	private JTextField textField_cReg;
	

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
	 
	 
	 
	 //>>>>>>>>>>>>>>>>>>>Not working Block of code<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
//	   String getNonAlphabet(String aPrompt) {
//		   
//		   while (grade.equals("")|| !grade.matches("[a-zA-Z]+")) {
//			      JOptionPane.showMessageDialog(null, "Cannot accept blank entries!");
//			      grade = JOptionPane.showInputDialog(aPrompt);
//		   }
//		   return grade;   
//	   }
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	 
	 
	 
	 
	 
	public cgpaCalculator() {
		setResizable(false);
		getContentPane().setBackground(new Color(255, 255, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 552);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 724, 57);
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 102), 2, true));
		panel.setFont(new Font("Segoe Marker", Font.PLAIN, 68));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCgpaCalculator = new JLabel("ALPHA GPA Calculator");
		lblCgpaCalculator.setForeground(new Color(0, 0, 102));
		lblCgpaCalculator.setFont(new Font("Segoe Marker", Font.BOLD, 33));
		lblCgpaCalculator.setBounds(172, 0, 386, 57);
		panel.add(lblCgpaCalculator);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 102, 691, 121);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 102), new Color(255, 255, 255), new Color(0, 0, 102), Color.WHITE));
		panel_1.setBackground(Color.WHITE);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 102), 2, true));
		panel_2.setBounds(10, 11, 671, 99);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblName.setBounds(10, 11, 46, 14);
		panel_2.add(lblName);
		
		textField_Name = new JTextField();
		name = textField_Name.getText();
		textField_Name.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				
				// textAreaResult.setText("Name:" +name + "\n");
			}
		});
		textField_Name.setBounds(53, 8, 185, 20);
		panel_2.add(textField_Name);
		textField_Name.setColumns(10);
		
		JLabel lblDepartement = new JLabel("Department:");
		lblDepartement.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblDepartement.setBounds(307, 11, 75, 14);
		panel_2.add(lblDepartement);
		
	
		 comboBox_Dept = new JComboBox(dept);
		
		
		comboBox_Dept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==comboBox_Dept) {
					JComboBox bc2= (JComboBox)arg0.getSource();
					 msg2 =(String)bc2.getSelectedItem();
				}

		
									
			
			}
		});
		
		comboBox_Dept.setBounds(380, 8, 115, 20);
		panel_2.add(comboBox_Dept);
	
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblLevel.setBounds(530, 11, 46, 14);
		panel_2.add(lblLevel);
		
		JComboBox comboBox_Level = new JComboBox(level);
		comboBox_Level.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==comboBox_Level) {
					JComboBox bclevel= (JComboBox)e.getSource();
					 bLevel =(String)bclevel.getSelectedItem();
			}
			}
		});
		comboBox_Level.setBounds(571, 8, 90, 20);
		panel_2.add(comboBox_Level);
		
		JLabel lblRegNo = new JLabel("Reg No:");
		lblRegNo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblRegNo.setBounds(10, 51, 46, 14);
		panel_2.add(lblRegNo);
		
		textField_Reg = new JTextField();
		regNo = textField_Reg.getText();
		textField_Reg.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
		
			}
		});
		textField_Reg.setBounds(53, 48, 185, 20);
		panel_2.add(textField_Reg);
		textField_Reg.setColumns(10);
		
		JLabel lblDept = new JLabel("");
		lblDept.setBounds(501, 51, 46, 14);
		panel_2.add(lblDept);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSemester.setBounds(515, 51, 58, 14);
		panel_2.add(lblSemester);
		
		 comboBox_Sem = new JComboBox(semester);
		comboBox_Sem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==comboBox_Dept) {
					JComboBox bcsem= (JComboBox)e.getSource();
					 sem =(String)bcsem.getSelectedItem();
					 
				}
			
	
			}
		});
		comboBox_Sem.setBounds(571, 48, 90, 20);
		panel_2.add(comboBox_Sem);
		
		 lblNewLabel = new JLabel("");
		 lblNewLabel.setBounds(324, 76, 172, 14);
		 panel_2.add(lblNewLabel);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 102), 2));
		panel_4.setBounds(20, 234, 681, 250);
		getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 153));
		panel_5.setBounds(45, 32, 589, 207);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		textField_cReg = new JTextField();
		textField_cReg.setBounds(127, 11, 24, 20);
		panel_5.add(textField_cReg);
		textField_cReg.setColumns(10);
		
		 btnGo = new JButton("go!");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					//Gets value of courses registered
					cRegVal = textField_cReg.getText();
					 reg = Integer.parseInt(cRegVal);
					
					//>>>>>>>>>>>>>>>>>>>>Array created  for course code
					 ArrayList <String> codeArray = new ArrayList<String>(reg);
								//	int k = 0;
					  
					  //>>>>>>>>>>>>>>>>>>>>>>>>>>>Array created for course grade		
					  ArrayList <String> cGrade = new ArrayList<String>(reg);
				
					  
					  //>>>>>>>>>>>>>>>>>>>>>>>>Array created for course Units
					  ArrayList <Integer> cUnit = new ArrayList<Integer>(reg);
					  
						 for (int val= 0; val<reg;val++) {

							 //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Accept course Code<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 
							String input= getNonBlankInput("Enter Course code:" );	
							
							codeArray.add(input);
							//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
							
							

						 //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Accept course Grade<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
						  grade= getNonBlankInput("Enter Grade for "+ input +":" );
						  grade = grade.toUpperCase();
							 cGrade.add(grade);
						//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
							 
							 
							 
							 

						  
						
					//>>>>>>>>>>>>>>>>>>>>>>>Accept Credit Units input value<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<	 
						 String unit = getNonBlankInput("Enter "+input+" Credit Load: " );
						 int convUnit = Integer.parseInt(unit);
						 cUnit.add(convUnit);
					//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
					 
					 }
						 
						 for(int i = 0; i < codeArray.size(); i++) {  
							 
							
							 int sumGrade= 0;
						
							 switch(grade) {
							 case "A":	 sumGrade = 5 * cUnit.get(i);
						 break;
							 case "B": sumGrade= 4*cUnit.get(i);
							 break;
							 case "C": sumGrade = 3*cUnit.get(i);
							 break;
							 case "D" : sumGrade = 2*cUnit.get(i);
							 break;
							 case "E" : sumGrade = 1*cUnit.get(i);
							 break;
							 default: sumGrade = 0*cUnit.get(i);
							 
							}
							 sumUnits = sumUnits + cUnit.get(i);
							  
							   cop = cop + sumGrade;
							   gpa = cop/sumUnits;
							    textArea.append(codeArray.get(i) +"             "+ cGrade.get(i)+"                 " + cUnit.get(i) +"                  " + sumGrade +"\n" );
							
							  
							    // ArrayList <Integer> gp = new ArrayList<Integer>(sumGrade);
							  
						 }
						 name =  textField_Name.getText();
						 regNo = textField_Reg.getText();
						 
						 
						 //For the comboBoxes
						 
						//>>>>>>>>>>>>>	msg2,bLevel,sem,  
						
						
						 textArea.append("\n" + "Total: "+ cop +"\n"+ "GPA: "+ gpa +"\n"+ "NAME: "+ name+"\n"+ "Reg No: "+ regNo +"\n"+"DEPT: "+msg2 +"\n"+"Level : " +bLevel +"\n"+"Semester:"+sem );
					 
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null,"Invalid input, try again");
					textArea.setText("");
					cop = 0;
					gpa = 0.0;
					grade ="";
					cRegVal = "";
					textField_cReg.setText("");
					msg2=null;
					sem=null;
					bLevel= null;
					textField_Name.setText("");
					textField_Reg.setText("");
				}
		
			}
		});
		btnGo.setBounds(161, 10, 54, 23);
		panel_5.add(btnGo);
		
		 textArea = new JTextArea();
		textArea.setBounds(36, 59, 260, 125);
		panel_5.add(textArea);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCourse.setBounds(37, 44, 46, 14);
		panel_5.add(lblCourse);
		
		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGrade.setBounds(103, 44, 46, 14);
		panel_5.add(lblGrade);
		
		JLabel lblCoursesRegistered_1 = new JLabel("Courses Registered");
		lblCoursesRegistered_1.setBounds(10, 14, 121, 14);
		panel_5.add(lblCoursesRegistered_1);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(new Color(0, 0, 102));
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
				cop = 0;
				gpa = 0.0;
				grade ="";
				cRegVal = "";
				textField_cReg.setText("");
				msg2=null;
				sem=null;
				bLevel= null;
				textField_Name.setText("");
				textField_Reg.setText("");
				
				
			}
		});
		btnClear.setBounds(326, 60, 89, 35);
		panel_5.add(btnClear);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try{
					Boolean ppt = textArea.print();
				if(ppt) {
					JOptionPane.showMessageDialog(null,  "Done", "information", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "OOPs! Printing Failed","Printer",JOptionPane.ERROR_MESSAGE);
				}
				}catch(PrinterException ex) {
					
				//Logger.getLogger(TextEvent.class.getName()).log(Level.SEVERE,null,ex);	
				JOptionPane.showMessageDialog(null, ex);
				}
				
				
			
			}
		});
		btnPrint.setBackground(new Color(204, 204, 255));
		btnPrint.setBounds(326, 106, 89, 45);
		panel_5.add(btnPrint);
		
		JLabel lblUnit = new JLabel("Unit");
		lblUnit.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUnit.setBounds(171, 44, 46, 14);
		panel_5.add(lblUnit);
		
		JLabel lblGpa = new JLabel("Point");
		lblGpa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGpa.setBounds(235, 44, 46, 14);
		panel_5.add(lblGpa);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				setVisible(false);
				
				StudentPage sp = new StudentPage(null);
				sp.setVisible(true);
				} catch(Exception ex) {
					
					
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(255, 0, 51));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(469, 60, 89, 91);
		panel_5.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 172, 203, -139);
		panel_4.add(scrollPane);
	}
}
