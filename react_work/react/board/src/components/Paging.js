import React, { useCallback } from "react";
import "./Paging.scss";
import classNames from "classnames";

const Paging = ({ page, getList }) => {
  const { totalPage, pageNum } = page;
  const pageCnt = 5;

  let curGroup = Math.floor(
    pageNum % pageCnt > 0 ? pageNum / pageCnt + 1 : pageNum / pageCnt
  );
  let start = curGroup * pageCnt - (pageCnt - 1);
  let end = curGroup * pageCnt >= totalPage ? totalPage : curGroup * pageCnt;
  let makePage = totalPage > end ? pageCnt : totalPage - start + 1;

  //const arr = new Array(makePage);
  //console.log(totalPage);
  //console.log(makePage);
  if (makePage < 0) {
    makePage = 1;
  }

  //페이지 번호 생성
  const pageList = new Array(makePage).fill().map((_, i) => {
    if (i + start === pageNum) {
      return (
        <div className={classNames("Number", "cur")} key={i + start}>
          {i + start}
        </div>
      );
    } else {
      return (
        <div
          className="Number"
          key={i + start}
          onClick={() => onClick(i + start)}
        >
          {i + start}
        </div>
      );
    }
  });

  //console.log("start:" + start, "end:" + end, "curGroup:" + curGroup);
  //'이전' 버튼 생성
  if (start !== 1) {
    pageList.unshift(
      <div
        className="Number"
        key={start - 1}
        onClick={() => onClick(start - 1)}
      >
        &lt;
      </div>
    );
  }

  //'다음' 버튼 생성
  if (end !== totalPage) {
    pageList.push(
      <div className="Number" key={end + 1} onClick={() => onClick(end + 1)}>
        &gt;
      </div>
    );
  }
  const onClick = useCallback((index) => {
    getList(index);
  }, []);

  return <div className="Paging">{pageList}</div>;
};

export default Paging;
