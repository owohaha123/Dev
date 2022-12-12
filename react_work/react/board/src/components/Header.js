import { faHouse } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import React from "react";
import { Link } from "react-router-dom";
import "./Header.scss";

const Header = ({ lstate, onLogout }) => {
  const { logid, flink } = lstate;
  //로고 클릭(로그인 후 main, 로그인 전 home)
  const homeLink = logid === "" ? "/" : "/main";

  return (
    <div className="Header">
      <div className="Content">
        <Link to={homeLink}>
          <FontAwesomeIcon icon={faHouse} size="2x" className="IconStyle" />
        </Link>
        <div className="Title">JS Board</div>
        <div className="Menu">
          <div className="Item">
            <Link to={flink}>{logid !== "" ? `${logid}님` : "Login"}</Link>
          </div>
          <div className="Item">
            {logid !== "" ? (
              <span onClick={onLogout}>Logout</span>
            ) : (
              <Link to="/join">join</Link>
            )}
          </div>
        </div>
      </div>
    </div>
  );
};

export default Header;
