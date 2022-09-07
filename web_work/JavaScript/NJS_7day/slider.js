/*
슬라이더 제어용 스크립트
*/

let i = 0; // 슬라이드 번호

// radio 버튼 한 번에 불러오기
const pos = document.querySelectorAll("[type = 'radio']");

function slide(){
    i++;
    if (i >= 4){
        i = 0;
    }
    // 라디오버튼 체크상태 변경
    pos[i].checked = true; // 체크
                           // 라디오 버튼은 하나 체크되면 다른버튼은 체크 해제됨)
                           // 다른 버튼을 추가적으로 해제 안해도 o)
}
let inter = setInterval(slide, 3000);

function change(po){
    i = po;
    clearInterval(inter);
    inter = setInterval(slide, 3000)
}


