function generateTable() {
  let n = document.getElementById("num").value;
  let output = "";
  for (let i = 1; i <= 10; i++) {
    output += `${n} x ${i} = ${n * i}\n`;
  }
  document.getElementById("table").innerText = output;
}