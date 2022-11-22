import logo from './logo.svg';
import './App.css';

function App() {
  const name = "홍길동";
  let name2 = "리액트";
  const myStyle = {
    backgroundColor: 'pink',
    color: 'white'
  }
  const myH3Style = {
    backgroundColor: 'skyblue',
    color: 'white'
  }
  
  return (
    <div className="App">
      <h1 style={myStyle}>처음 해보는 리액트</h1>  
      <>
      <h3>1. 감싸인 요소</h3>
      <p>하나의 부모 태그로 감싸서 쓰기 (일반적으로는 div 사용)</p>
      <p>아니면 태그명 빼고 묶어도 됨</p>
      </>
      <br/>
      <h3>2. 자바스크립트 표현식 사용</h3>
      <p>{name}님 반갑습니다.</p>
      <br/>
      <h3>3. if문 사용 불가(조건연산자 사용)</h3>
      {
      (name2 === "리액트") ?
      (<h4>리액트 입니다~</h4>) : (<h4>{name}</h4>)
      }
      <br/>
      <h3>4. 조건부 렌더링 (&& 활용)</h3>
      {
      (name2 === "리액트")&&(<h4>리액트 입니다~</h4>)
      }
      <br/>
      <h3>5. undefined 랜더링 처리 (|| 활용)</h3>
      <h4>{name || 'Guest'}</h4>
      <br/>
      <h3 style={myH3Style}>6. 인라인 스타일링</h3>
      <br/>
      <h3>7. class 대신 className 사용</h3>
      <p>기본 설정인 className(App)지우면 기본 css 반영 안 됨</p>
      <br/>
      <h3>8. 닫는 태그가 없던 요소에도 닫는 태그 사용</h3>
      <p>예_input, br 등</p>
      <p>또는 단축 태그 사용 (input/)</p>
      <br/>
      <h3>9. 주석</h3>
      {/*주석주석*/}
    </div>
  );
};

export default App;
