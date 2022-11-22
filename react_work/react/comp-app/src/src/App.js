import logo from './logo.svg';
import './App.css';
import MyComponent from './MyComponent';
import Header from './Header';
import MyComp from './MyComp';

function App() {
  const MyCar = { model : "올랜도", com: "쉐보레"};
  return (
    <>
    <Header logo="My App">Header 입니다.</Header>
    <MyComponent title="App에서 보낸 값~" writer="홍길동" car={MyCar}/>
    {/* <MyComponent title="App에서 보낸 값~"/> */}
    <MyComp name="아무개" fnum={5}>내용입니당~</MyComp>
    </>
  )
}

export default App;
