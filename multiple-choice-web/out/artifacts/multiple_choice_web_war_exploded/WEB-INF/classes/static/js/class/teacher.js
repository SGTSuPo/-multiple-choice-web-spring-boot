//
async function fetchData() {
  try {
    const response = await fetch("http://127.0.0.1:5500/frontend/chapter.json");
    if (!response.ok) {
      throw new Error("Network response was not ok " + response.statusText);
    }
    const data = await response.json();
    const chapter = data.chapter;
    const classinfo = data.class;
    const sidebar = document.getElementById("sidebar");
    sidebar.insertAdjacentHTML('afterbegin',
      `<a href="teacherHome.html?id=${data.user.id}" class="btn bg-secondary">Home</a>`
    )
    const workspace = document.getElementById("workspace");
    workspace.insertAdjacentHTML(
      "afterbegin",
      `<div class="class-title w-100 bg-info">${classinfo.name}</div>`
    );
    chapter.forEach((item) => {
      //sidebar
      sidebar.insertAdjacentHTML(
        "beforeend",
        `<a href="makeChapter.html?id=${
          item.id
        }" class="btn btn-secondary">${item.name}</a>`
      );
      //chapter
      workspace.insertAdjacentHTML(
        "beforeend",
        `<div class="chapters d-flex flex-wrap ">
              <a href="makeChapter.html?id=${
                item.id
              }" class="chapter m-2 ml-5 ">
                <div class="text-light d-block p-1">
                    <h3 class="w-100" title="">${item.name}</h3>
                    <p>${item.description}</p>
                </div>
              </a>`
      );
    });
  } catch (error) {
    console.error("There has been a problem with your fetch operation:", error);
  }
}
fetchData();
// add
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
