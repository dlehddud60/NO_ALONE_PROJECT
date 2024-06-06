const meetAppli = (param) => {
  $(location).attr("href", "/meeting/application/" + param);
}

const meetAppliList = (param) => {
  $(location).attr("href", "/meeting/applicationList/" + param);
}

const acceptDelete = (param) => {
  $(location).attr("href", "/accept/delete/" + param);
}