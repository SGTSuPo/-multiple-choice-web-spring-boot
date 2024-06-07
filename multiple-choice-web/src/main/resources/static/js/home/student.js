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