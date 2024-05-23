$(function () {
   $(".updateBtn").on("click", function () {
      $("#frm").submit();
   });
});
function mbtiLink() {
   $(location).attr("href", "/mbti/mbtiCheckForm");

}
