function calculateGrade() {

    const subject1 = Number(document.getElementById("sub1").value);
    const subject2 = Number(document.getElementById("sub2").value);
    const subject3 = Number(document.getElementById("sub3").value);
    const subject4 = Number(document.getElementById("sub4").value);
    const subject5 = Number(document.getElementById("sub5").value);
    const subject6 = Number(document.getElementById("sub6").value);

    const output = document.getElementById("result");
    if (subject1=="" || subject2=="" || subject3==""|| subject4 =="" || subject5=="" || subject6=="") {
        output.textContent = " Please enter marks for all subjects";
        return;
    }

    const totalMarks = subject1 + subject2 + subject3 + subject4 + subject5 + subject6;
    const percentage = (totalMarks / 600) * 100;

    let grade = "";
    let color = "green";
    let status = "Pass ";
   
    if (subject1 < 35 || subject2 < 35 || subject3 < 35 || subject4 < 35 || subject5 < 35 || subject6 < 35) {
        status = "Fail  (Below 35 in one or more subjects)";
        grade = "F";
        color = "red";
    } else {
        if (percentage > 90 && percentage <= 100) {
            grade = "A";
        } else if (percentage >= 75 && percentage <= 89) {
            grade = "B";
        } else if (percentage >= 60 && percentage <= 74) {
            grade = "C";
        } else if (percentage >= 40 && percentage <= 59) {
            grade = "D";
        } else {
            grade = "F";
            status = "Fail ";
            color = "red";
        }
    }

    output.textContent =
        `Total Marks: ${totalMarks} / 600 
        | Percentage: ${percentage.toFixed(2)}% 
        | Grade: ${grade} 
        | Result: ${status}`;
    output.style.color = color;
}