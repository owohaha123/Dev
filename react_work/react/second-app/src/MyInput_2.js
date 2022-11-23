import React, { useState } from 'react';

const MyInput_2 = () => {
    //두 입력값을 함께 저장하는 state
    const [form, setForm] = useState({
        uname: "",
        msg: "",
    });
    //uname과 msg가 개별적으로 사용될 때는 구조 분해 할당
    const { uname, msg } = form;

    const onch = (e) => {
      const newForm = {
        ...form, //기존 form의 내용이 그대로 복제
        [e.target.name]: e.target.value,
        //입력이 들어온 input 요소의 value를 변경하는 코드
      };
      setForm(newForm);
    };
    const onck = () => {
      alert(`name : ${uname}, msg : ${msg}`);
      setForm({
        uname: "",
        msg: "",
      });
    };  

    return (
        <div>
        <h2>이벤트 연습2</h2>
        <input
          type="text"
          name="uname"
          placeholder="사용자 이름"
          value={uname}
          onChange={onch}
        />
        <input
          type="text"
          name="msg"
          placeholder="아무거나 입력"
          value={msg}
          onChange={onch}
        />
        <button onClick={onck}>확인</button>
      </div>
    );
};

export default MyInput_2;