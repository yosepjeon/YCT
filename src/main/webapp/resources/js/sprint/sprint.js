$(window).on('load',function() {
    var sprintCount = parseInt(document.getElementById('sprintListSize').value);

    var element = document.getElementById('go_to_projectView');
    var projectId = document.getElementById('projectId').value;
    element.addEventListener('click', function() {
        if(this.value==='') {
            alert('시작중인 스프린트가 없습니다.');
            return;
        }
        window.location.href = window.location.origin + '/agile/project/viewStartSprint/' + projectId + "/" + this.value;
    });

    // var sprintButtonAddRow = document.getElementById('sprint-btn-addrow');
    var sprintButtonAddRow = $('#sprint-btn-addrow');
    var sprintButtonCreateRow = $('#sprint-create-btn');
    var sprintAddRow = $('#sprint-foo-addrow');
    sprintAddRow.footable();
    var sprintTable = sprintAddRow.data('footable');

    // sprint search input
    $('#sprint-input-search2').on('input', function(e) {
        e.preventDefault();
        sprintAddRow.trigger('footable_filter',{filter: $(this).val()});
    });

    $('.startSprint').on('click',function() {
        var sprintId = this.value;
        console.log(sprintId);

        $.ajax({
            url:"http://localhost:9000/agile/sprint/viewSprint?sprintId=" + this.value,
            type:"GET",
            dataType:'json',
            processData:false,
            contentType:true,
            success: function(data) {
                var sprintName = document.getElementById('sprintNameView');
                var sprintStart = document.getElementById('create-sprintStartView');
                var sprintEnd = document.getElementById('create-sprintEndView');
                var startDate = new Date(data.startDate);
                var endDate = new Date(data.endDate);

                sprintName.value = data.sprintName;
                sprintStart.value = (startDate.getMonth()+1) + "/" + startDate.getDate() + "/" +startDate.getFullYear();
                sprintEnd.value = (endDate.getMonth()+1) + "/" + endDate.getDate() + "/" + endDate.getFullYear();
                document.getElementById('startSprintButton').value = sprintId;

                $('#sprint-move-modal').modal();
            },
            error:function() {
                alert('스프린트 가져오기 에러!!!');
            }
        });
    });

    sprintAddRow.footable().on('click','.sprint-delete-row',function() {
        var footable = $("#backlog-foo-addrow").data('footable');
        var sprintId = this.value;

        var sprintDeleteJson = JSON.stringify({
            "sprintId" : sprintId
        });

        $.ajax({
            url:"http://localhost:9000/agile/sprint/deleteSprint",
            type:"POST",
            dataType:"json",
            data:sprintDeleteJson,
            contentType:"application/json; charset=utf-8",
            success:(data) => {
                if(data.deleteSuccess === true) {
                    // var sprintTable = sprintAddRow.data('footable');
                    var row = $(this).parents('tr:first');

                    //delete the row
                    sprintTable.removeRow(row);

                    sprintCount--;
                }
            },
            error: function() {
                alert("sprint삭제 에러!!! 다시 시도하세요.");
            }
        });
    });

    sprintButtonCreateRow.click(function() {
        $('#sprint-create-modal').modal();
    });

    // sprint Add Row Button
    sprintButtonAddRow.click(function() {
        
        var startDate = $('#create-sprintStart').val().split('/');
        var endDate = $('#create-sprintEnd').val().split('/');
        var date = new Date();

        var startMonth = startDate[0];
        var startDay = startDate[1];
        var startYear = startDate[2];
        var startHour = date.getHours();
        var startMin = date.getMinutes();
        var startSecond = date.getSeconds();

        var endMonth = endDate[0];
        var endDay = endDate[1];
        var endYear = endDate[2];
        var endHour = date.getHours();
        var endMin = date.getMinutes();
        var endSecond = date.getSeconds();

        var projectId = document.getElementById('projectId').value;
        var sprintName = $('#create-sprintName').val();
        var sprintId = projectId + "_" + sprintName;
        var description = "";
        var state = "ready";
        // console.log(document.getElementById('sprintListSize').value + "!");

        var sprintData = JSON.stringify({
            "startYear":startYear,
            "startMonth":startMonth,
            "startDay":startDay,
            "startHour":startHour,
            "startMin":startMin,
            "startSecond":startSecond,
            "endYear":endYear,
            "endMonth":endMonth,
            "endDay":endDay,
            "endHour":endHour,
            "endMin":endMin,
            "endSecond":endSecond,
            "sprintId":sprintId,
            "projectId":projectId,
            "sprintName":sprintName,
            "description":description,
            "state":state
        });

        $.ajax({
            url:"http://localhost:9000/agile/sprint/createSprint",
            type:"POST",
            dataType:"json",
            data:sprintData,
            contentType:"application/json; charset=utf-8",
            success: (data) => {
                var startDate = new Date(data.startDate);
                var endDate = new Date(data.endDate);

                // var sprintTable = sprintAddRow.data('footable');
                var newSprint = "<tr id=" + data.sprintId + "><td class='text-center'><button class='sprint-delete-row btn btn-danger btn-sm btn-icon' value=" + data.sprintId + "><i class='fa fa-times'></i></button></td>" + 
                "<td>"+ data.sprintName +"</td>" +
                "<td>" + startDate.getFullYear() + "-" + (startDate.getMonth()+1) + "-" + startDate.getDate() + startDate.getHours() + ":" + startDate.getMinutes() + ":" + startDate.getMinutes() + "</td>" +
                "<td>" + endDate.getFullYear() + "-" + (endDate.getMonth()+1) + "-" + endDate.getDate() + endDate.getHours() + ":" + endDate.getMinutes() + ":" + endDate.getSeconds() + "</td>" +
                "<td class='text-center'><button class='startSprint sprint-move-row btn btn-info btn-sm btn-icon' value=data.sprintId><i class='fa fa-plus'></i></button></td>"+
                "</tr>";
                
                sprintCount++;
                document.getElementById("sprintListSize").value = sprintCount;
                sprintTable.appendRow(newSprint);
                
                sprintAddRow.footable().on('click','.sprint-delete-row',function() {
                    var footable = $("#backlog-foo-addrow").data('footable');
                    var sprintId = this.value;
            
                    var sprintDeleteJson = JSON.stringify({
                        "sprintId" : sprintId
                    });
            
                    $.ajax({
                        url:"http://localhost:9000/agile/sprint/deleteSprint",
                        type:"POST",
                        dataType:"json",
                        data:sprintDeleteJson,
                        contentType:"application/json; charset=utf-8",
                        success:(data) => {
                            if(data.deleteSuccess === true) {
                                // var sprintTable = sprintAddRow.data('footable');
                                var row = $(this).parents('tr:first');
            
                                //delete the row
                                sprintTable.removeRow(row);
                                sprintCount--;
                            }
                        },
                        error: function() {
                            alert("sprint삭제 에러!!! 다시 시도하세요.");
                        }
                    });
                });
                $('#sprint-create-modal').modal('hide');
            },
            error: function() {
                alert("sprint생성 에러!!! 다시 시도하세요.");
            }
        });
    });

    $('#startSprintButton').click(function() {
        var sprintName = $('sprintNameView').val();
        var projectId = document.getElementById('projectId').value;
        var sprintId = this.value;

        var sprintStartJson = JSON.stringify({
            "sprintId" : sprintId,
            "projectId" : projectId
        });
        
        $.ajax({
            url:"http://localhost:9000/agile/sprint/startSprint",
            type:"POST",
            dataType:"json",
            data:sprintStartJson,
            contentType:"application/json; charset=utf-8",
            success:function(data) {
                if(data.startResult === true) {
                    window.location.href=window.location.origin + '/agile/project/viewStartSprint/' + projectId + "/" + sprintId;
                }else {
                    alert('Error... 이미 시작중인 스프린트가 있습니다!!!');
                }
            },
            error: function() {
                alert("sprint 시작 에러!!!");
            }
        });
    });

    // sprintButtonAddRow.click(function() {
    //     console.log($('#create-sprintStart').val());
    //     console.log($('#create-sprintEnd').val());
        
    //     var date = new Date();
    //     var year = date.getFullYear();
    //     var month = (date.getMonth()+1);
    //     var day = date.getDate();
    //     var hour = date.getHours();
    //     var min = date.getMinutes();
    //     var second = date.getSeconds();
    //     var projectId = document.getElementById('projectId').value;
    //     var sprintName = $('#create-sprintName').val();
    //     var sprintId = projectId + "_" + sprintName;
    //     var description = "";
    //     var state = "ready";
    //     // console.log(document.getElementById('sprintListSize').value + "!");

    //     var sprintData = JSON.stringify({
    //         "year":year,
    //         "month":month,
    //         "day":day,
    //         "hour":hour,
    //         "min":min,
    //         "second":second,
    //         "sprintId":sprintId,
    //         "projectId":projectId,
    //         "sprintName":sprintName,
    //         "description":description,
    //         "state":state
    //     });

    //     $.ajax({
    //         url:"http://localhost:9000/agile/sprint/createSprint",
    //         type:"POST",
    //         dataType:"json",
    //         data:sprintData,
    //         contentType:"application/json; charset=utf-8",
    //         success: (data) => {
    //             var startDate = new Date(data.startDate);
    //             var endDate = new Date(data.endDate);

    //             // var sprintTable = sprintAddRow.data('footable');
    //             var newSprint = "<tr id=" + data.sprintId + "><td class='text-center'><button class='sprint-delete-row btn btn-danger btn-sm btn-icon' value=" + data.sprintId + "><i class='fa fa-times'></i></button></td>" + 
    //             "<td>"+ data.sprintName +"</td>" +
    //             "<td>" + startDate.getFullYear() + "-" + (startDate.getMonth()+1) + "-" + startDate.getDate() + " " + startDate.getHours() + ":" + startDate.getMinutes() + ":" + startDate.getMinutes() + "</td>" +
    //             "<td>" + endDate.getFullYear() + "-" + (endDate.getMonth()+1) + "-" + endDate.getDate() + " " + endDate.getHours() + ":" + endDate.getMinutes() + ":" + endDate.getSeconds() + "</td>" +
    //             "<td class='text-center'><button class='startSprint sprint-move-row btn btn-info btn-sm btn-icon' value=data.sprintId><i class='fa fa-plus'></i></button></td>"+
    //             "</tr>";
                
    //             sprintCount++;
    //             document.getElementById("sprintListSize").value = sprintCount;
    //             sprintTable.appendRow(newSprint);
                
    //             sprintAddRow.footable().on('click','.sprint-delete-row',function() {
    //                 var footable = $("#backlog-foo-addrow").data('footable');
    //                 var sprintId = this.value;
            
    //                 var sprintDeleteJson = JSON.stringify({
    //                     "sprintId" : sprintId
    //                 });
            
    //                 $.ajax({
    //                     url:"http://localhost:9000/agile/sprint/deleteSprint",
    //                     type:"POST",
    //                     dataType:"json",
    //                     data:sprintDeleteJson,
    //                     contentType:"application/json; charset=utf-8",
    //                     success:(data) => {
    //                         if(data.deleteSuccess === true) {
    //                             // var sprintTable = sprintAddRow.data('footable');
    //                             var row = $(this).parents('tr:first');
            
    //                             //delete the row
    //                             sprintTable.removeRow(row);
    //                             sprintCount--;
    //                         }
    //                     },
    //                     error: function() {
    //                         alert("sprint삭제 에러!!! 다시 시도하세요.");
    //                     }
    //                 });
    //             });
    //         },
    //         error: function() {
    //             alert("sprint생성 에러!!! 다시 시도하세요.");
    //         }
    //     });
    // });
});