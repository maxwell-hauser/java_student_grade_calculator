# Student Grade Calculator

A simple GUI-based Java program that collects student grades for projects, homework, exams, and attendance, then computes a weighted final course grade. The app uses Swing dialogs (`JOptionPane`) so it runs as a standalone desktop prompt without needing additional libraries.

## Features
- Intuitive GUI prompts for each grade component
- Input validation with helpful messages and retry flow
- Clear, aligned grade report with per-section breakdown
- Configurable weights and point totals via constants in code
- No external dependencies — compiles and runs with a standard JDK

## Grading Model
- Projects + Homework: 40% total
- Exams: 50% total
- Attendance: 10% total

Point assumptions (adjustable in code):
- Projects: `P1..P7` with max points `{50, 100, 100, 200, 200, 200, 200}`
- Homework: `HW1..HW2` with max points `{50, 50}`
- Attendance: max `28` meetings

Final grade is computed as a weighted combination of section percentages:

```
final = (Projects+Homework %)*0.40 + (Exams %)*0.50 + (Attendance %)*0.10
```

Key constants in `StudentGradeCalculator.java`:
- `PROJECT_HOMEWORK_WEIGHT = 0.4`
- `EXAM_WEIGHT = 0.5`
- `ATTENDANCE_WEIGHT = 0.1`
- `TOTAL_PROJECT_HOMEWORK_POINTS = 1150.0` (sum of all project + homework max points)
- `MAX_ATTENDANCE = 28`

To change the max points per project, edit the `projectMaxPoints` array in `displayResults(...)` and keep `TOTAL_PROJECT_HOMEWORK_POINTS` in sync.

## Requirements
- JDK 8 or later (Java 8+)
- Windows, macOS, or Linux

## Quick Start (Windows PowerShell)
```powershell
cd "g:\My Drive\GITHUB\java\student_grade_calculator_gh"

# Compile
javac StudentGradeCalculator.java

# Run
java StudentGradeCalculator
```

If you prefer a runnable JAR:
```powershell
# Create JAR with a main class
jar --create --file student-grade-calculator.jar --main-class StudentGradeCalculator StudentGradeCalculator.class

# Run the JAR
java -jar student-grade-calculator.jar
```

## Usage Flow
1. Enter first and last name.
2. Enter points earned for each of the 7 projects.
3. Enter points for 2 homework assignments.
4. Enter 4 exam scores.
5. Enter attendance (0–28).
6. Review the final, formatted grade report.

All numeric inputs are validated (range checks and integer parsing). Cancel or empty inputs are treated as errors.

## Example
Sample inputs (for illustration):
- Projects: `50, 95, 88, 180, 190, 175, 200`
- Homework: `45, 50`
- Exams: `92, 88, 91, 95`
- Attendance: `27`

Produces a report dialog with a per-section breakdown and a final percentage (rounded to 1 decimal place).

## Customization
- Adjust weights by editing `PROJECT_HOMEWORK_WEIGHT`, `EXAM_WEIGHT`, `ATTENDANCE_WEIGHT`.
- Change max points by updating `projectMaxPoints` and the `TOTAL_PROJECT_HOMEWORK_POINTS` constant.
- Modify dialog labels/titles by editing the strings passed to `getStringInput` and `getIntInput`.

## Troubleshooting
- VS Code "non-project file" warning: This is normal for single-file Java apps not using Maven/Gradle. It does not prevent compilation.
- `javac` not found: Ensure JDK is installed and added to `PATH`. Verify with `javac -version`.
- Paths with spaces: Always quote paths (e.g., `"g:\My Drive\..."`).

## Next Steps
- Add a CLI mode (accept grades via command-line arguments)
- Export results to CSV/JSON file
- Add unit tests for calculation methods
- Optional: Convert to a Maven project and package with `maven-assembly` or `shade`
