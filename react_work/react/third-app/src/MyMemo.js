import React, { useCallback, useMemo, useState } from 'react';

const getAverage = numbers => {
    //값이 쓰일 때마다 log가 찍힘
    console.log("평균값 계산중...");
    if(numbers.length === 0){
        return 0;
    }
    const sum = numbers.reduce((a,b) => a + b);
    return sum / numbers.length;
}

const MyMemo = () => {
    const [number, setNumber] = useState("");
    const [list, setList] = useState([]);
    // 입력 태그 onChange 이벤트 처리
    const onch = e => {
        setNumber(e.target.value);
    };

    // useCallback : 최적화
    const onck = useCallback (e => {
        const newList = list.concat(parseInt(number));
        setList(newList);
        setNumber("");
    }, [number, list]);//number나 list가 변경될 때만 실행

    // useMemo 활용
    // list에 새로운 값이 추가될 때만 log 찍히게 정리
    const avg = useMemo(() => getAverage(list), [list])

    return (
        <div>
            <h2>UseMemo</h2>
            <input value={number} onChange={onch}/>
            <button onClick={onck}>등록</button>
            <ul>
                {list.map((value, index) => (
                    <li key={index}>{value}</li>
                ))}
            </ul>
            <div>
                {/* <b>평균값:</b> {getAverage(list)} */}
                <b>평균값:</b> {avg}
            </div>
        </div>
    );
};

export default MyMemo;