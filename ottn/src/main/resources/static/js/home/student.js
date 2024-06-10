document
  .getElementById("join-class-btn")
  .addEventListener("click", function (event) {
    const joinClass = document.getElementById("join-class");
    joinClass.classList.toggle("open");
    event.stopPropagation();
  });
document.addEventListener("click", function (event) {
  const joinClass = this.getElementById("join-class");
  const isClickInside = joinClass.contains(event.target);
  if (!isClickInside) {
    joinClass.classList.remove("open");
  }
});
function closeJoinClassBtn() {
  var join = document.getElementById("join-class");
  join.classList.toggle("open");
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