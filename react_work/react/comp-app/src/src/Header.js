// 단축키 rsc 사용하여 화살표 함수형 component 작성 가능
import React from 'react';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import {faHeart} from '@fortawesome/free-solid-svg-icons';
// import MyComponent from './MyComponent';

const Header = function(props) {
    const HeaderLogo = {
        fontSize: "50px",
        backgroundColor: "skyblue",
        color: "white"
    }
    const HeaderText = {
        display : "inline",
    }
    return (
        <div>
            <h1 style={HeaderLogo}>{props.logo}</h1>
            <FontAwesomeIcon icon={faHeart}/>
            <div style={HeaderText}>{props.children}</div>
            {/* <MyComponent/>import 가능 */}
        </div>
    );
};

export default Header;