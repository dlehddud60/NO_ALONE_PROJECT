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

        }, //보낼 데이터
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
                $('.commentListArea').append(
                    `<div class="commentView">
                        <div class="commentViewList">
                            <p> 작성자 : ${comment.member.nickname}</p>
                            <p class="content">내용 : ${comment.content}</p>
                            <p>작성일 : ${comment.inputDt}</p>
                            <input type="hidden" name="commentId" value="${comment.commentId}">
                            <input type="hidden" name="content" value="${comment.content}">
                        </div>
                        <div class="commentBtnArea">
                            <div class="deleteBtn Btn commentDeleteFormBtn" onclick="deleteBtnFunc(this)" style="display: inline; padding: 5px 15px;">삭제</div>
                            <div class="updateBtn Btn commentUpdateFormBtn" onclick="updateBtnFunc(this)" style="display: inline; padding: 5px 15px;">수정</div>
                        </div>
                    </div>`
                );
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
            type: 'post',
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
        type: 'get',
        success: function (data) {
            $(".commentListArea").html("");
            findAll($("input[name=boardId]").val());
        },
        error: function (err) {
            console.error(err);
        }
    });
}
