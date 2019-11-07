$(document).ready(function() {
    var element = document.getElementById('go_to_backlog');
    var projectId = document.getElementById('projectId').value;
    element.addEventListener('click', function() {
        console.log('click');
        window.location.href = window.location.origin + '/agile/project/viewBackLog/' + projectId;
    });
});