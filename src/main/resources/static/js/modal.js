var modal = document.getElementById('myModal');
var btn = document.getElementsByClassName("delete-btn");
var decisionNo = document.getElementById('decisionNo');

for(var i = 0; i < btn.length; i++){
    btn[i].onclick =function() {
        modal.style.display = "block";
    }
}

decisionNo.onclick = function() {
    modal.style.display = "none";
}

window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}