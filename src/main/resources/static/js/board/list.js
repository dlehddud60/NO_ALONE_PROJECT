const boardSaveFrom = (param) => {
  $(location).attr("href", "/board/save?categoryId=" + param);
}