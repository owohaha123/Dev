import React from 'react';

const MyList = () => {
    const menus = ["아메리카노", "카페라떼", "카페모카", "카푸치노", "딸기라떼"];
    const menuList = menus.map((menu, index) => <li key={index}>{menu}</li>);
    console.log(menuList);

    return (
        <ul>{menuList}</ul>
    );
};

export default MyList

