import classNames from "classnames";
import React from "react";

const TableColumn = ({ children, span, wd }) => {
  return (
    <td className={classNames("TableColumn", wd)} colSpan={span}>
      {children}
    </td>
  );
};

export default TableColumn;
