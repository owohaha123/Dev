import logo from './logo.svg';
import './App.css';
import MyEffect from './MyEffect';
import Counter from './Counter';
import Timer from './Timer';
import MyReducer from './MyReducer';
import MyMemo from './MyMemo';
import MyRef from './MyRef';
import Button from './Button';
import Div from './Div';
import Header from './Header';

function App() {
  const menu = {
    home: "home",
    menu1: "login",
    menu2: "join",
  };

  return (
    <div className="App">
      {/* <Header title="My Home" nav={menu} /> */}
      <Header/>
      <MyEffect/>
      <br/>
      <Counter/>
      <br/>
      <Timer/>
      <br/>
      <MyReducer/>
      <br/>
      <MyMemo/>
      <br/>
      <MyRef/>
      <br/>
      <Div>
      <h2>Styled-components</h2>  
      <Button>기본버튼</Button>
      <Button color="red">빨간버튼</Button>
      <Button color="black" bg="gray">회색버튼</Button>
      <Button pri>pri버튼</Button>
      <Button sec>sec버튼</Button>
      </Div>
    </div>
  );
}

export default App;
