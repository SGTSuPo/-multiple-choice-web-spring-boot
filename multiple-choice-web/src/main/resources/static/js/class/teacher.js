document
  .getElementById("add-chapter-btn")
  .addEventListener("click", function (event) {
    const addChapter = document.getElementById("add-chapter");
    addChapter.classList.toggle("open");
    event.stopPropagation();
  });
document.addEventListener("click", function (event) {
  const addChapter = this.getElementById("add-chapter");
  const isClickInside = addChapter.contains(event.target);
  if (!isClickInside) {
    addChapter.classList.remove("open");
  }
});
function closeAddChapterBtn() {
  var close = document.getElementById("add-chapter");
  close.classList.remove("open");
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
