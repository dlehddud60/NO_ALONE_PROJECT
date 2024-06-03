const changeStatus = (acceptId,status) => {
  console.log("====acceptId====",acceptId)
  console.log("====status====",status)
  $.ajax({
    url:'/meeting/changeStatus',
    type:'post',
    data:{
      "acceptId" : acceptId,
      "status" : status
    }, //보낼 데이터
    success: function(data) {
    },
    error: function(err) {
    }
  });
}