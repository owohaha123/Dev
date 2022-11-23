import React, { useState } from "react";


const MyEvent = () => {
  const [name, setName] = useState("");
  const shoot = (msg) => {
    //alert(`${msg} 고~~~~~올!!`);
    let n = prompt("누구 골?");
    setName(n);
  };
  return (
    <>
      <h2>useState 써보기~</h2>
      <button onClick={() => shoot("1")}>슛!</button>
      <p>{name}</p>
    </>
  );
};

export default MyEvent;
