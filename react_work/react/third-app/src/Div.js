import React from 'react';
import styled from 'styled-components';

const StyledDiv = styled.div`
    width: 200px;
    border: 1px dashed skyblue;
    border-radius: 5px;
    background: skyblue;
    color: white;
`;

const Div = ({children}) => {
    return (
        <StyledDiv>{children}</StyledDiv>
    );
};

export default Div;