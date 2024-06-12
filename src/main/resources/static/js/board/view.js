$(() => {
    findAll($("input[name=boardId]").val())
})

const commentSave = (boardId) => {
    const commentContent = $("textarea[name=content]").val();
    $.ajax({
        url: '/comment/save',
        type: 'post',
        data: {
            'boardId': boardId,
            'content': commentContent

        },
        success: function (data) {
            findAll($("input[name=boardId]").val())
        },
        error: function (err) {

        }
    });
    $(".saveForm").val("")
}

const findAll = (boardId) => {
    $.ajax({
        url: '/comment/list/' + boardId,
        type: 'get',
        success: function (data) {
            $(".commentListArea").html("");
            $.map(data, function (comment) {
                console.log(comment.commentId);

                // 각 댓글을 나타내는 HTML 구조
                let commentHtml = `
                    <div class="commentView" id="comment-${comment.commentId}">
                        <div class="commentViewList">
                            <p> 작성자 : ${comment.member.nickname}</p>
                            <p class="content">내용 : ${comment.content}</p>
                            <p>작성일 : ${comment.inputDt}</p>
                            <input type="hidden" name="commentId" value="${comment.commentId}">
                            <input type="hidden" name="content" value="${comment.content}">
                        </div>
                        <div class="commentBtnArea">
                            <div class="listBtn Btn" onclick="commentReFunc(${comment.commentId},this)" style="display: inline; padding: 5px 15px;">답글</div>
                            <div class="deleteBtn Btn commentDeleteFormBtn" onclick="deleteBtnFunc(this)" style="display: inline; padding: 5px 15px;">삭제</div>
                            <div class="updateBtn Btn commentUpdateFormBtn" onclick="updateBtnFunc(this)" style="display: inline; padding: 5px 15px;">수정</div>
                        </div>
                    </div>`;

                // 댓글 HTML을 commentListArea에 추가
                $('.commentListArea').append(commentHtml);

                // 대댓글을 불러오기 위한 AJAX 요청
                $.ajax({
                    url: '/commentRe/list/' + comment.commentId,
                    type: 'get',
                    success: function (data) {
                        console.log(data);
                        $.map(data, function (commentRe) {
                            console.log("====================", commentRe.commentReId);

                            // 대댓글을 나타내는 HTML 구조
                            let commentReHtml = `
                                <div class="commentView">
                                    <div class="commentViewList">
                                        <p>&nbsp;&nbsp;&nbsp; L작성자 : ${commentRe.member.nickname}</p>
                                        <p class="content">&nbsp;&nbsp;&nbsp; L내용 : ${commentRe.content}</p>
                                        <p>&nbsp;&nbsp;&nbsp; L작성일 : ${commentRe.inputDt}</p>
                                        <input type="hidden" name="commentReId" value="${commentRe.commentReId}">
                                        <input type="hidden" name="commentReContent" value="${commentRe.content}">
                                    </div>
                                    <div class="commentBtnArea">
                                        <div class="deleteBtn Btn commentDeleteFormBtn" onclick="commentReDeleteBtnFunc(this)" style="display: inline; padding: 5px 15px;">삭제</div>
                                        <div class="updateBtn Btn commentUpdateFormBtn" onclick="commentReUpdate(this)" style="display: inline; padding: 5px 15px;">수정</div>
                                    </div>
                                </div>`;

                            // 대댓글 HTML을 해당 댓글 바로 아래에 추가
                            $(`#comment-${comment.commentId}`).after(commentReHtml);
                        });
                    },
                    error: function (err) {
                        console.error(err);
                    }
                });
            });
        },
        error: function (err) {
            console.error(err);
        }
    });
}


const updateBtnFunc = (obj) => {
    const $commentView = $(obj).closest('.commentView');
    const objCancleSave = $commentView.html();
    const commentId = $commentView.find('input[name="commentId"]').val();
    const content = $commentView.find('input[name="content"]').val();

    $commentView.html(`
        <textarea name="content" style="width: 80%; height: 15vh" class="contentVal">${content}</textarea>
        <div style="display: flex; justify-content: right; align-items: center">
            <div class="deleteBtn Btn commentCancleBtn">취소</div>
            <div class="updateBtn Btn commentUpdateBtn">작성</div>
        </div>
    `);

    // 수정 버튼 클릭 이벤트 처리
    $commentView.find(".commentUpdateBtn").on("click", function () {
        $.ajax({
            url: '/comment/update/' + commentId,
            type: 'put',
            data: {
                'content': $commentView.find(".contentVal").val()
            },
            success: function (data) {
                $(".commentListArea").html("");
                findAll($("input[name=boardId]").val());
            },
            error: function (err) {
                console.error(err);
            }
        });
    });

    // 취소 버튼 클릭 이벤트 처리
    $commentView.find(".commentCancleBtn").on("click", function () {
        $commentView.html(objCancleSave);
    });
}

const deleteBtnFunc = (obj) => {
    const $commentView = $(obj).closest('.commentView');
    const commentId = $commentView.find('input[name="commentId"]').val();

    $.ajax({
        url: '/comment/delete/' + commentId,
        type: 'delete',
        success: function (data) {
            $(".commentListArea").html("");
            findAll($("input[name=boardId]").val());
        },
        error: function (err) {
            console.error(err);
        }
    });
}

const commentReFunc = (param,obj) => {
    let $commentView = $(obj).closest('.commentView');

    $commentView.after(`
      <div class="commentReArea">
        <div class="inputCommnet">
          <textarea name="content" class="saveForm commentReForm"></textarea>
          <div class="updateBtn Btn" onclick="commentReSave(` + param + `)">작성</div>
        </div>
      </div>
    `)
}

const commentReSave = (commentId) => {
    const commentContent = $(".commentReForm").val();
    console.log(commentId)
    $.ajax({
        url: '/commentRe/save',
        type: 'post',
        data: {
            'commentId': commentId,
            'content': commentContent
        },
        success: function (data) {
            findAll($("input[name=boardId]").val())
        },
        error: function (err) {
        }
    });
}

const commentReUpdate = (obj) => {
    const $commentView = $(obj).closest('.commentView');
    const objCancleSave = $commentView.html();
    const commentReId = $commentView.find('input[name="commentReId"]').val();
    const commentReContent = $commentView.find('input[name="commentReContent"]').val();

    $commentView.html(`
        <textarea name="content" style="width: 80%; height: 15vh" class="contentVal">${commentReContent}</textarea>
        <div style="display: flex; justify-content: right; align-items: center">
            <div class="deleteBtn Btn commentCancleBtn">취소</div>
            <div class="updateBtn Btn commentUpdateBtn">작성</div>
        </div>
    `);

    // 수정 버튼 클릭 이벤트 처리
    $commentView.find(".commentUpdateBtn").on("click", function () {

        console.log("===================",$commentView.find(".contentVal").val())
        $.ajax({
            url: '/commentRe/update/' + commentReId,
            type: 'put',
            data: {
                'content': $commentView.find(".contentVal").val()
            },
            success: function (data) {
                $(".commentListArea").html("");
                findAll($("input[name=boardId]").val());
            },
            error: function (err) {
                console.error(err);
            }
        });
    });

    // 취소 버튼 클릭 이벤트 처리
    $commentView.find(".commentCancleBtn").on("click", function () {
        $commentView.html(objCancleSave);
    });
}

const commentReDeleteBtnFunc = (obj) => {
    const $commentView = $(obj).closest('.commentView');
    const commentReId = $commentView.find('input[name="commentReId"]').val();

    $.ajax({
        url: '/commentRe/delete/' + commentReId,
        type: 'delete',
        success: function (data) {
            $(".commentListArea").html("");
            findAll($("input[name=boardId]").val());
        },
        error: function (err) {
            console.error(err);
        }
    });
}