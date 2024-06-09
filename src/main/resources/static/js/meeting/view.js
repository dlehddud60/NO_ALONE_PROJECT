const meetAppli = (param) => {
  $(location).attr("href", "/meeting/application/" + param);
}

const meetAppliList = (param) => {
  $(location).attr("href", "/meeting/applicationList/" + param);
}

const acceptDelete = (param) => {
  $(location).attr("href", "/accept/delete/" + param);
}
const meetingBoard = (param1,param2) => {
  console.log("=========param=====",param2)
  $(location).attr("href", "/board/list?categoryId=" + param1 + "&meetingId=" + param2);

}
