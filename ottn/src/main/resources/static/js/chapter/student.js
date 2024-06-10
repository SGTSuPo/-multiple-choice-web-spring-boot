function answer(sel,ans)
{
return (sel===ans)? 1:0;
}
function showAnsBtn()
{
    const ans = document.querySelectorAll('.explain')
    const btn = document.getElementById("show-answer-btn")
    ans.forEach(answer =>{
        btn.innerText = 'Hide Answer';
        answer.classList.toggle('hide')
    })
}