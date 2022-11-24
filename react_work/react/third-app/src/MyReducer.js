import React, { useReducer } from 'react';

function reducer(state, action){
    switch (action.type){
        case 'INC': // +1 버튼
            return {value: state.value + 1};
        case 'DEC': // -1 버튼
        return {value: state.value - 1};
        default:
            //아무것도 해당되지 않을 때 기존상태 반환
            return state;
    }
}

const MyReducer = () => {
    const [state, dispatch] = useReducer(reducer, {value: 0});

    return (
        <div>
            <h2>useReducer 연습</h2>
            <p>
                현재 카운터 값은 <b>{state.value}</b> 입니다
            </p>
            <button onClick={() => dispatch({type: 'INC'})}>+1</button>
            <button onClick={() => dispatch({type: 'DEC'})}>-1</button>
        </div>
    );
};

export default MyReducer;