import React, { useCallback, useState } from "react";
import "./Join.scss";
import "./Input.scss";
import "./Button.scss";
import Button from "./Button";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const Join = () => {
  const nav = useNavigate();
  const [form, setForm] = useState({
    mid: "",
    mpwd: "",
    mname: "",
    mphone: "",
  });
  const { mid, mpwd, mname, mphone } = form;

  const idCheck = () => {
    if (mid === "") {
      alert("아이디를 입력하세요.");
      return;
    }
  };
  const sendJoin = (e) => {
    e.preventDefault();

    axios
      .post("/joinProc", form)
      .then((res) => {
        if (res.data === "Ok") {
          alert("가입 성공");
          nav("/login");
        }
      })
      .catch((error) => console.log(error));
  };
  const onChange = useCallback(
    (e) => {
      const formObj = {
        ...form,
        [e.target.name]: e.target.value,
      };
      setForm(formObj);
    },
    [form]
  );

  return (
    <div className="Join">
      <form className="Content" onSubmit={sendJoin}>
        <h1>회원 가입</h1>

        <input
          className="Input"
          name="mid"
          value={mid}
          placeholder="아이디"
          onChange={onChange}
          autoFocus
          required
        />
        <Button outline onClick={idCheck}>
          중복확인
        </Button>
        <input
          type="password"
          className="Input"
          name="mpwd"
          value={mpwd}
          placeholder="비밀번호"
          onChange={onChange}
          required
        />
        <input
          className="Input"
          name="mname"
          value={mname}
          placeholder="이름"
          onChange={onChange}
          required
        />
        <input
          className="Input"
          name="mphone"
          value={mphone}
          placeholder="연락처"
          onChange={onChange}
          required
        />
        <Button type="submit" size="large">
          가입
        </Button>
      </form>
    </div>
  );
};

export default Join;
