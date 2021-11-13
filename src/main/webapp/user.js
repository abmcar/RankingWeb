function changeOjId() {
    var xmlhttp;
    if (window.XMLHttpRequest) {
        //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xmlhttp = new XMLHttpRequest();
    } else {
        // IE6, IE5 浏览器执行代码
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {

            document.getElementById("result").innerHTML = xmlhttp.responseText;
        }
    }
    var ojName = document.getElementById("ojName").value
    var newId = document.getElementById("newId").value
    var userSno = document.getElementById("userSno").value
    var url = "userCheck?action=changeOjId&ojName=" + ojName + "&newId=" + newId + "&userSno=" + userSno;
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}