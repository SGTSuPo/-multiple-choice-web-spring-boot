document.getElementById("login").addEventListener("submit", function (event) {
  event.preventDefault();

//   const formData = new FormData(this);
//   const req = {};
//   formData.forEach((value, key) => {
//     req[key] = value;
//   });
//   console.log(req)

//   fetch(
//     "http://192.168.43.85:3000/auth/login",
//     {
//       method: "POST",
//       headers: {
//         "Content-Type": "application/json",
//       },
//       body: JSON.stringify(req),
//     }
//   )
//     .then((response) => {
//       if (response.status == "200") {
//         response.json().then((data) => {
//           sessionStorage.setItem("jwt", data.jwt)
//           console.log(data)
//           if (data.roleID == "1") {
//             alert("Student");
//             // window.location.href = "studentHome.html"
//           } else alert("Teacher");
//         });
//       } else alert("Can not send request");
//     })

//     .catch((error) => {
//       console.error("Lỗi khi gửi yêu cầu:", error);
//     });
fetch("http://192.168.43.85:3000/auth/login", {
  method: "POST",
  headers: {
    "Content-Type": "application/json",
  },
  credentials: "include",
  body: JSON.stringify({
    username: "tan",
    password: "123456",
  }),
})
  .then((response) => response.json())
  .then((result) => {
    console.log(result);
    // sessionStorage.setItem("jwt", result.jwt)
  })
  .catch((error) => console.error(error));
});
document.getElementById("test").addEventListener("click", () => {
   fetch("http://192.168.43.85:3000", {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
    credentials: "include",
  })
    .then((response) => response.json())
    .then((result) => {
      console.log(result);
      // sessionStorage.setItem("jwt", result.jwt)
    })
    .catch((error) => console.error(error));
});


