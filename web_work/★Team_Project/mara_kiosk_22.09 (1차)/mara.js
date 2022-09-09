var currentMenu;
var menuLinks = document.querySelectorAll('#sdb_itm');

function clickMenuHandler() {
    if (currentMenu) {
        currentMenu.classList.remove('menu-active');
    }
    this.classList.add('menu-active');
    currentMenu = this;
}

for (var i = 0; i < menuLinks.length; i++) {
    menuLinks[i].addEventListener('click', clickMenuHandler);
}
//----------------------------------------------
var currentMenu2;
var menuLinks2 = document.querySelectorAll('#sdb_itm2');

function clickMenuHandler2() {
    if (currentMenu2) {
        currentMenu2.classList.remove('menu-active2');
    }
    this.classList.add('menu-active2');
    currentMenu2 = this;
}

for (var i = 0; i < menuLinks2.length; i++) {
    menuLinks2[i].addEventListener('click', clickMenuHandler2);
}

//----------------------------------------------

function conf() {
    var con = confirm("주문하시겠습니까?");

    if (con) {
        alert('주문되었습니다');
        list.innerHTML = "";
    } else {
        alert('취소되었습니다.');
    }
}

// --------------------------------------------

const btn = document.querySelectorAll("button");
//const res = document.querySelectorAll("#result");
const res = document.getElementById("result")
const res1 = document.getElementById("result1")
const res2 = document.getElementById("result2")
const res3 = document.getElementById("result3")
const res4 = document.getElementById("result4")
const res5 = document.getElementById("result5")
const res6 = document.getElementById("result6")
const res7 = document.getElementById("result7")
const res8 = document.getElementById("result8")
const res9 = document.getElementById("result9")
const res10 = document.getElementById("result10")
const res11 = document.getElementById("result11")
const res12 = document.getElementById("result12")
const res13 = document.getElementById("result13")
const res14 = document.getElementById("result14")
const res15 = document.getElementById("result15")
const res16 = document.getElementById("result16")
const res17 = document.getElementById("result17")
const res18 = document.getElementById("result18")
const res19 = document.getElementById("result19")
const res20 = document.getElementById("result20")
const res21 = document.getElementById("result21")
const res22 = document.getElementById("result22")
//const element = document.getElementsByClassName('itm_title');

btn[0].addEventListener("click", function () {
    res.innerHTML = "감자 100g";
})
btn[1].addEventListener("click", function () {
    res1.innerHTML = "고수 100g";
})
btn[2].addEventListener("click", function () {
    res2.innerHTML = "단호박 100g";
})
btn[3].addEventListener("click", function () {
    res3.innerHTML = "숙주나물 100g";
})
btn[4].addEventListener("click", function () {
    res4.innerHTML = "알배추 100g";
})
btn[5].addEventListener("click", function () {
    res5.innerHTML = "청경채 100g";
})
btn[6].addEventListener("click", function () {
    res6.innerHTML = "검목이버섯 100g";
})
btn[7].addEventListener("click", function () {
    res7.innerHTML = "백목이버섯 100g";
})
btn[8].addEventListener("click", function () {
    res8.innerHTML = "새송이버섯 100g";
})
btn[9].addEventListener("click", function () {
    res9.innerHTML = "팽이버섯 100g";
})
btn[10].addEventListener("click", function () {
    res10.innerHTML = "비엔나 100g";
})
btn[11].addEventListener("click", function () {
    res11.innerHTML = "유부 100g";
})
btn[12].addEventListener("click", function () {
    res12.innerHTML = "유두피 100g";
})
btn[13].addEventListener("click", function () {
    res13.innerHTML = "푸주 100g";
})
btn[14].addEventListener("click", function () {
    res14.innerHTML = "감자 100g";
})
btn[15].addEventListener("click", function () {
    res15.innerHTML = "피쉬볼 100g";
})
btn[16].addEventListener("click", function () {
    res16.innerHTML = "게맛살 100g";
})
btn[17].addEventListener("click", function () {
    res17.innerHTML = "라면사리 100g";
})
btn[18].addEventListener("click", function () {
    res18.innerHTML = "옥수수면 100g";
})
btn[19].addEventListener("click", function () {
    res19.innerHTML = "중국당면 100g";
})
btn[20].addEventListener("click", function () {
    res20.innerHTML = "분모자 100g";
})
btn[21].addEventListener("click", function () {
    res21.innerHTML = "소고기 100g";
})
btn[22].addEventListener("click", function () {
    res22.innerHTML = "양고기 100g";
})
