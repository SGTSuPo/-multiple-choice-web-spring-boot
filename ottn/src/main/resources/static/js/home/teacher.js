document.getElementById("create-class-btn").addEventListener("click", function (event) {
    const createClass = document.getElementById("create-class");
    createClass.classList.toggle("open");
    event.stopPropagation();
  });
document.addEventListener("click", function (event) {
  const createClass = this.getElementById("create-class");
  const isClickInside = createClass.contains(event.target);
  if (!isClickInside) {
    createClass.classList.remove("open");
  }
});
function closeCreateClassBtn() {
  var create = document.getElementById("create-class");
  create.classList.toggle("open");
}

var inputs = document.querySelectorAll('form input');
function checkEmptyFields() {
    var isEmpty = false;
    inputs.forEach(function(input) {
        if (input.value.trim() === '') {
            isEmpty = true;
        }
    });
    return isEmpty;
}
function sendNotification() {
    alert('Please to input full information!');
}
function sendForm() {
    document.querySelector('form').submit();
}
document.querySelector('form').addEventListener('submit', function(event) {
    event.preventDefault();
    if (checkEmptyFields()) {
        sendNotification();
    } else {
        sendForm();
    }
});