import React from 'react';

const MyComponent = function(props) {
    return (
        <div>
            <h1>{props.title}</h1>
            <div>{props.writer}님이 만든 컴포넌트~</div>
            <p>내 차는 {props.car.model}이고,
            제조사는 {props.car.com}입니다.</p>
        </div>
    );
};

MyComponent.defaultProps = {
    writer: "사용자",
}

export default MyComponent;