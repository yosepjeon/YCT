// 'use strict';
// var ws = new WebSocket("ws://localhost:9000/agile/sprint-kanban");
// ws.onopen = onOpen;
// ws.onmessage = onMessage;
// ws.onclose = onClose;
$(window).on('load',function() {
	dragula([ $('todo'), $('inprogress'),$('done') ]).on('drag', function(el) {
		el.className = el.className.replace('ex-moved', '');
	}).on('drop', function(el,target) {
		if(el.className === el.parentNode.id + " gu-transit" || el.className === el.parentNode.id) {
			// console.log("제자리 이동");
			// console.log(window.location.origin);
		}else {
			// console.log(el);
			// console.log(target);
			el.className = el.parentNode.id;
			// ws.send(el+"|"+target);
			// console.log(el.parentNode.id);
			// console.log(el.className);
		}
		
	}).on('over', function(el, container) {
		container.className += ' ex-over';
		// console.log("it's over");
	}).on('out', function(el, container) {
		container.className = container.className.replace('ex-over', '');
		// console.log("it's out");
	});
	
	
	
	dragula([ $('left-rollbacks'), $('right-rollbacks') ], {
		revertOnSpill : true
	});
	dragula([ $('left-lovehandles'), $('right-lovehandles') ], {
		moves : function(el, container, handle) {
			return handle.classList.contains('handle');
		}
	});

	function $(id) {
		return document.getElementById(id);
	}
});

// // 소켓이 연결되면 자동으로 발동
// function onOpen(evt) {
// 	console.log("연결되었습니다.");
// }

// // "message" 이름의 MessageEvent 이벤트가 발생하면 처리할 핸들러
// // 이는 서버로부터 메세지가 도착했을 때 호출 
// function onMessage(evt) {
// 	var data = evt.data.split('|');
// 	console.log(data[0] + " " + data[1]);
// 	d.drop(data[0],data[1]);
// }

// // WebSocket 인터페이스의 연결상태가 readyState 에서 CLOSED 로 바뀌었을 때 호출 이벤트 리스너.
// // 이 이벤트 리스너는 "close"라는 이름의 CloseEvent를 받는다.
// function onClose(evt) {
// 	console.log("연결을 끊었습니다.");
// }
