import React, { useState } from "react";

const CafeMenu2 = () => {
    //메뉴항목을 가지고 있는 state(초기 목록)
    const [items, setItems] = useState([
        { id: 1, menu: "아메리카노" },
        { id: 2, menu: "카페라떼" },
        { id: 3, menu: "녹차라떼" },
    ]);

    //항목 삭제 처리(onDoubleClick 이벤트)
    //삭제할 항목(id로 구분)을 제거한 새 목록을 작성하여
    //setItems(새목록) 한다.
    const rmItem = id => {
        const afterList = items.filter(item => item.id !== id);
        setItems(afterList);
    }//

    //더블클릭 시 해당 메뉴 삭제(onDoubleClick 이벤트)
    const menuList = items.map(item => (
        <li key={item.id} onDoubleClick={() => rmItem(item.id)}>
            {item.menu}
        </li>
    ));
    //input 태그로 입력 받는 값 저장 state
    const [inMenu, setInMenu] = useState("");
    //id 값 처리를 위한 state
    const [newId, setNewId] = useState(4);

    //입력 값에 따라 inMenu를 업데이트하는 함수
    const onch = (e) => setInMenu(e.target.value);

    //추가 버튼을 누를 때 메뉴 목록에 새 메뉴 추가
    const onck = () => {
        //메뉴목록을 업데이트 하기 위한 새 목록 작성.
        //사용자의 입력값과 새 id
        const nextItem = items.concat({
            id: newId,
            menu: inMenu,
        });
        //새 메뉴목록(nextItem)으로 메뉴목록 state를 덮어쓰기
        setItems(nextItem);
        //새 id 준비
        setNewId(newId + 1);
        //입력 태그 초기화
        setInMenu("");
    }

    return (
        <>
            <input value={inMenu} onChange={onch} />
            <button onClick={onck}>추가</button>
            <ul>{menuList}</ul>
        </>
    );
}

export default CafeMenu2;