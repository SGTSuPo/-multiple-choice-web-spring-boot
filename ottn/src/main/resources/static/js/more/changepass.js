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