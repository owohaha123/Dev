//---------------------------------- side box 3 ----------------------------------------

// ------------------------------------------------------ side box 3-1
function menuSelect(menuItem){
    toggle_purple(menuItem);
    MenuToBill(menuItem)
}

// toggle_purple (1)
function toggle_purple(menuItem){
    let menuItems = document.getElementsByClassName(menuItem.classList[0]);
    for(var i = 0; i<menuItems.length; i++){
        menuItems[i].classList.remove("toggle_purple");
    }
    menuItem.classList.add("toggle_purple") 
}

// menuItem의 txt 를 m_sel로 가져오기
function MenuToBill(menuItem){
    let m_sel = document.getElementById("m_sel");
    m_sel.innerText =  menuItem.innerText;
}

// ------------------------------------------------------ side box 3-3
function addOption(menuItem){
    toggle_Yellow(menuItem);
    optionToBillToggle()
}

// toggle_yellow (2)
function toggle_Yellow(menuItem){
    if(menuItem.className != "toggle_yellow"){
        menuItem.className = "toggle_yellow";
    }else{
        menuItem.className = "";
    }
}

// 꿔바로우 toggle
function optionToBillToggle(){
    let a_op = document.getElementById("a_op");

    if(a_op.innerText == "추가없음"){
        a_op.innerText =  "꿔바로우";
        a_op.style.backgroundColor = "rgb(244, 144, 30)";
    }else{
        a_op.innerText =  "추가없음";
        a_op.style.backgroundColor = "white";
    }
}

// ------------------------------------------------------ side box 3-5

function order(){
let menuSelected = false;
let cost_res = document.getElementById("cost_res");

    let item = document.getElementsByClassName("sdb_itm");
    for(var i = 0; i<item.length; i++){
        for(var j=0; j<item[i].classList.length; j++){
            if(item[i].classList[j] == "toggle_purple"){
                // 주문 가능
                menuSelected = true;
            }
        }
    }

    if ((cost_res.innerText >= 10000) && menuSelected) {
        conf()
    }else if (cost_res.innerText < 10000){
        alert ("10000원 부터 주문 가능합니다.")
    }else if (!menuSelected){
        alert ("메뉴를 선택해주세요.")
    }
}

//---------------------------------------------- order -----------------------------------------------------

function conf() {
    var con = confirm("주문하시겠습니까?");

    if (con) {
        alert('주문되었습니다');

        let menuItems = document.getElementsByClassName("sdb_itm");
        for(var i = 0; i<menuItems.length; i++){
            menuItems[i].classList.remove("toggle_purple");
        }   

        sdb_itm2.className = "";
        list.innerHTML = "";
        cost_res.innerHTML = "";
        m_sel.innerText = "메뉴선택";
        s_sel.value = "1단계";
        a_op.innerText = "추가없음" ;
        a_op.style.backgroundColor = "white";
    } else {
        alert('취소되었습니다.');
    }
}

//--------------------------------- ingredient item(span) & x_box ------------------------------------------

// div 에서 list로 txt(span)내용만 가져오기 (addIgrd)
function addIgrd(value){
    let list = document.getElementById("list");
    let listItem =document.createElement("div");

    listItem.className = 'list_item';
    listItem.innerHTML =  value.innerText;

    // txt 가져올 때 x_box 생성
    let xbox = document.createElement("div");
    xbox.className = 'x_box';
    xbox.innerHTML = "x";
    listItem.append(xbox);

    // x_box click 시
    xbox.onclick = function() {
        delete_list(this)
        cost_res.innerText = Number(cost_res.innerText) - 1000;
    };


    // div 클릭 시 1000 씩 추가
    let cost_res = document.getElementById("cost_res");
    //console.log(cost_res);
    cost_res.innerText = Number(cost_res.innerText) + 1000;

    // list 에 listItem(txt) 추가
    // prepend 사용하여 아래가 아닌 위로 추가
    list.prepend(listItem);
}

// x_box click 하면 내용 삭제 (delete_list)
function delete_list(value){
    value.parentElement.remove()
}

//-------------------------------------- ingredient item(div) ---------------------------------------------

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

                
let igr = document.getElementById("igrd");

for(var i=0; i<image.length; i++){

    // js에서 html에 div(divWrapper) 요소 생성
    let divWrapper = document.createElement("div")
    divWrapper.id = i;

    // div(divWrapper)에 className 부여
    divWrapper.className = 'itm_info';

    
    // div(divWrapper)에 img 요소 생성
    let img = document.createElement("img"); 
    img.src = image[i];
    img.className = 'itm_img';

    // span을 담고있는 div(titleWrapper) 요소 생성
    let titleWrapper = document.createElement("div");
    titleWrapper.className="itm_title";

    // div(titleWrapper)에 span 요소 생성
    let iTitle = document.createElement("span");
    iTitle.id = i + "span";
    iTitle.innerText = ingredient[i] + " 100g";

    
    divWrapper.append(img);
    divWrapper.append(titleWrapper);
    titleWrapper.append(iTitle);

    
    // divWrapper 클릭 시 클릭된 div의 정보(this)를 가져옴
    divWrapper.onclick = function() {addIgrd(this)};
    

    // igr 에 divWrapper(div) 추가
    igr.append(divWrapper);
}