const boardSaveFrom = (param1,param2) => {
  $(location).attr("href", "/board/save?categoryId=" + param1 + "&meetingId=" + param2);
}