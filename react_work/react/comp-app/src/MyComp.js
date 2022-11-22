import React from 'react';
import PropTypes from "prop-types";


// const MyComp = (props) => {
    const MyComp = ({ name , fnum, children }) => {
    //미리 구조 분해 진행
    //const{ name , children } = props;
    return (
        <div>
            {/* props 없이 사용가능 */}
            {name}님이 만든 새 컴포넌트~
            <br/>
            {children}!!{fnum}
        </div>
    );
};

MyComp.propTypes = {
    name: PropTypes.string

}

export default MyComp;