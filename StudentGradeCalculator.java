import javax.swing.JOptionPane;

/**
 * A GUI-based student grade calculator that computes final course grades
 * based on projects, homework, exams, and attendance.
 * 
 * Grading weights: Projects/Homework 40%, Exams 50%, Attendance 10%
 */
public class StudentGradeCalculator {
	
	// Grade weight constants
	private static final double PROJECT_HOMEWORK_WEIGHT = 0.4;
	private static final double EXAM_WEIGHT = 0.5;
	private static final double ATTENDANCE_WEIGHT = 0.1;
	private static final double TOTAL_PROJECT_HOMEWORK_POINTS = 1150.0;
	private static final int MAX_ATTENDANCE = 28;
	
	public static void main(String[] args) {
		try {
			// Collect student information
			String firstName = getStringInput("Enter first name", "First Name");
			String lastName = getStringInput("Enter last name", "Last Name");
			
			// Collect project grades
			int[] projects = new int[7];
			int[] projectMaxPoints = {50, 100, 100, 200, 200, 200, 200};
			for (int i = 0; i < projects.length; i++) {
				projects[i] = getIntInput(
					"Enter a positive integer number <= " + projectMaxPoints[i],
					"Grade (Project " + (i + 1) + ")",
					0, projectMaxPoints[i]
				);
			}
			
			// Collect homework grades
			int[] homework = new int[2];
			for (int i = 0; i < homework.length; i++) {
				homework[i] = getIntInput(
					"Enter a positive integer number <= 50",
					"Grade (Homework " + (i + 1) + ")",
					0, 50
				);
			}
			
			// Collect exam grades
			int[] exams = new int[4];
			for (int i = 0; i < exams.length; i++) {
				exams[i] = getIntInput(
					"Enter a positive integer number <= 100",
					"Grade (Exam " + (i + 1) + ")",
					0, 100
				);
			}
			
			// Collect attendance
			int attendance = getIntInput(
				"Enter a positive integer number <= " + MAX_ATTENDANCE,
				"Grade (Attendance)",
				0, MAX_ATTENDANCE
			);
			
			// Calculate grades
			double projectHomeworkAvg = calculateProjectHomeworkAverage(projects, homework);
			double examAvg = calculateExamAverage(exams);
			double attendanceAvg = calculateAttendanceAverage(attendance);
			double finalGrade = calculateFinalGrade(projectHomeworkAvg, examAvg, attendanceAvg);
			
			// Display results
			displayResults(firstName, lastName, projects, homework, exams, attendance,
						   projectHomeworkAvg, examAvg, attendanceAvg, finalGrade);
						   
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,
				"Invalid input. Please enter valid numbers.",
				"Input Error",
				JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
				"An error occurred: " + e.getMessage(),
				"Error",
				JOptionPane.ERROR_MESSAGE);
		}
	}
		
	
	/**
	 * Prompts user for string input.
	 */
	private static String getStringInput(String message, String title) {
		String input = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
		if (input == null || input.trim().isEmpty()) {
			throw new IllegalArgumentException("Input cannot be empty");
		}
		return input.trim();
	}
	
	/**
	 * Prompts user for integer input with validation.
	 */
	private static int getIntInput(String message, String title, int min, int max) {
		while (true) {
			String input = JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
			if (input == null) {
				throw new IllegalArgumentException("Input cancelled");
			}
			
			try {
				int value = Integer.parseInt(input.trim());
				if (value >= min && value <= max) {
					return value;
				}
				JOptionPane.showMessageDialog(null,
					"Please enter a number between " + min + " and " + max,
					"Invalid Input",
					JOptionPane.WARNING_MESSAGE);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null,
					"Please enter a valid integer",
					"Invalid Input",
					JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	/**
	 * Calculates the project and homework average as a percentage.
	 */
	private static double calculateProjectHomeworkAverage(int[] projects, int[] homework) {
		int total = 0;
		for (int grade : projects) {
			total += grade;
		}
		for (int grade : homework) {
			total += grade;
		}
		double percentage = (total / TOTAL_PROJECT_HOMEWORK_POINTS) * 100;
		return Math.round(percentage * 10) / 10.0;
	}
	
	/**
	 * Calculates the exam average.
	 */
	private static double calculateExamAverage(int[] exams) {
		int total = 0;
		for (int grade : exams) {
			total += grade;
		}
		double average = total / (double) exams.length;
		return Math.round(average * 10) / 10.0;
	}
	
	/**
	 * Calculates the attendance average as a percentage.
	 */
	private static double calculateAttendanceAverage(int attendance) {
		double percentage = (attendance / (double) MAX_ATTENDANCE) * 100;
		return Math.round(percentage * 10) / 10.0;
	}
	
	/**
	 * Calculates the final weighted grade.
	 */
	private static double calculateFinalGrade(double projectHomeworkAvg, double examAvg, double attendanceAvg) {
		double grade = projectHomeworkAvg * PROJECT_HOMEWORK_WEIGHT +
					   examAvg * EXAM_WEIGHT +
					   attendanceAvg * ATTENDANCE_WEIGHT;
		return Math.round(grade * 10) / 10.0;
	}
	
	/**
	 * Displays the final grade report.
	 */
	private static void displayResults(String firstName, String lastName,
									   int[] projects, int[] homework, int[] exams, int attendance,
									   double projectHomeworkAvg, double examAvg,
									   double attendanceAvg, double finalGrade) {
		
		int[] projectMaxPoints = {50, 100, 100, 200, 200, 200, 200};
		StringBuilder report = new StringBuilder();
		
		report.append("       Student Grade Calculator\n");
		report.append("====================================\n");
		report.append("Student: ").append(firstName).append(" ").append(lastName).append("\n");
		report.append("====================================\n\n");
		
		report.append("PROJECT GRADES\n");
		report.append("------------------------------------\n");
		for (int i = 0; i < projects.length; i++) {
			report.append(String.format("  Project %d (%3d): %3d\n", i + 1, projectMaxPoints[i], projects[i]));
		}
		
		report.append("\nHOMEWORK GRADES\n");
		report.append("------------------------------------\n");
		for (int i = 0; i < homework.length; i++) {
			report.append(String.format("  Homework %d ( 50): %3d\n", i + 1, homework[i]));
		}
		
		report.append("\nEXAM GRADES\n");
		report.append("------------------------------------\n");
		for (int i = 0; i < exams.length; i++) {
			report.append(String.format("  Exam %d (100): %3d\n", i + 1, exams[i]));
		}
		
		report.append("\nATTENDANCE\n");
		report.append("------------------------------------\n");
		report.append(String.format("  Days Attended ( 28): %3d\n", attendance));
		
		report.append("\n====================================\n");
		report.append("CALCULATED AVERAGES\n");
		report.append("====================================\n");
		report.append(String.format("Projects & Homework: %6.1f%%\n", projectHomeworkAvg));
		report.append(String.format("Exams:               %6.1f%%\n", examAvg));
		report.append(String.format("Attendance:          %6.1f%%\n", attendanceAvg));
		report.append("------------------------------------\n");
		report.append(String.format("FINAL COURSE GRADE:  %6.1f%%\n", finalGrade));
		report.append("====================================\n");
		
		JOptionPane.showMessageDialog(null,
			report.toString(),
			"Grade Report - " + firstName + " " + lastName,
			JOptionPane.INFORMATION_MESSAGE);
	}
}
