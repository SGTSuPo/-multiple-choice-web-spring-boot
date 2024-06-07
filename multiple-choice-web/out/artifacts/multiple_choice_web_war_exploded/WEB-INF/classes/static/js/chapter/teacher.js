async function fetchData() {
    try {
      const response = await fetch("http://127.0.0.1:5500/frontend/question.json");
      if (!response.ok) {
        throw new Error("Network response was not ok " + response.statusText);
      }
      const data = await response.json();
      const chapter = data.chapter;
      const questions = data.questions;
      // console.log(data);
      const sidebar = document.getElementById("sidebar");
      sidebar.insertAdjacentHTML('afterbegin',
      `<a href="teacherHome.html" class="btn bg-secondary">Home</a>`);
      sidebar.insertAdjacentHTML('afterbegin',
      `<a href="editClass.html" class="btn bg-secondary">Class</a>`);
      sidebar.insertAdjacentHTML('afterbegin',
      `<button id="add-question-btn-sidebar" class="btn btn-secondary" type="button" onclick="addQuestionBtn()">Add Question</button>`);
      //
      const workspace = document.getElementById("workspace");
      workspace.insertAdjacentHTML(
        "afterbegin",
        `<div class="chapter-title w-100">
            <h2>${chapter.name}</h2>
        </div>`
      );
      questions.forEach((item) => {
        //question
        workspace.insertAdjacentHTML(
          "beforeend",
          `<div class="question w-100 p-3 bg-secondary border-light border-bottom text-light text-left">
            <div class="detail-question">
              <p>[${item.type}] ${item.detail}</p>
            </div>
            <div class="selections">
              <div class="seletion">
                <input class="m-1" type="radio" name="${item.id}" value="${answer("A",item.ans)}">${item.A}
              </div>
              <div class="seletion">
                <input class="m-1" type="radio" name="${item.id}" value="${answer("B",item.ans)}">${item.B}
              </div>
              <div class="seletion">
                <input class="m-1" type="radio" name="${item.id}" value="${answer("C",item.ans)}">${item.C}
              </div>
              <div class="seletion">
                <input class="m-1" type="radio" name="${item.id}" value="${answer("D",item.ans)}">${item.D}
              </div>
            </div>
            <div class="text-left text-primary">
                <p>Answer: ${item.ans} | ${item.explain}</p>
            </div>
            
        </div>`
        );
      });
      workspace.insertAdjacentHTML("beforeend",
        `<div class="mt-2 ">
            <button id="add-question-btn" class="btn bg-primary text-light" type="button" onclick="addQuestionBtn()">Add Question</button>
        </div>`
      )
    } catch (error) {
      console.error("There has been a problem with your fetch operation:", error);
    }
  }
  fetchData();
  function answer(sel,ans)
  {
    return (sel===ans)? 1:0;
  }
  // add
function addQuestionBtn()
{
    const addChapter = document.getElementById('add-question');
    addChapter.classList.add('open');
}
function closeAddQuestionBtn()
{
    var add=document.getElementById('add-question');
    add.classList.remove('open'); 
}   

  