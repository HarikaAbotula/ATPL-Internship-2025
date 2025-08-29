function calculate(op) {
  const num1 = parseFloat(document.getElementById("num1").value);
  const num2 = parseFloat(document.getElementById("num2").value);
  let result;

  if (isNaN(num1) || isNaN(num2)) {
    document.getElementById("result").innerHTML = "Please enter valid numbers!";
    return;
  }

  switch (op) {
    case '+':
      result = "Addition of "+num1+" and "+num2+" : "+(num1+num2);
      break;
    case '-':
      result = "Subtraction of "+num1+" and "+num2+" : "+(num1-num2);
      break;
    case '*':
      result = "Multiplication of "+num1+" and "+num2+" : "+(num1*num2);
      break;
    case '/':
      if (num2 === 0) {
        document.getElementById("result").innerHTML = " Division by zero not allowed!";
        return;
      }
      result = "Division of "+num1+" and "+num2+" : "+(num1/num2);
      break;
    default:
      result = "Invalid Operation";
  }

  document.getElementById("result").innerHTML =  result;
}



