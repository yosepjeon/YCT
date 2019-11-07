$(window).on('load',function() {
    $(".viewBackLogBtn").on("click",function() {
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
});