$(function () {
   $(".updateBtn").on("click", function () {
      $("#frm").submit();
      alert("gd")
   });
});
function mbtiLink() {
   $(location).attr("href", "/mbti/mbtiCheckForm");

}
