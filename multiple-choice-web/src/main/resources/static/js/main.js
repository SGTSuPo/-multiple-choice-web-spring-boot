//

// Sidebar button
document.addEventListener("DOMContentLoaded", function () {
  const toggleSidebarButton = document.getElementById("toggle");
  const sidebar = document.getElementById("sidebar");

  toggleSidebarButton.addEventListener("click", function () {
    sidebar.classList.toggle("active");
  });

  document.addEventListener("click", function (event) {
    const isClickInside =
      sidebar.contains(event.target) ||
      toggleSidebarButton.contains(event.target);
    if (!isClickInside) {
      sidebar.classList.remove("active");
    }
  });
});
// Dropdown button
document
  .getElementById("dropdown-btn")
  .addEventListener("click", function (event) {
    event.stopPropagation();
    var object = document.getElementById("dropdown-account");
    object.classList.toggle("open");
  });
document.addEventListener("click", function () {
  var object = document.getElementById("dropdown-account");
  if (object.classList.contains("open")) {
    object.classList.toggle("open");
  }
});

