import React, { useRef } from 'react';

const MyRef = () => {
    const inRef = useRef(null);

    const handleFocus = () => {
        inRef.current.disabled = false;
        inRef.current.focus();
    }

    const handleReset = () => {
        inRef.current.disabled = true;
        inRef.current.value = "";
    }
    return (
        <div>
            <h2>useRef</h2>
            <input disabled type="text" ref={inRef}/>
            <button onClick={handleFocus}>활성화</button>
            <button onClick={handleReset}>초기화</button>
        </div>
    );
};

export default MyRef;