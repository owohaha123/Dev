import logo from './logo.svg';
import './App.css';
import MyComp from './MyComp';
import Header from './Header';
import MyEvent from './MyEvent';
import MyInput_1 from "./MyInput_1";
import MyInput_2 from "./MyInput_2";
import MyList from './MyList';
import CafeMenu from './CafeMenu';


function App() {
  const menu = {
    home: "home",
    menu1: "login",
    menu2: "join",
  };

  return (
    <div className="App">
      <Header title="My Home" nav={menu} />
      <MyComp book="리액트" data="보낸데이터" isAdmin="true">
        children을 통해서 보낸 데이터
      </MyComp>
      <br/>
      <MyEvent/>
      <br/>
      <MyInput_1/>
      <br/>
      <MyInput_2/>
      <br/>
      <MyList/>
      <br/>
      <CafeMenu/>
    </div>
  );
}

export default App;
