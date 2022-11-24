import React, { useEffect, useState } from 'react';

const Timer = () => {
    const [count, setCount] = useState(0);

    useEffect(() => {
        let tr = setTimeout(() => {
            setCount((count) => count + 1);
        }, 1000);

        //cleanup 함수
        return(() => clearTimeout(tr));
    }, []);

    return (
        <div>
            <h2>cleanup(뒷처리 함수)</h2>
            <h4>랜더링 횟수 : {count}번</h4> 
        </div>
    );
};

export default Timer;