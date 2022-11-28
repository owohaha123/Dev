import classNames from 'classnames';
import React from 'react';
import "./Button.scss";

const Button = ({children, size , color, outline}) => {
    return (
            // <button className={`Button ${size}`}>
            <button className={classNames('Button', size, color, {outline})}>
                {children}
            </button>
    );
};

Button.defaultProps = {
    size: "medium",
    color: "blue"
}

export default Button;