import React from "react";
import "./Table.scss";

const Table = ({ hName, children }) => {
  return (
    <table className="Table">
      <thead>
        <tr>
          {hName.map((item, index) => {
            return (
              <th className="TableHeader" key={index}>
                {item}
              </th>
            );
          })}
        </tr>
      </thead>
      <tbody>{children}</tbody>
    </table>
  );
};

export default Table;
