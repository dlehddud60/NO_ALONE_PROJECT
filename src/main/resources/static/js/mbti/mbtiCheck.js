$(()=> {
  var clickValue = 0;

  var E = 0;
  var I = 0;
  var N = 0;
  var S = 0;
  var T = 0;
  var F = 0;
  var P = 0;
  var J = 0;
  $(".e .value1").text("쉬는 시간이 생겼을 때 나는 집에 혼자 있는 걸 좋아한다.");
  $(".i .value2").text("쉬는 시간이 생겼을 때 나는 밖에 나가서 사람들과 어울리는 걸 좋아한다.");

  $(".e, .i").on("click", function() { // 일반 함수 사용
    var classResult = $(this).attr("class").substring(8,10).replace(" ","")
    console.log(classResult)
    switch (classResult) {
      case "e" : E++; break;
      case "i" : I++; break;
    }
    clickValue++;
    switch (clickValue) {


      case 1 : {
        $(".e .value1").text("오늘 본 영화를 궁금해하는 연인에게 나는 주인공이 좀비 바이러스가 퍼져서 치료하기 위한 영화야");
        $(".i .value2").text("오늘 본 영화를 궁금해하는 연인에게 나는 좀비랑 싸우는데 주인공이 완전 멋져 보는 내내 소름 돋았어");
      }
      break;
      case 2 : {
        $(".e .value1").text("연인에게 줄 선물을 고르게 된 나는 실용성은 없어도 예쁘고 기억에 남을 선물");
        $(".i .value2").text("연인에게 줄 선물을 고르게 된 나는 연인에게 요즘 가장 필요할 것 같은 선물");
      }
      break;
      case 3 : {
        $(".e , .i").hide();
        $(".n, .s").show();
        $(".n .value1").text("데이트 중 맛있어 보이는 밥집을 발견한 나는 간판에서 맛집의 기운이 느껴진다 맛집 각이야.");
        $(".s .value2").text("데이트 중 맛있어 보이는 밥집을 발견한 나는 유명하고 리뷰도 많으니까 맛은 보장되어 있겠군");
        clickValue = 0;

      }
    }

    console.log("=====E=======",E);
    console.log("=====I=======",I);
    console.log("====clickValue=====",clickValue);

  });

  $(".n, .s").on("click", function () {
    var classResult = $(this).attr("class").substring(8,10).replace(" ","")
    console.log(classResult)
    switch (classResult) {
      case "n" : N++; break;
      case "s" : S++; break;
    }
    clickValue++;
    switch (clickValue) {
      case 0 : {

      }
      case 1 : {
        $(".n .value1").text("엘리베이터를 탔을 때 엘리베이터는 이동수단일 뿐, 중간에 서지 않고 빨리만 올라갔으면 좋겠다.");
        $(".s .value2").text("엘리베이터를 탔을 때 사고가 나면 어떻게 탈출을 해야 하지?");
      }
        break;
      case 2 : {
        $(".n .value1").text("데이트가 없는 주말에 나는 침대랑 하루 종일 물아일체가 된다.");
        $(".s .value2").text("데이트가 없는 주말에 나는 단톡에 연락해서 친구들과 약속을 잡는다.");
      }
        break;
      case 3 : {
        $(".n , .s").hide();
        $(".t, .f").show();
        $(".t .value1").text("연인과 사소한 일로 다퉜을 때 나는 나!! 진짜!! 너무!!! 화났어!!!!!");
        $(".f .value2").text("연인과 사소한 일로 다퉜을 때 나는  ㅇㅇ점은 꼭 고쳐줬으면 좋겠어 이렇게 하면 되잖아");
        clickValue = 0;

      }
    }

    console.log("=====E=======",E);
    console.log("=====I=======",I);
    console.log("=====N=======",N);
    console.log("=====S=======",S);
  });

  $(".t, .f").on("click", function () {
    var classResult = $(this).attr("class").substring(8,10).replace(" ","")
    console.log(classResult)
    switch (classResult) {
      case "t" : T++; break;
      case "f" : F++; break;
    }
    clickValue++;
    switch (clickValue) {
      case 0 : {

      }
      case 1 : {
        $(".t .value1").text("축 처진 연인이 우울하다고 말했을 때 나는 왜 우울해? 뭐 때문에 우울한 거야?");
        $(".f .value2").text("축 처진 연인이 우울하다고 말했을 때 나는 5초 만에 감정이입 완료. 같이 글썽거린다.");
      }
        break;
      case 2 : {
        $(".t .value1").text("힘들게 이벤트를 준비한 나를 신나게 할 연인의 칭찬은? 사랑해 최고야 나 완전 감동했어");
        $(".f .value2").text("힘들게 이벤트를 준비한 나를 신나게 할 연인의 칭찬은? 고마워 요즘 바쁠 텐데 언제 이런 걸 생각했어?");
      }
        break;
      case 3 : {
        $(".t , .f").hide()
        $(".p, .j").show()
        $(".p .value1").text("데이트 룩을 고를 때 나는 전날부터 머리부터 발끝까지 세팅해 준다");
        $(".j .value2").text("데이트 룩을 고를 때 나는 나가기 직전 마음에 드는 옷을 입는다");
        clickValue = 0;

      }
    }

    console.log("=====E=======",E);
    console.log("=====I=======",I);
    console.log("=====N=======",N);
    console.log("=====S=======",S);
    console.log("=====T=======",T);
    console.log("=====F=======",F);

  });

  $(".p, .j").on("click", function () {
    var classResult = $(this).attr("class").substring(8,10).replace(" ","");
    console.log(classResult)
    switch (classResult) {
      case "p" : P++; break;
      case "j" : J++; break;
    }
    clickValue++;
    switch (clickValue) {
      case 0 : {

      }
      case 1 : {
        $(".p .value1").text("썸 중에 연인이 집에 놀러 온다고 했을 때 나는 보이는 곳만 일단 급하게 치워둔다.");
        $(".j .value2").text("썸 중에 연인이 집에 놀러 온다고 했을 때 나는 쓰레기 버리기부터 화장실 청소까지 한다.");
      }
        break;
      case 2 : {
        $(".p .value1").text("커플 해외여행 계획을 짜게 된 나는 할 거면 제대로! 일별로 세부 일정을 정리한다");
        $(".j .value2").text("커플 해외여행 계획을 짜게 된 나는 비행기 표만 끊어두고 계획의 80% 끝난다고 생각한다");
      }
        break;
      case 3 : {
        $(".p , .j").hide();
        $(".mbtiSave").show();
        clickValue = 0;

      }
    }

    console.log("=====E=======",E)
    console.log("=====I=======",I)
    console.log("=====N=======",N)
    console.log("=====S=======",S)
    console.log("=====T=======",T)
    console.log("=====F=======",F)
    console.log("=====P=======",P)
    console.log("=====J=======",J)
  });
  $(".mbtiSave").on("click", function() {
    $("#frm").append("<input type=\"text\" name=\"E\" value=\"" + E + "\">")
    .append("<input type=\"hidden\" name=\"I\" value=\"" + I + "\">")
    .append("<input type=\"hidden\" name=\"N\" value=\"" + N + "\">")
    .append("<input type=\"hidden\" name=\"S\" value=\"" + S + "\">")
    .append("<input type=\"hidden\" name=\"T\" value=\"" + T + "\">")
    .append("<input type=\"hidden\" name=\"F\" value=\"" + F + "\">")
    .append("<input type=\"hidden\" name=\"P\" value=\"" + P + "\">")
    .append("<input type=\"hidden\" name=\"J\" value=\"" + J + "\">").submit();
  });



});
