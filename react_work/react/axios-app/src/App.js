import axios from 'axios';
import { useState } from 'react';
import './App.css';

function App() {
  const [data, setData] = useState("");
  const [objdata, setObjdata] = useState("");
  const [list, setList] = useState("");

  const onck1 = () => {
    axios.get("/getData")
    .then(response => {
      console.log(response.data);
      setData(response.data);
    })
    .catch(error => console.log(error));
  };

  const onck2 = () => {
    axios.get("/getObject")
    .then(res => {
      console.log(res);
      const {data} = res;//객체 분해
      //분해하여 꺼내온 data의 str과 number를 사용->문자열생성
      setObjdata(`${data.str}, ${data.number}`);
    })
    .catch(error => console.log(error));
  };

  const onck3 = () => {
    axios.get("/getList")
    .then(res => {
      console.log(res.data);
      const {data} = res;
      const listItems = data.map(d => 
        <li key={d.number}>{d.str}, {d.number}</li>
      );
      console.log(listItems);
      setList(listItems);
    })
    
    .catch(error => console.log(error));
  };


  return (
    <div className="App">
      <button onClick={onck1}>문자열</button>
      <span>{data}</span><br/>
      <button onClick={onck2}>객체</button>
      <span>{objdata}</span><br/>
      <button onClick={onck3}>목록</button>
      <ul>{list}</ul>
    </div>
  );
}

export default App;
