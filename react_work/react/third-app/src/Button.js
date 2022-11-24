import React from 'react';
import styled, { css } from 'styled-components';

const MyButton = styled.button`
    border: 1px solid white;
    border-radius: 5px;
    font-size: 16px;
    background: ${(props)=> props.bg || "purple"};
    color: ${(props)=> props.color || "white"};
    
    ${(props) => props.pri && css`
        color: white;
        background: skyblue;
        border: 1px solid white;
    `}

    ${(props) => props.sec && css`
        background: pink;
        border: 1px solid pink;
    `}
`;

// const Button = ({color, bg, children, pri }) => {
    const Button = ({children, ...props }) => {
    return (
        <div>
            {/* <h2>Styled-components</h2> */}
            {/* <MyButton color={color} bg={bg} pri={pri}>{children}</MyButton> */}
            <MyButton {...props}>{children}</MyButton>
        </div>    
    );
};

export default Button;