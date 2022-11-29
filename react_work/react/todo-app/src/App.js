import { useCallback, useRef, useState } from 'react';
import './App.css';
import TodoInsert from './components/TodoInsert';
import TodoList from './components/TodoList';
import TodoTemplate from './components/TodoTemplate';

function App() {
  const [todos, setTodos] = useState([
    {
      id: 1,
      text: '리액트의 기초 알아보기',
      checked: true,
    },
    {
      id: 2,
      text: '컴포넌트 스타일링 해보기',
      checked: true,
    },
    {
      id: 3,
      text: '일정 관리 앱 만들기',
      checked: false,
    }
  ]);
  // 고유값(id) 처리는 ref 사용
  const nextId = useRef(4);

  // 새 항목의 입력 처리를 위한 insert 함수
  const onInsert = useCallback( text => {
    //새 일정이 입력되면 (+버튼 입력처리) 새 일정용 객체가 생성됨
      const todo = { // 새로운 일정
        id: nextId.current,
        text,
        checked: false,
      };
      //새 일정 객체를 기본 객체 목록 뒤에 붙여서 state를 업데이트
      // const newList = todos.concat(todo);
      // setTodos(newList);
      setTodos(todos.concat(todo));
      nextId.current += 1;
    }, [todos],
  );

    //삭제 처리 함수
    const onRemove = useCallback(id => {
      const afterList = todos.filter(todo => todo.id !== id);
      setTodos(afterList);
    },[todos]);
  
    //토글 처리 함수
    const onToggle = useCallback(id => {
      const toggleList = todos.map(todo => (
        todo.id === id ? {...todo, checked: !todo.checked} : todo
      ));
      console.log(toggleList);
      setTodos(toggleList);
    }, [todos]);

  return (
    <TodoTemplate>
      {/* 
        자식 컴포넌트에 state를 사용하는 함수를 전달하면
        자식 컴포넌트에서 부모 컴포넌트의 state 변경을 할 수 있다.
      */}
      <TodoInsert onInsert={onInsert}/>
      <TodoList todos={todos} onRemove={onRemove} onToggle={onToggle}/>
    </TodoTemplate>
  );
}

export default App;
