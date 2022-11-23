import React, { useState } from 'react';

const CafeMenu = () => {
    const [items, setItems] = useState([
        { id: 1, menu: "아메리카노" },
        { id: 2, menu: "카페라떼" },
        { id: 3, menu: "카페모카" },
      ]);
    
    //새 메뉴 입력 처리 부분
    const [inMenu, setInMenu] = useState("");
    const [newId, setNewId] = useState(4);
    //새로운 항목이 추가될 때 사용.

    //입력 값의 처리는 onChange 이벤트로 한다.
    const onch = (e) => setInMenu(e.target.value);

    //새 메뉴를 목록에 추가
    const onck = () => {
    const nextItem = items.concat({
        id: newId,
        menu: inMenu,
    });
    //다음에 추가할 새 아이템 번호
    setNewId(newId + 1);
    //새 아이템이 추가된 메뉴로 목록을 업데이트
    setItems(nextItem);
    setInMenu(""); //입력 태그 비우기
    };

    const menuList = items.map((item) => (
        <li key={item.id}>{item.menu}</li>
    ));
    console.log(menuList);

    return (
        <div>
            <input value={inMenu} onChange={onch} />
            <button onClick={onck}>추가</button>
            <ul>{menuList}</ul>
        </div>
    );
};

export default CafeMenu;