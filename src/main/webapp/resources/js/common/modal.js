$(window).on('load',function() {
    // 작성일: 2019-08-24
    // 작성자: 전요셉
    // 내용: Modal창이 꺼질때마다 기존의 입력했던 값들을 초기화 해준다.
    $('.modal').on('hidden.bs.modal', function (e) {
        console.log('modal close');
      $(this).find('form')[0].reset()
    });

    $('#create-backlog-task-modal').on('hidden.bs.modal',function(e) {
      $(this).find('form')[0].reset();
      document.getElementById('sprintId').value = "";
    });

    $('#view-backlog-task-modal').on('hidden.bs.modal',function(e) {
      $(this).find('form')[0].reset();
      document.getElementById('sprintIdView').value = "";
    });

    $('#sprint-create-modal').on('hidden.bs.modal',function(e) {
      $(this).find('form')[0].reset();
      document.getElementById('create-sprintStart').value = "";
      document.getElementById('create-sprintEnd').value = "";
    });
});