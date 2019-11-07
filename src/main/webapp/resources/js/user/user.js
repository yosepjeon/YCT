/**
 * 
 */
$(document).ready(function() {
    $("#registerForm").on("submit",function() {
        console.log("#register 이벤트 등록완료");
        console.log($("#userId").val());

        console.log($("#isCheckId").val());
        if($("#isCheckId").val() === "unChecked") {
            console.log("unChecked");
            alert("중복확인해주세요.");
            event.preventDefault();
            $("#isCheckId").focus();
        }
        // $.ajax({
        //     url: "http://localhost:9000/agile/user/profileUpload",
        //     type:"post",
        //     data:formData,
        //     dataType:"text",
        //     processData:false,
        //     contentType:false,
        //     success: function() {
        //         console.log('success');
        //         $("#registerForm").submit();
        //     },
        //     error: function() {
        //         console.log("error");
        //     }
            
        // });
    });

    $("#checkSameId").on("click",function() {
        var formData;
        var userId = $("#userId").val();

        formData ={"userId":userId};
        if(userId === ""){
            alert("Id값을 입력하세요");
            $("#userId").focus();
            return;
        }

        $.ajax({
            url:"http://localhost:9000/agile/user/checkDupId?userId=" + userId,
            type:"GET",
            dataType:"text",
            processData:false,
            contentType:true,
            success: function(data) {
                if(data === "success") {
                    console.log(data);
                    $("#isCheckId").val("Checked");
                    alert("사용가능한 아이디입니다.");
                }else{
                    console.log(data);
                    alert("이미 사용중인 아이디입니다.");
                    $("#isCheckId").val("unChecked");
                    $("#userId").val("");
                }
            },
            error: function() {
                alert("error.");
            }
        });
    });
});
