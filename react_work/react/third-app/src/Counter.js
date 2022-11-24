import React, { useEffect, useState } from 'react';

const Counter = () => {
    // '+' 버튼을 누르면 Count가 올라가고, *2 한 값 출력
    const [count, setCount] = useState(0);
    const [cal, setCal] = useState(0);

    useEffect(() => {
        setCal(() => count * 2);
    }, [count])

    return (
        <div>
            <h2>useEffect 조건부 실행</h2>
            <p>Count: {count}</p>
            <button onClick={() => setCount((c => c+1))}>+</button>
            <p>X 2 결과 : {cal}</p>
        </div>
    );
};

export default Counter;