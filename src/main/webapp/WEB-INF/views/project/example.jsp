<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="../include/header.jsp" %>

<link href='${path}/resources/js/dragula/dragula.css' rel='stylesheet' type='text/css' />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class='parent'>
		<label for='hy'>There are plenty of events along the lifetime
			of a drag event. Check out <a
			href='https://github.com/bevacqua/dragula#drakeon-events'>all of
				them</a> in the docs!
		</label>
		<div class='wrapper'>
			<div id='left-events' class='container'>
				<div>
					As soon as you start dragging an element, a
					<code>drag</code>
					event is fired
				</div>
				<div>
					Whenever an element is cloned because
					<code>copy: true</code>
					, a
					<code>cloned</code>
					event fires
				</div>
				<div>
					The
					<code>shadow</code>
					event fires whenever the placeholder showing where an element would
					be dropped is moved to a different container or position
				</div>
				<div>
					A
					<code>drop</code>
					event is fired whenever an element is dropped anywhere other than
					its origin <em>(where it was initially dragged from)</em>
				</div>
			</div>
			<div id='right-events' class='container'>
				<div>
					If the element gets removed from the DOM as a result of dropping
					outside of any containers, a
					<code>remove</code>
					event gets fired
				</div>
				<div>
					A
					<code>cancel</code>
					event is fired when an element would be dropped onto an invalid
					target, but retains its original placement instead
				</div>
				<div>
					The
					<code>over</code>
					event fires when you drag something over a container, and
					<code>out</code>
					fires when you drag it away from the container
				</div>
				<div>
					Lastly, a
					<code>dragend</code>
					event is fired whenever a drag operation ends, regardless of
					whether it ends in a cancellation, removal, or drop
				</div>
			</div>
		</div>
		<pre>
            <code>
            dragula([document.getElementById(left), document.getElementById(right)])
              .on('drag', function (el) {
                el.className = el.className.replace('ex-moved', '');
              }).on('drop', function (el) {
                el.className += ' ex-moved';
              }).on('over', function (el, container) {
                container.className += ' ex-over';
              }).on('out', function (el, container) {
                container.className = container.className.replace('ex-over', '');
              });
            </code>
        </pre>
	</div>

	<!-- Dragula -->
    <script src='https://cdnjs.cloudflare.com/ajax/libs/dragula/3.7.2/dragula.js'></script>
    <script src='${path}/resources/js/dragula/yosepkanban.js' type="text/javascript"></script>
    <!-- <script src="${path }/resources/js/dragula/dragula.js"></script> -->
</body>
</html>