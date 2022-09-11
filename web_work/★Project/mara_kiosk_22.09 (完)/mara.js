//-------------------------------------- ingredient item(div) ---------------------------------------------

// div 에 삽입될 내용을 배열로 처리
const ingredient = ["고수","알배추","청경채","숙주나물","단호박","감자",
                    "검목이버섯","백목이버섯","새송이버섯","팽이버섯",
                    "유두피","푸주","유부",
                    "라면사리","분모자","옥수수면","중국당면",
                    "게맛살","비엔나","피쉬볼","소고기","양고기"];
const image = ["image/고수.jpg","image/알배추.jpeg","image/청경채.jpeg","image/숙주나물.jpg","image/단호박.jpg","image/감자.jpg",
                "image/검목이버섯.jpg","image/백목이버섯.jpg","image/새송이버섯.jpg","image/팽이버섯.jpg",
                "image/유두피.jpg","image/푸주.jpg","image/유부.jpg",
                "image/라면사리.jpg","image/분모자.jpg","image/옥수수면.jpg","image/중국당면.jpg",
                "image/게맛살.jpg","image/비엔나.jpg","image/피쉬볼.jpg","image/소고기.jpg","image/양고기.jpg"];

// igrd 를 변수로 선언 (igr)
let igr = document.getElementById("igrd");

// 배열의 길이만큼 반복하여 (image.length 사용해도 무방)
for(var i = 0; i<ingredient.length; i++){

    // [div] 요소 생성 (1)
    let idrDiv = document.createElement("div");
    // idrDiv.id = i; // div에 i로(배열의 길이) id 부여 
                      // 배열의 순서와 같은 id가 부여된다!
    idrDiv.className = "itm_info"; // div에 class 부여

    // [img] 요소 생성 (2)
    let img = document.createElement("img");
    img.src = image[i]; // img의 source는 배열(image)임
    img.className = "itm_img"; // img에 class 부여

    // [div_2] 요소 생성 (3)
    let titleDiv = document.createElement("div")
    titleDiv.className = "itm_title"; // div에 class 부여

    // 생성된 [div_2] 에 [span] 요소 생성 (4)
    let iTitle = document.createElement("span")
    // iTitle.id = i + "span"; // span에 id 부여 (배열 + span)
    iTitle.innerText = ingredient[i] + "100g"; // span에 보여질 txt (배열 요소 + 100g)

    idrDiv.append(img); // idrDiv 에 img 삽입
    idrDiv.append(titleDiv); // idrDiv 에 titleDiv 삽입
    titleDiv.append(iTitle); // titleDiv 에 iTitle 삽입

    // idrDiv 클릭 시 클릭된 div 자신의 정보(this)를 가져오는 함수 작동
    idrDiv.onclick = function(){addIgrd(this)};

    igrd.append(idrDiv); // 최종적으로 만들어진 요소의 정점(idrDiv)을 igrd에 삽입
}

// --------------------------------------------- function addIgrd ---------------------------------------------

// div(idrDiv) 에서 list로 txt(span)내용만 가져오기 (함수 addIgrd)
function addIgrd(value) { // parameter를 넣어줘야 this 가져올 수 있음

    // list 를 변수로 선언 (list)
    let list = document.getElementById("list");
    
    // list에 span이 넘어갈 부분(div) 생성 (1)
    let listItem = document.createElement("div");
    listItem.className = "list_item"; // listItem 에 class 부여

    // 해당 div(listItem) 내용 중 value의 text 값만 보여줌
    listItem.innerHTML = value.innerText;

    // cost_res 호출
    let cost_res = document.getElementById("cost_res");

    // 클릭 시 cost_res 에 1000 추가 (2)
    cost_res.innerText = Number(cost_res.innerText) + 1000;

    // txt 가져올 때 x_box div 생성 (3)
    let xbox = document.createElement("div");
    xbox.className = 'x_box'; // xbox 에 class 부여
    xbox.innerHTML = "x";  // xbox 에 x 삽입
    listItem.append(xbox); // listItem 에 xbox 삽입

    // x_box click 시 함수(delete_list) 동작 (4)
    xbox.onclick = function() {
        delete_list(this)
        // delete_list 동작 시 cost_res 에서 1000 차감
        cost_res.innerText = Number(cost_res.innerText) - 1000;
    };

    // list 에 listItem(txt) 추가
    // prepend 사용하여 아래가 아닌 위로 추가
    list.prepend(listItem);
};

// --------------------------------------------- function delete_list ---------------------------------------------

// x_box click 시 내용 삭제 (함수 delete_list)
function delete_list(value){
    // 부모요소(parentElement)의 value를 remove
    value.parentElement.remove()
}

// --------------------------------------------- side box ---------------------------------------------

// ------------------------------------------------------ side box 1-1 (menuSelect)

// 함수 menuSelect 작동 시 [ toggle_purple & MenuToBill ] 작동
function menuSelect(menuItem){
    toggle_purple(menuItem);
    MenuToBill(menuItem)
}

// side box 1-1 toggle 함수 (purple)
// ※ sdb_itm 에 무조건 보라색이 들어와있어야 함!!
function toggle_purple(selectedMenu){
    // selectedMenu 의 classList 중 0번째(sdb_itm) 호출하여 변수로 선언 (menuItems)
    let menuItems = document.getElementsByClassName(selectedMenu.classList[0]);
    // classList의 길이만큼 for문 돌림
    for (var i = 0; i<menuItems.length; i++){
        // 동작 시 classList에서 toggle_purple 삭제
        menuItems[i].classList.remove("toggle_purple")
    }
    // for문 동작 후 toggle_purple 추가 (셋 중 하나엔 색이 들어있어야 하기에)
    selectedMenu.classList.add("toggle_purple");
};

// ----------------------------- side box 3-1 (MenuToBill)
// toggle_purple 동작 시 menuItems의 txt를 m_sel로 가져오기 (함수 MenuToBill)
function MenuToBill(menuItem){
    // m_sel 를 변수로 선언 (m_sel)
    let m_sel = document.getElementById("m_sel");
    // m_sel 내용 중 menuItem의 text 값만 보여줌
    m_sel.innerText =  menuItem.innerText;
};

// ------------------------------------------------------ side box 1-2 (addOption)

// 함수 addOption 작동 시 [ toggle_Yellow & optionToBillToggle ] 작동
function addOption(selectedMenu){
    toggle_Yellow(selectedMenu);
    optionToBillToggle()
};

// side box 1-2 toggle 함수 (yellow)
function toggle_Yellow(selectedMenu){
    // className 에 toggle_yellow 미포함 시
    if(selectedMenu.className != "toggle_yellow"){
        // className 에 toggle_yellow 추가
        selectedMenu.className = "toggle_yellow";
    }else{
        // 있으면 공백
        selectedMenu.className = "";
    };
};

// ----------------------------- side box 3-3 (optionToBillToggle)
// toggle_Yellow 동작 시 3-3 내용 변경 (함수 function optionToBillToggle)
function optionToBillToggle(){
    // a_op 를 변수로 선언 (a_op)
    let a_op = document.getElementById("a_op");

    // a_op 안에 "추가없음" 이 있으면
    if(a_op.innerText == "추가없음"){
        // "꿔바로우" , "rgb(244, 144, 30)" 로 변경
        a_op.innerText =  "꿔바로우";
        a_op.style.backgroundColor = "rgb(244, 144, 30)";
    }else{ // 아니면
        // "추가없음" , "white" 로 변경
        a_op.innerText =  "추가없음";
        a_op.style.backgroundColor = "white";
    };
};

// ------------------------------------------------------------------ side box 3-5 

// ----------------------------- side box 3-3 (order)
// 주문하기 클릭 시 주문 가능 여부 확인 함수(order)
function order(){
    // 변수 [menuSelected] 의 기본값은 "false"
    let menuSelected = false;
    // cost_res 를 변수로 선언 (cost_res)
    let cost_res = document.getElementById("cost_res");

        // menu를 선택했는지의 여부(menuSelected = true) 파악
        // sdb_itm 를 변수로 선언 (item)
        let item = document.getElementsByClassName("sdb_itm");
        // for문(i)을 item 길이(3)만큼 돌림
        for(var i = 0; i<item.length; i++){
            // for문(j) 을 item의 classList.length(2) 만큼 돌림
            for(var j=0; j<item[i].classList.length; j++){
                // item[i]의 classList[j] 가 "toggle_purple" 이면
                if(item[i].classList[j] == "toggle_purple"){
                    // menuSelected은 "true" (주문 가능)
                    menuSelected = true;
                };
            };
        };

        // [cost_res 값이 10000 이상] & [menuSelected = true]이면
        if ((cost_res.innerText >= 10000) && menuSelected) {
            // conf 작동
            conf()
        }else if (cost_res.innerText < 10000){ // cost_res 값이 10000 미만
            alert ("10000원 부터 주문 가능합니다.")
        }else if (!menuSelected){ // menuSelected 가 false
            alert ("메뉴를 선택해주세요.")
        };
    };

//---------------------------------------------- order (conf) -----------------------------------------------------

// 주문 완료 시 화면 clear (함수 conf)
function conf() {
    // confirm 창 질문
    var con = confirm("주문하시겠습니까?");

    // 만약 주문이 완료되었다면
    if (con) {
        // 주문완료 alert
        alert('주문되었습니다');

        // toggle_purple 제거
        let menuItems = document.getElementsByClassName("sdb_itm");
        for(var i = 0; i<menuItems.length; i++){
            menuItems[i].classList.remove("toggle_purple");
        }   
        sdb_itm2.className = ""; // sdb_itm2(꿔바로우) toggle_Yellow 제거
        list.innerHTML = ""; // list(선택재료) 빈 칸으로
        cost_res.innerHTML = ""; // cost_res(금액) 빈 칸으로
        m_sel.innerText = "메뉴선택"; // m_sel(메뉴선택) 기본값
        s_sel.value = "1단계"; // s_sel 기본값 
        a_op.innerText = "추가없음" ; // a_op 기본값
        a_op.style.backgroundColor = "white"; // a_op 기본값(style)

    // 그렇지 않다면 (취소했다면)
    } else { 
        // 주문취소 alert
        alert('취소되었습니다.');
    };
};