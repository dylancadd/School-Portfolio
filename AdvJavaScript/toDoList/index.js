
// Loads all of the items in the database and creates an event listener
// for the two buttons on the screen
const init = () => {

  let clearBtn = document.querySelector("#clearInput");
  let addBtn = document.querySelector("#addInput");

  let input = document.querySelector("#input");

  input.addEventListener("keyup", function(event) {
    // Number 13 is the "Enter" key on the keyboard
    if (event.keyCode === 13) {
      // Cancel the default action, if needed
      event.preventDefault();
      // Trigger the button element with a click
      document.querySelector("#addInput").click();
    }
  });

  clearBtn.addEventListener('click', clearForm);
  addBtn.addEventListener('click', addItem);

  loadItems();
}

// Loads all of the items from the database
const loadItems = () => {
  xhrRequest("ToDo/allTasks.php", "get", "xml", data => {
    for (let i = 0; i < data.getElementsByTagName("task").length; i++) {
      let div = document.createElement("div");
      let output = document.querySelector(".output");
      let input = document.createElement("label");
      let trash = document.createElement("img");
      let inputText;

      div.setAttribute("item-id", data.getElementsByTagName("id")[i].childNodes[0].nodeValue);
      input.classList.add("item-desc");
      trash.src = "images/trash.png";
      trash.classList.add("imageSize");
      trash.addEventListener("click", deleteItem);
      div.classList.add("item");
      inputText = document.createTextNode( data.getElementsByTagName("description")[i].childNodes[0].nodeValue);

      input.appendChild(inputText);
      div.appendChild(trash);
      div.appendChild(input);
      output.appendChild(div);
    }
  });
}

// Clears the input field in the form
const clearForm = () => {
  let inputField = document.querySelector("#input");
  inputField.value = "";
  inputField.focus();
}

// Adds an item to the database
const addItem = () => {
  let input = document.querySelector("#input");

  if (input.value != "") {
    xhrRequest("ToDo/addTask.php", "get", "text", data => {
      let output = document.querySelector(".output");
      output.innerHTML = "";
      input.value = "";
      input.focus();
      loadItems();
    }, "description=" + input.value);
  } else {
    showErrorMessage();
  }
}

// Delets an item from the database
const deleteItem = function() {

  let trashCan = this;
  let itemToRemove = this.parentNode;
  let input = document.querySelector("#input");

  let itemId = itemToRemove.getAttribute("item-id");

  xhrRequest("ToDo/deleteTask.php", "post", "text", data => {
    let output = document.querySelector(".output");
    output.innerHTML = "";
    input.value = "";
    input.focus();
    loadItems();
  }, "id=" + itemId);
}

// Displays error message for 3 seconds
const showErrorMessage = () => {
    let snackbar = document.querySelector("#snackbar");
    snackbar.className = "show";
    setTimeout(function() {
      snackbar.className = snackbar.className.replace("show", "");
    }, 3000);
}

// Generic xhr request method
const xhrRequest = (url, verb, responseType, callback, parameters) => {
  let xhr = new XMLHttpRequest();

  if (verb == "get") {
    parameters = url += "?" + parameters;
  }

  xhr.open(verb, url);

  // Callback
  xhr.onreadystatechange = () => {
    if (xhr.readyState == 4) {
      if (responseType == "text") {
        callback(xhr.responseText);
      } else if (responseType == "json") {
        callback(JSON.parse(xhr.responseText));
      } else if (responseType == "xml") {
        if(xhr.responseXML) {
          callback(xhr.responseXML);
        } else {
          let parser = new DOMParser().parseFromString(xhr.responseText, "application/xml");
          callback(parser);
        }
      }
    }
  }

  if (verb == "post") {
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.send(parameters);
  } else {
    xhr.send(null);
  }
}

window.onload = init;
