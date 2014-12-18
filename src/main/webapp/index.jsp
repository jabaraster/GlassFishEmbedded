<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8" >
<title>WebSocket</title>
<script src="${requestScope.contextPath}/js/jquery-1.9.1.js"></script>
</head>
<body>

<div>
  <ul>
    <li><input id="msg" type="text"></li>
    <li><button id="send">送信</button>
  </ul>
  <div id="win">
  </div>
</div>

<script>
var contextPath = "${requestScope.contextPath}";
(function($) {
	$(function() {
		var socket = new WebSocket("ws://localhost:8080" + contextPath + "/socket/endpoint");
		console.log(socket);
		$(socket).on('message', function(pMessage) {
			console.log(pMessage);
			$('#win').append(pMessage.originalEvent.data + '<br/>');
		});
		$('#send').click(function() {
			var msg = $('#msg');
			socket.send(msg.val());
			msg.val('');
		});
	});
})(jQuery);
</script>

</body>
</html>