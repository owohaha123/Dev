import axios from "axios";
import moment from "moment";
import React, { useCallback, useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Button from "./Button";
import "./Main.scss";
import Paging from "./Paging";
import Table from "./Table";
import TableColumn from "./TableColumn";
import TableRow from "./TableRow";

const df = (date) => moment(date).format("YYYY-MM-DD HH:mm:ss");

const Main = () => {
  const nav = useNavigate();
  const mid = sessionStorage.getItem("mid");
  let pnum = sessionStorage.getItem("pageNum");
  const [bitem, setBitem] = useState({});
  const [page, setPage] = useState({
    totalPage: 0,
    pageNum: 1,
  });

  //게시글 목록을 서버로부터 가져오는 함수
  const getList = (pnum) => {
    axios
      .get("/list", { params: { pageNum: pnum } })
      .then((res) => {
        //console.log(res.data);
        const { bList, totalPage, pageNum } = res.data;
        setPage({ totalPage: totalPage, pageNum: pageNum });
        //console.log(totalPage);
        setBitem(bList);
        sessionStorage.setItem("pageNum", pageNum);
      })
      .catch((err) => console.log(err));
  };

  const getBoard = useCallback((bnum) => {
    //보여질 게시글 번호를 localStorage에 저장(글번호 유지를 위해)
    localStorage.setItem("bnum", bnum);
    nav("/board");
  }, []);

  //main 페이지가 화면에 보일 때 서버로부터 게시글 목록을 가져온다.
  useEffect(() => {
    if (mid === null) {
      nav("/", { replace: true });
      return;
    }
    pnum !== null ? getList(pnum) : getList(1);
  }, []);

  //출력할 게시글 목록 작성
  let list = null;
  if (bitem.length === 0) {
    list = (
      <TableRow key={0}>
        <TableColumn span={4}>게시글이 없습니다.</TableColumn>
      </TableRow>
    );
  } else {
    list = Object.values(bitem).map((item) => (
      <TableRow key={item.bnum}>
        <TableColumn wd="w-10">{item.bnum}</TableColumn>
        <TableColumn wd="w-40">
          <div onClick={() => getBoard(item.bnum)}>{item.btitle}</div>
        </TableColumn>
        <TableColumn wd="w-20">{item.bmid}</TableColumn>
        <TableColumn wd="w-30">{df(item.rdate)}</TableColumn>
      </TableRow>
    ));
  }

  //글쓰기 화면으로 이동
  const onWrite = () => {
    nav("/write");
  };

  return (
    <div className="Main">
      <div className="Content">
        <h1>Board List</h1>
        <Table hName={["NO", "Title", "Writer", "Date"]}>{list}</Table>
        <Paging page={page} getList={getList} />
        <Button wsize="s-30" onClick={onWrite}>
          Write
        </Button>
      </div>
    </div>
  );
};

export default Main;
