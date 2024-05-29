$(function () {
   $(".updateBtn").on("click", function () {
      $("#frm").submit();
   });
});
function mbtiLink() {
   $(location).attr("href", "/mbti/mbtiCheckForm");
}
function emailFunc() {
   const email = $("input[name=email]").val();
   $(".email-info").css("color","blue").text("인증번호를 발송중입니다. 잠시만 기다려주시길 바랍니다.")
   $.ajax({
      url:'/api/email',
      type:'post',
      data:{'email':email}, //보낼 데이터
      success: function(data) {
         if(data) {
            $(".email-info").css("color","blue").text("인증번호가 발송되었습니다.")
            $(".emailConfirmArea").show();
         }else {
            $(".email-info").css("color","red").text("중복된 이메일 입니다.")
            $(".emailConfirmArea").hide();
         }
      },
      error: function(err) {

      }
   });

}
const emailConfirmFunc = () => {
   const email = $("input[name=email]").val();
   const code = $("input[name = emailCode]").val();

   $.ajax({
      url: '/api/email/confirm',
      type: 'post',
      contentType: 'application/json',
      dataType: 'json',
      data: JSON.stringify({
         email: email,
         code: code
      }), // 보낼 데이터
      success: function(data) {
         if(data) {
            $(".email-info").css("color", "blue").text("인증이 완료 되었습니다.");
            $(".updateBtn").show()
            $(".errorBtn").hide()
         }else {
            $(".email-info").css("color", "red").text("인증코드가 일치하지 않습니다.");
            $(".errorBtn").show()
            $(".updateBtn").hide()
         }
      },
      error: function(err) {
      }
   });
}
const emailCompleteFunc = () => {
   $(".emailComplete").text("이메일 인증을 완료해주시길 바랍니다.")
}