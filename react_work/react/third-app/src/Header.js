import React from 'react';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faHouse } from "@fortawesome/free-solid-svg-icons";
import styled, { css } from 'styled-components';

const HeaderBar = styled.div`
  backgroundColor: "pink";
  color: "white";
  padding: "10px";
  margin: "0";
  height: "50px";
  lineHeight: "50px";
`;
const HeaderContent = styled.div`
  width: "800px";
  margin: "0 auto";
  display: "flex";
  justifyContent: "space-between";
`;
const HeaderTitle = styled.p`
  margin: "0"
`;

const Header = ({children, ...props}) => {
      const HeaderTitle = {
        margin: "0",
      };
      const MenuItem = {
        margin: "0 10px",
        cursor: "pointer",
      };
      const IconStyle = {
        marginTop: "10px",
      };
    

    return (
      <HeaderBar>
        <HeaderContent>
          <FontAwesomeIcon icon={faHouse} size="2x" style={IconStyle} />
          <HeaderTitle>{props.title}</HeaderTitle>
        </HeaderContent>
        </HeaderBar>
        // <div style={HeaderBar}>
        //     <div style={HeaderContent}>
        //         <FontAwesomeIcon icon={faHouse} size="2x" style={IconStyle} />
        //         <h1 style={HeaderTitle}>{props.title}</h1>
        //         <div>
        //             <span style={MenuItem}>{props.nav.home}</span>
        //             <span style={MenuItem}>{props.nav.menu1}</span>
        //             <span style={MenuItem}>{props.nav.menu2}</span>
        //         </div>
        //     </div>   
        // </div>
    );
};

export default Header;