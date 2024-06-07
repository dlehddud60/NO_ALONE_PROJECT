const changeStatus = (acceptId,status) => {
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

const acceptDel = (param) => {
  $(location).attr("href", "/accept/delete/" + param);
}