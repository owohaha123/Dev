import React, { useState } from 'react';

const MyInput_1 = () => {
    //사용자 이름을 처리하는 useState
    const [username, setUsername] = useState("");
    //메시지를 처리하는 useState
    const [msg, setMsg] = useState("");

    const chName = e1 => setUsername(e1.target.value);
    const chMsg = (e2) => setMsg(e2.target.value);
    const onck = () => {
        //데이터 사용
        alert(`이름: ${username},  메시지: ${msg}`);
        //데이터 사용 후 초기화
        setUsername("");
        setMsg("");
      };

    return (
        <div>
        <h2>이벤트 연습</h2>
        <input
          type="text"
          name="username"
          placeholder="사용자 이름"
          value={username}
          onChange={chName}
        />
        <input
          type="text"
          name="msg"
          placeholder="아무거나 입력"
          value={msg}
          onChange={chMsg}
        />
        <button onClick={onck}>확인</button>
      </div>
    );
};

export default MyInput_1;