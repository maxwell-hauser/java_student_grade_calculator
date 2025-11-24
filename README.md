# Student Grade Calculator

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=flat&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.9+-C71A36?style=flat&logo=apache-maven)
![License](https://img.shields.io/badge/License-MIT-blue?style=flat)
![Status](https://img.shields.io/badge/Status-Active-success?style=flat)

A GUI-based Java application that collects student grades for projects, homework, exams, and attendance, then computes a weighted final course grade using Swing dialogs.

## ✨ Features

- **Intuitive GUI**: User-friendly Swing dialog prompts
- **Input Validation**: Comprehensive validation with helpful error messages
- **Detailed Reports**: Clear, aligned grade breakdown by section
- **Configurable Weights**: Easy-to-adjust grading criteria
- **No External Dependencies**: Runs with standard JDK
- **Professional Output**: Formatted grade report with section percentages

## 📊 Grading Model

### Weight Distribution
- **Projects + Homework**: 40%
- **Exams**: 50%
- **Attendance**: 10%

### Default Point Values
- **Projects (P1-P7)**: 50, 100, 100, 200, 200, 200, 200 points
- **Homework (HW1-HW2)**: 50, 50 points
- **Attendance**: Maximum 28 meetings
- **Total Projects + Homework**: 1,150 points

### Final Grade Formula

```
Final Grade = (Projects+Homework %) × 0.40 + (Exams %) × 0.50 + (Attendance %) × 0.10
```

### Configurable Constants

Easily modify grading criteria in `StudentGradeCalculator.java`:
- `PROJECT_HOMEWORK_WEIGHT = 0.4`
- `EXAM_WEIGHT = 0.5`
- `ATTENDANCE_WEIGHT = 0.1`
- `TOTAL_PROJECT_HOMEWORK_POINTS = 1150.0`
- `MAX_ATTENDANCE = 28`

## 📋 Requirements

- **JDK 21** (Temurin recommended)
- **Maven 3.9+**
- Cross-platform: Windows, macOS, Linux

## 🚀 Quick Start

### Using Maven (Recommended)

```powershell
# Build the project
mvn clean package

# Run the application
java -jar target/student-grade-calculator-1.0.1.jar
```

### Without Maven

```powershell
# Compile
javac StudentGradeCalculator.java

# Run
java StudentGradeCalculator
```

## 📖 Usage

1. Launch the application
2. Enter grades for each project (P1-P7)
3. Enter homework scores (HW1-HW2)
4. Input exam scores
5. Record attendance (number of meetings attended)
6. View comprehensive grade report with:
   - Individual section scores
   - Percentage breakdowns
   - Weighted final grade

## 🏗️ Building from Source

```powershell
# Clone the repository
git clone https://github.com/maxwell-hauser/java_student_grade_calculator.git
cd java_student_grade_calculator

# Build with Maven
mvn clean install

# Run tests
mvn test
```

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👤 Author

**Maxwell Hauser**

## 🤝 Contributing

Contributions, issues, and feature requests are welcome! Feel free to check the [issues page](https://github.com/maxwell-hauser/java_student_grade_calculator/issues).

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
