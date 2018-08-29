var stompClient = null;
connect();
function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/endpoint');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/onk-master', function (event) {
            // showEvent(JSON.parse(greeting.body).content);
            showEvent(event.body)
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    // stompClient.send("/app/onk-req", {}, JSON.stringify({'name': $("#name").val()}));
    stompClient.send("/app/onk-req", {}, $("#name").val());
}


function showEvent(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}

function logout(){
    window.location.href = "/logout"
}

$(function () {
    $("form").on('submit', function (e) {e.preventDefault();});
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
    $( "#logout").click(function() { logout()});
});

