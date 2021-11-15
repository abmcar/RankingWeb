function updateOjId() {
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
    var ojName = document.getElementById("ojName").value;
    var newId = document.getElementById("newId").value;
    var userSno = document.getElementById("userSno").innerHTML;
    var url = "userCheck?action=updateOjId&ojName=" + ojName + "&newId=" + newId + "&userSno=" + userSno;
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}

function changeUserPassword() {
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
            document.getElementById("result1").innerHTML = xmlhttp.responseText;
        }
    }
    var oldPassword = document.getElementById("oldPassword").value;
    var newPassword = document.getElementById("newPassword").value;
    var confirmPassword = document.getElementById("confirmPassword").value;
    var userSno = document.getElementById("userSno").innerHTML
    // xmlhttp.setAttribute("")
    var url = "userCheck?action=updateUserPassword&oldPassword=" + oldPassword + "&newPassword=" + newPassword + "&confirmPassword=" + confirmPassword + "&userSno=" + userSno;
    xmlhttp.open("GET", url, true);
    xmlhttp.send();

}