import React from 'react';
import "./App.css";

//const MyComp = ({book: b, data, children, isAdmin}) => {
const MyComp = ({book: b, data, ...props}) => {    
    const pStyle = {
        color: "purple",
        fontSize: "20px"
    };

    return (
        <div>
            <h2 className="MyComp-style">{b}</h2>
            <p style={pStyle}>{data}</p>
            <p>{props.children}</p>
            <p>{props.isAdmin === "true" && "관리합니다."}</p>
        </div>
    );
};

export default MyComp;