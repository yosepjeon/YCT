$(window).on('load',function() {
    var projectId = document.getElementById('projectId').value;
    var taskCount = parseInt(document.getElementById('taskListSize').value);

    // var backlogButtonAddRow = $('#backlog-btn-addrow');
    var backlogAddRow = $("#backlog-foo-addrow");
    backlogAddRow.footable();
    var backlogTable = backlogAddRow.data('footable');

    // backlog search input
    $('#backlog-input-search2').on('input',function(e) {
        e.preventDefault();
        backlogAddRow.trigger('footable_filter',{filter:$(this).val()});
    });

    backlogAddRow.footable().on('click', '.task-delete-row', function() {

        //get the footable object
        var footable = backlogAddRow.data('footable');
        // console.log(this.value);
        var taskId = this.value;

        var taskDeleteJson = JSON.stringify({
            "taskId" : taskId
        });

        $.ajax({
            url:"http://localhost:9000/agile/task/deleteTask",
            type:"POST",
            dataType:"json",
            data: taskDeleteJson,
            contentType:"application/json; charset=utf-8",
            success: (data)=> {
                // console.log(taskDeleteJson);
                // console.log(data.deleteSuccess);
                if(data.deleteSuccess === true) {
                    // console.log('!!!!!!!!');
                    //get the row we are wanting to delete
                    var row = $(this).parents('tr:first');

                    //delete the row
                    footable.removeRow(row);
                }
            },
            error: function() {
                alert("task삭제 에러!!! 다시 시도하세요.");
            }
        });
    });

    function clickAssignee() {
        console.log("!!!!");
        console.log($(this).val());
    }

    function initAddBackLogModal() {
        document.getElementById('status').innerHTML = "STATUS";
        document.getElementById('status').value = "";

        document.getElementById('priority').innerHTML = "PRIORITY";
        document.getElementById('priority').value = "";

        document.getElementById('assignee-dropdown').innerHTML = "";
        document.getElementById('assignee').innerHTML = 'ASSIGNEE';
        document.getElementById('assignee').value = '';

        document.getElementById('sprint-dropdown').innerHTML = "";
        document.getElementById('sprint').innerHTML = "SPRINT";
        document.getElementById('sprint').value = "";

        document.getElementById("reporter").innerHTML = "REPORTER";
        document.getElementById("reporter").value = "";
    }

    $("#addBackLogBtn").on("click",function() {
        var DataForCreateBackLog;
        var projectId = $('#projectId').val();

        $.ajax({
            url:"http://localhost:9000/agile/task/getelement?projectId=" + projectId,
            type:"GET",
            dataType:"json",
            processData:false,
            contentType:true,
            success: function(data) {
                var userList = data.userList;
                var sprintList = data.sprintList;
                var tmp = "";
                var tmp2 = "";
                initAddBackLogModal();

                userList.forEach(element => {
                    tmp = "<a id=" + element + " class='dropdown-item'>" + element + "</a>";
                    $('#assignee-dropdown').append(tmp);
                    document.getElementById(element).addEventListener('click',function(event) {
                        var val = document.getElementById(element).innerHTML;
                        var assignee = document.getElementById('assignee');

                        assignee.value = val;
                        assignee.innerHTML = val;
                    });
                });

                sprintList.forEach(element1 => {
                    tmp2 = "<a id=" + element1.sprintId + "_dropitem" + " class='dropdown-item'>" + element1.sprintName + "</a>";
                    $('#sprint-dropdown').append(tmp2);
                    console.log(document.getElementById(element1.sprintId + "_dropitem").innerHTML);
                    document.getElementById(element1.sprintId + "_dropitem").addEventListener('click',function(event) {
                        var val = document.getElementById(element1.sprintId + "_dropitem").innerHTML;
                        var sprint = document.getElementById('sprint');

                        sprint.value = val;
                        sprint.innerHTML = element1.sprintName;
                        document.getElementById('sprintId').value = element1.sprintId;
                    });
                });

                $('#create-backlog-task-modal').modal();
            },
            error: function() {
                alert("ERROR!");
            }
        });
    });

    // STATUS dropdown관련
    $('#status-todo').on('click',function() {
        var todo = document.getElementById('status-todo').innerHTML;
        var status = document.getElementById('status');

        status.value = todo;
        status.innerHTML = todo;
    });

    $('#status-inprogress').on('click',function() {
        var inprogress = document.getElementById('status-inprogress').innerHTML;
        var status = document.getElementById('status');

        status.value = inprogress;
        status.innerHTML = inprogress;
    });

    $('#status-done').on('click',function() {
        var done = document.getElementById('status-done').innerHTML;
        var status = document.getElementById('status');

        status.value = done;
        status.innerHTML = done;
    });

    $('#priority-highest').on('click',function() {
        var highest = document.getElementById('priority-highest-value').value;
        var priority = document.getElementById('priority');
    
        priority.value = highest;
        priority.innerHTML = highest;
    });

    $('#priority-high').on('click',function() {
        var high = document.getElementById('priority-high-value').value;
        var priority = document.getElementById('priority');
        
        priority.value = high;
        priority.innerHTML = high;
    });

    $('#priority-medium').on('click',function() {
        var medium = document.getElementById('priority-medium-value').value;
        var priority = document.getElementById('priority');
    
        priority.value = medium;
        console.log(medium);
        priority.innerHTML = medium;
    });

    $('#priority-low').on('click',function() {
        var low = document.getElementById('priority-low-value').value;
        var priority = document.getElementById('priority');
        
        priority.value = low;
        console.log(low);
        priority.innerHTML = low;
    });

    $('#priority-lowest').on('click',function() {
        var lowest = document.getElementById('priority-lowest-value').value;
        var priority = document.getElementById('priority');
        
        priority.value = lowest;
        priority.innerHTML = lowest;
    });

    // $('#taskAttachment').change(function(){
    //     fileBuffer = [];
    //     const target = document.getElementsByName('attachmentFiles[]');
        
    //     console.log('!!!');
    //     Array.prototype.push.apply(fileBuffer, target[0].files);
    //     var html = '';
    //     $.each(target[0].files, function(index, file){
    //         const fileName = file.name;
    //         html += '<div class="file">';
    //         html += '<img src="'+URL.createObjectURL(file)+'" style="max-width: 100%; height: auto;">'
    //         html += '<span>'+fileName+'</span>';
    //         // html += '<span>기간 '+'<input type="text" style="width:250px/"></span>';
    //         html += '<a href="#" id="removeImg">╳</a>';
    //         html += '</div>';
    //         const fileEx = fileName.slice(fileName.indexOf(".") + 1).toLowerCase();
    //         if(fileEx != "jpg" && fileEx != "png" &&  fileEx != "gif" &&  fileEx != "bmp" && fileEx != "wmv" && fileEx != "mp4" && fileEx != "avi"){
    //             alert("파일은 (jpg, png, gif, bmp, wmv, mp4, avi) 형식만 등록 가능합니다.");
    //             resetFile();
    //             return false;
    //         }
    //         $('.fileList').html(html);
    //     });
 
    // });

    $('#createTaskButton').on('click',function() {
        var date = new Date();
        var year = date.getFullYear();
        var month = (date.getMonth()+1);
        var day = date.getDate();
        var hour = date.getHours();
        var min = date.getMinutes();
        var second = date.getSeconds();

        var taskName = document.getElementById('taskName');
        var taskId = projectId + "_" + "Task_" + taskName.value;
        
        var formData = new FormData();
        formData.append('taskId',taskId);
        formData.append('taskName',document.getElementById('taskName').value);
        formData.append('description',document.getElementById("elm1_ifr").contentWindow.document.getElementById("tinymce").innerHTML);
        for(var i=0;i<document.getElementById('taskAttachment').files.length;i++) {
            formData.append('attachments',document.getElementById('taskAttachment').files[i]);
        }
        formData.append('taskStatus',document.getElementById('status').value.toLowerCase());
        formData.append('taskPriority',document.getElementById('priority').value);
        formData.append('assignee',document.getElementById('assignee').value);
        if(document.getElementById('sprintId').value === "") {
            formData.append('sprintId',projectId+"_Sprint#");
        }else {
            formData.append('sprintId',document.getElementById('sprintId').value);
        }
        formData.append('projectId',document.getElementById('projectId').value);

        formData.append('year',year);
        formData.append('month',month);
        formData.append('day',day);
        formData.append('hour',hour);
        formData.append('min',min);
        formData.append('second',second);
        // var taskName = document.getElementById('taskName').value;
        // var description = document.getElementById("elm1_ifr").contentWindow.document.getElementById("tinymce").innerHTML;
        // var attachments;
        // var taskStatus = document.getElementById('status').value;
        // var taskPriority = document.getElementById('priority').value;
        // var assignee = document.getElementById('assignee').value;
        // var sprint = document.getElementById('sprintId').value;

        $.ajax({
            url:"http://localhost:9000/agile/task/createTask",
            type:"POST",
            enctype: 'multipart/form-data',
            data:formData,
            processData:false,
            contentType:false,
            success: function (data) {
                if(data.sprintId === document.getElementById('firstSprintId').value) {
                    var newBackLog = "<tr><td class='text-center'><button class='task-delete-row btn btn-danger btn-sm btn-icon'"+ "value="+data.taskId+"><i class='fa fa-times'></i></button></td>" +
                    "<td>" + data.taskName + "</td>" +
                    "<td>" + data.taskId + "</td>" +
                    "<td>" + data.taskPriority + "</td>" + 
                    "<td class='text-center'><button class='moveBackLogBtn task-move-row btn btn-info btn-sm btn-icon' value=" + data.taskId + "><i class='fa fa-plus'></i></button></td></tr>";
                    
                    backlogTable.appendRow(newBackLog);
                    document.getElementById('sprintId').value = "";
                    $('#create-backlog-task-modal').modal('hide');
                    window.location.href= window.location.origin + '/agile/project/viewBackLog/' + projectId;
                }else {
                    document.getElementById('sprintId').value = "";
                    $('#create-backlog-task-modal').modal('hide');
                }

                // document.getElementById('taskListSize').value = taskCount;
                
            },
            error: function() {
                // taskCount--;
                document.getElementById('sprintId').value = "";
                alert("task생성 에러!!! 다시 시도하세요.");
            }
        });
    });

    $('#priority-highestView').on('click',function() {
        var highest = document.getElementById('priority-highest-valueView').value;
        var priority = document.getElementById('priorityView');
    
        priority.value = highest;
        priority.innerHTML = highest;
    });

    $('#priority-highView').on('click',function() {
        var high = document.getElementById('priority-high-valueView').value;
        var priority = document.getElementById('priorityView');
        
        priority.value = high;
        priority.innerHTML = high;
    });

    $('#priority-mediumView').on('click',function() {
        var medium = document.getElementById('priority-medium-valueView').value;
        var priority = document.getElementById('priorityView');
    
        priority.value = medium;
        console.log(medium);
        priority.innerHTML = medium;
    });

    $('#priority-lowView').on('click',function() {
        var low = document.getElementById('priority-low-valueView').value;
        var priority = document.getElementById('priorityView');
        
        priority.value = low;
        console.log(low);
        priority.innerHTML = low;
    });

    $('#priority-lowestView').on('click',function() {
        var lowest = document.getElementById('priority-lowest-valueView').value;
        var priority = document.getElementById('priorityView');
        
        priority.value = lowest;
        priority.innerHTML = lowest;
    });

    $(".moveBackLogBtn").on("click",function() {
        var DataForCreateBackLog;
        var projectId = $('#projectId').val();
        console.log('!!!');

        $.ajax({
            url:"http://localhost:9000/agile/task/viewTask?taskId=" + this.value+"&projectId=" + projectId,
            type:"GET",
            dataType:"json",
            processData:false,
            contentType:true,
            success: function(data){
                var userList = data.userList;
                var sprintList = data.sprintList;
                var tmp = "";
                var tmp2 = "";
                var taskName = document.getElementById('taskNameView');
                var taskDescription = document.getElementById('elm1View');
                var status = document.getElementById('statusView');
                var priority = document.getElementById('priorityView');
                var assignee = document.getElementById('assigneeView');

                if(data.sprintId === 'p1_enekelx1_Sprint#') {
                    document.getElementById('sprintView').value = "";
                    document.getElementById('sprintView').innerHTML = 'SPRINT'
                }else {
                    document.getElementById('sprintView').value = data.sprintName;
                    document.getElementById('sprintView').innerHTML = data.sprintName;
                }

                document.getElementById('assignee-dropdownView').innerHTML = "";
                document.getElementById('sprint-dropdownView').innerHTML = "";

                taskName.innerHTML = data.taskName;
                taskName.value = data.taskName;
                status.innerHTML = data.taskStatus;
                status.value = data.taskStatus;
                priority.innerHTML = data.taskPriority;
                priority.value = data.taskPriority;
                assignee.innerHTML = data.assignee;
                assignee.value = data.assignee;
                document.getElementById("elm1View_ifr").contentWindow.document.getElementById("tinymce").innerHTML = data.taskDescription;
                

                userList.forEach(element => {
                    tmp = "<a id=" + element + " class='dropdown-item'>" + element + "</a>";
                    $('#assignee-dropdownView').append(tmp);
                    document.getElementById(element).addEventListener('click',function(event) {
                        var val = document.getElementById(element).innerHTML;
                        var assignee = document.getElementById('assigneeView');

                        assignee.value = val;
                        assignee.innerHTML = val;
                    });
                });

                sprintList.forEach(element1 => {
                    tmp2 = "<a id=" + element1.sprintId + "_dropitem" + " class='dropdown-item'>" + element1.sprintName + "</a>";
                    $('#sprint-dropdownView').append(tmp2);
                    console.log(document.getElementById(element1.sprintId + "_dropitem").innerHTML);
                    document.getElementById(element1.sprintId + "_dropitem").addEventListener('click',function(event) {
                        var val = document.getElementById(element1.sprintId + "_dropitem").innerHTML;
                        var sprint = document.getElementById('sprintView');

                        sprint.value = val;
                        sprint.innerHTML = element1.sprintName;
                        document.getElementById('sprintIdView').value = element1.sprintId;
                    });
                });

                // document.getElementById("elm1_ifr").contentWindow.document.getElementById("tinymce").innerHTML;

                $('#view-backlog-task-modal').modal();
            },
            error: function() {
                alert("ERROR!");
            }
        });
    });

    $('#updateTaskButton').on('click',function() {
        // var footable = backlogAddRow.data('footable');
        var date = new Date();
        var year = date.getFullYear();
        var month = (date.getMonth()+1);
        var day = date.getDate();
        var hour = date.getHours();
        var min = date.getMinutes();
        var second = date.getSeconds();
        var sprintIdViewValue = document.getElementById('sprintIdView').value;

        var taskName = document.getElementById('taskNameView');
        var taskId = projectId + "_" + "Task_" + taskName.value;
        
        var formData = new FormData();
        formData.append('taskId',taskId);
        formData.append('taskName',document.getElementById('taskNameView').value);
        formData.append('description',document.getElementById("elm1View_ifr").contentWindow.document.getElementById("tinymce").innerHTML);
        for(var i=0;i<document.getElementById('taskAttachment').files.length;i++) {
            formData.append('attachments',document.getElementById('taskAttachment').files[i]);
        }
        formData.append('taskStatus',document.getElementById('statusView').value);
        formData.append('taskPriority',document.getElementById('priorityView').value);
        formData.append('assignee',document.getElementById('assigneeView').value);
        if(sprintIdViewValue === "") {
            console.log(document.getElementById('sprintIdView').value);
            formData.append('sprintId',projectId+"_Sprint#");
        }else {
            console.log("!!!!");
            formData.append('sprintId',sprintIdViewValue);
        }
        formData.append('projectId',document.getElementById('projectId').value);

        formData.append('year',year);
        formData.append('month',month);
        formData.append('day',day);
        formData.append('hour',hour);
        formData.append('min',min);
        formData.append('second',second);
        // var taskName = document.getElementById('taskName').value;
        // var description = document.getElementById("elm1_ifr").contentWindow.document.getElementById("tinymce").innerHTML;
        // var attachments;
        // var taskStatus = document.getElementById('status').value;
        // var taskPriority = document.getElementById('priority').value;
        // var assignee = document.getElementById('assignee').value;
        // var sprint = document.getElementById('sprintId').value;

        $.ajax({
            url:"http://localhost:9000/agile/task/updateTask",
            type:"POST",
            enctype: 'multipart/form-data',
            data:formData,
            processData:false,
            contentType:false,
            success: (data) => {
                if(data.sprintId === document.getElementById('firstSprintId').value) {
                    console.log('!!!');
                    // //get the row we are wanting to delete
                    // var row = $(this).parents('tr:first');

                    // //delete the row
                    // footable.removeRow(row);
                    document.getElementById('sprintId').value = "";
                    $('#view-backlog-task-modal').modal('hide');
                }else {
                    // console.log(data.sprintId + "###");

                    //get the row we are wanting to delete
                    // var row = $(this).parents('tr:first');

                    //delete the row
                    // backlogTable.removeRow(row);
                    
                    document.getElementById('sprintId').value = "";
                    window.location.href= window.location.origin + '/agile/project/viewBackLog/' + projectId;
                    // $('#view-backlog-task-modal').modal('hide');
                }

                // document.getElementById('taskListSize').value = taskCount;
                
            },
            error: function() {
                // taskCount--;
                document.getElementById('sprintId').value = "";
                alert("task생성 에러!!! 다시 시도하세요.");
            }
        });
    });
});