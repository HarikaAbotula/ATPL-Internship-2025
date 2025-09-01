function addTask() {
  const taskInput = document.getElementById("taskInput");
  const taskText = taskInput.value.trim();
  if (taskText === "") return;

  const li = document.createElement("li");
  li.textContent = taskText;

  const actions = document.createElement("div");
  actions.classList.add("actions");

  const doneBtn = document.createElement("button");
  doneBtn.textContent = "Done";
  doneBtn.onclick = () => li.classList.toggle("done");

  const deleteBtn = document.createElement("button");
  deleteBtn.textContent = "Delete";
  deleteBtn.classList.add("delete");
  deleteBtn.onclick = () => li.remove();

  actions.appendChild(doneBtn);
  actions.appendChild(deleteBtn);
  li.appendChild(actions);

  document.getElementById("taskList").appendChild(li);
  taskInput.value = "";
}