import React from "react";
import "./Home.scss";
import logo from "../logo.svg";

const Home = () => {
  return (
    <div className="Home">
      <div className="Content">
        <h1>Home</h1>
        <img className="App-logo" src={logo} alt="logo" />
      </div>
    </div>
  );
};

export default Home;
