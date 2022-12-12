import axios from "axios";
import moment from "moment";
import React, { useCallback, useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Button from "./Button";

const df = (date) => moment(date).format("YYYY-MM-DD HH:mm:ss");

const Board = () => {
  const nav = useNavigate();
  const [board, setBoard] = useState({});
  const [flist, setFlist] = useState([
    {
      bfnum: 0,
      bfbid: 0,
      bfsysname: "",
      bforiname: "Nothing",
      image: "",
    },
  ]);
  useEffect(() => {
    const bn = localStorage.getItem("bnum");

    axios
      .get("/getBoard", { params: { bnum: bn } })
      .then((res) => {
        //console.log(res.data);
        setBoard(res.data);

        if (res.data.bfList.length > 0) {
          let newFileList = [];
          for (let i = 0; i < res.data.bfList.length; i++) {
            const newFile = {
              ...res.data.bfList[i],
              image: "upload/" + res.data.bfList[i].bfsysname,
            };
            //console.log(newFile);
            newFileList.push(newFile);
          }
          //console.log(newFileList);
          setFlist(newFileList);
        }
      })
      .catch((err) => console.log(err));
  }, []);

  //파일 이름 처리
  const extractDownloadFilename = (data) => {
    const disposition = data.headers["content-disposition"];
    const fileName = decodeURI(
      disposition
        .match(/filename[^;=\n]*=((['"]).*?\2|[^;\n]*)/)[1]
        .replace(/['"]/g, "")
    );
    return fileName;
  };

  //파일 다운로드 처리함수
  const onDown = useCallback((v) => {
    //console.log(v);
    if (v.bforiname === "Nothing") {
      return;
    }

    axios
      .get("/download", {
        params: { bfsysname: v.bfsysname, bforiname: v.bforiname },
        responseType: "blob",
      })
      .then((res) => {
        const blob = new Blob([res.data]);

        const fileObjectUrl = window.URL.createObjectURL(blob);

        const link = document.createElement("a");
        link.href = fileObjectUrl;
        link.style.display = "none";

        link.download = extractDownloadFilename(res);

        document.body.appendChild(link);
        link.click();
        link.remove();

        // 다운로드가 끝난 리소스(객체 URL) 해제
        window.URL.revokeObjectURL(fileObjectUrl);
      })
      .catch((err) => console.log(err));
  }, []);

  const viewFlist = flist.map((v, i) => {
    //console.log(v);
    return (
      <div className="Down" key={i} onClick={() => onDown(v)}>
        {v.image && <img src={v.image} alt="preview-img" />}
        {v.bforiname}
      </div>
    );
  });
  //console.log(viewFlist);

  return (
    <div className="Main">
      <div className="Content">
        <h1>{board.btitle}</h1>
        <div className="DataArea">
          <div className="Box">
            <div className="Title">NO</div>
            <div className="Data">{board.bnum}</div>
          </div>
          <div className="Box">
            <div className="Title">Writer</div>
            <div className="Data">{board.bmid}</div>
          </div>
          <div className="Box">
            <div className="Title">Registry</div>
            <div className="Data">{df(board.rdate)}</div>
          </div>
          <div className="Box">
            <div className="FileTitle">File</div>
            <div className="FileData">{viewFlist}</div>
          </div>
          <div className="Cont">{board.bcontent}</div>
        </div>
        <div className="Buttons">
          <Button wsize="s-10" color="gray" onClick={() => nav(-1)}>
            B
          </Button>
        </div>
      </div>
    </div>
  );
};

export default Board;
