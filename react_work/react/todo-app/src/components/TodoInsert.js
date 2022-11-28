import React, { useCallback, useState } from "react";
import {MdAdd} from "react-icons/md";
import "./TodoInsert.scss";


const TodoInsert = ({onInsert}) => {
    const [value, setValue] = useState("");

    const onch = useCallback(e => {
        setValue(e.target.value);
    }, []);

    const onSubmit = useCallback(e => {
        onInsert(value);
        setValue("");
        // onSubmit 이벤트는 새로고침 발생
        // 이를 방지하는 함수 preventDefault();
        e.preventDefault();
    }, [onInsert, value]);

    return (
        <form className="TodoInsert" onSubmit={onSubmit}>
            <input placeholder="할 일을 입력하세요" value={value} onChange={onch}/>
            <button type="submit">
                <MdAdd/>
            </button>
        </form>
    );
};

export default TodoInsert;