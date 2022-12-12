import "./App.scss";
import { Route, Routes, useNavigate } from "react-router-dom";
import Header from "./components/Header";
import { useCallback, useEffect, useState } from "react";
import Home from "./components/Home";
import Footer from "./components/Footer";
import Join from "./components/Join";
import Login from "./components/Login";
import Main from "./components/Main";
import Write from "./components/Write";
import Board from "./components/Board";

function App() {
  const nav = useNavigate();

  //로그인 상태 저장
  const [lstate, setLstate] = useState({
    logid: "",
    flink: "/login",
  });

  useEffect(() => {
    //세션에 저장된 로그인 아이디를 가져옴(로그인 상태 유지)
    const mid = sessionStorage.getItem("mid");
    //console.log(mid);
    if (mid !== null) {
      const newState = {
        logid: mid,
        flink: "/main",
      };
      setLstate(newState);
    }
  }, []);

  //로그인 성공 시 로그인 상태 변경 함수
  const sucLogin = useCallback((mid) => {
    const newState = {
      logid: mid,
      flink: "/main",
    };
    setLstate(newState);
  }, []);

  //로그아웃함수
  const onLogout = () => {
    alert("로그아웃");
    const newState = {
      logid: "",
      flink: "/login",
    };
    setLstate(newState);
    //로그아웃 시 로그인 상태 및 페이지번호 삭제
    sessionStorage.removeItem("mid");
    sessionStorage.removeItem("pageNum");
    nav("/"); //첫페이지로 돌아감.
  };

  return (
    <div className="App">
      <Header lstate={lstate} onLogout={onLogout} />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login sucLogin={sucLogin} />} />
        <Route path="/join" element={<Join />} />
        <Route path="/main" element={<Main />} />
        <Route path="/write" element={<Write />} />
        <Route path="/board" element={<Board />} />
      </Routes>
      <Footer />
    </div>
  );
}

export default App;
