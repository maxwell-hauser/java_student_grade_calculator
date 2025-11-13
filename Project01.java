import javax.swing.JOptionPane;

public class Project01 {
	
	public static void main(String[] args) 
	{
		String firstName;
		String lastName;
		String input;
		int p1, p2, p3, p4, p5, p6, p7, h1, h2, e1, e2, e3, e4, att;
		double ph_avg, e_avg, att_avg, grade_final;
		
		firstName = JOptionPane.showInputDialog(null, 
		"Enter first name", "First Name",
        JOptionPane.QUESTION_MESSAGE);
		
		lastName = JOptionPane.showInputDialog(null, 
		"Enter last name", "Last Name",
	    JOptionPane.QUESTION_MESSAGE);
		
		input = JOptionPane.showInputDialog(null, 
        "Enter a positive integer number <= 50", "Grade (Project 1)",
        JOptionPane.QUESTION_MESSAGE);p1 = Integer.parseInt(input);
		
		input = JOptionPane.showInputDialog(null,
		"Enter a positive integer number <= 100", "Grade (Project 2)",
		JOptionPane.QUESTION_MESSAGE); p2 = Integer.parseInt(input);
		  
		input = JOptionPane.showInputDialog(null,
		"Enter a positive integer number <= 100", "Grade (Project 3)",
		JOptionPane.QUESTION_MESSAGE); p3 = Integer.parseInt(input);
		  
		input = JOptionPane.showInputDialog(null,
		"Enter a positive integer number <= 200", "Grade (Project 4)",
		JOptionPane.QUESTION_MESSAGE); p4 = Integer.parseInt(input);
		  
		input = JOptionPane.showInputDialog(null,
		"Enter a positive integer number <= 200", "Grade (Project 5)",
		JOptionPane.QUESTION_MESSAGE); p5 = Integer.parseInt(input);
		  
		input = JOptionPane.showInputDialog(null,
		"Enter a positive integer number <= 200", "Grade (Project 6)",
	    JOptionPane.QUESTION_MESSAGE); p6 = Integer.parseInt(input);
		  
		input = JOptionPane.showInputDialog(null,
		"Enter a positive integer number <= 200", "Grade (Project 7)",
		JOptionPane.QUESTION_MESSAGE); p7 = Integer.parseInt(input);
		  
		input = JOptionPane.showInputDialog(null,
		"Enter a positive integer number <= 50", "Grade (Homework 1)",
		JOptionPane.QUESTION_MESSAGE); h1 = Integer.parseInt(input);
		  
		input = JOptionPane.showInputDialog(null,
		"Enter a positive integer number <= 50", "Grade (Homework 2)",
		JOptionPane.QUESTION_MESSAGE); h2 = Integer.parseInt(input);
		  
		input = JOptionPane.showInputDialog(null,
		"Enter a positive integer number <= 100", "Grade (Exam 1)",
		JOptionPane.QUESTION_MESSAGE); e1 = Integer.parseInt(input);
		  
		input = JOptionPane.showInputDialog(null,
		"Enter a positive integer number <= 100", "Grade (Exam 2)",
		JOptionPane.QUESTION_MESSAGE); e2 = Integer.parseInt(input);
		  
	    input = JOptionPane.showInputDialog(null,
		"Enter a positive integer number <= 100", "Grade (Exam 3)",
		JOptionPane.QUESTION_MESSAGE); e3 = Integer.parseInt(input);
		  
		input = JOptionPane.showInputDialog(null,
		"Enter a positive integer number <= 100", "Grade (Exam 4)",
		JOptionPane.QUESTION_MESSAGE); e4 = Integer.parseInt(input);
		  
		input = JOptionPane.showInputDialog(null,
		"Enter a positive integer number <= 28", "Grade (Attendance)",
		JOptionPane.QUESTION_MESSAGE); att = Integer.parseInt(input);
		
		ph_avg = (((p1 + p2 + p3 + p4 + p5 + p6 + p7 + h1 + h2)/1150.0)*100);
		ph_avg = Math.round(ph_avg * 10)/10.0;
		e_avg = (e1 + e2 + e3 + e4)/4.0;
		e_avg = Math.round(e_avg * 10)/10.0;
		att_avg = (att/28.0)*100;
		att_avg = Math.round(att_avg * 10)/10.0;
		grade_final = ph_avg*0.4 + e_avg*0.5 + att_avg*0.1;
		grade_final = Math.round(grade_final * 10)/10.0;
		
		JOptionPane.showMessageDialog(null,
				"            CSC 229 Project 1\n"
				+ "________________________________\n"
				+ "          First Name: " + firstName + "\n"
				+ "          Last Name: " + lastName + "\n"
				+ "________________________________\n"
				+ "               Project Grades\n"
				+ "________________________________\n"
				+ "                P1 (50): " + p1 + "\n"
				+ "                P2 (100): " + p2 + "\n"
				+ "                P3 (100): " + p3 + "\n"
				+ "                P4 (200): " + p4 + "\n"
				+ "                P5 (200): " + p5 + "\n"
				+ "                P6 (200): " + p6 + "\n"
				+ "                P7 (200): " + p7 + "\n"
				+ "________________________________\n"
				+ "              Homework Grades\n"
				+ "________________________________\n"
				+ "                 HW1 (50): " + h1 + "\n"
				+ "                 HW2 (50): " + h2 + "\n"
				+ "________________________________\n"
				+ "                Exam Grades\n"
				+ "________________________________\n"
				+ "                 E1 (100): " + e1 + "\n"
				+ "                 E2 (100): " + e2 + "\n"
				+ "                 E3 (100): " + e3 + "\n"
				+ "                 E4 (100): " + e4 + "\n"
				+ "________________________________\n"
				+ "            Attendance (28): " + att + "\n"
				+ "________________________________\n"
				+ " Project & Homework Grade: " + ph_avg + "\n"
				+ "            Exam Grade: " + e_avg + "\n"
				+ "       Attendance Grade: " + att_avg + "\n"
				+ "________________________________\n"
				+ "       Final course grade: " + grade_final + "\n",
				  "Project 1 - Hauser",
				  JOptionPane.INFORMATION_MESSAGE);	
	}
}
