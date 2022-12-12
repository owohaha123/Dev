import axios from "axios";
import React, { useCallback, useState } from "react";
import { useNavigate } from "react-router-dom";
import Button from "./Button";
import "./Main.scss";
import "./Input.scss";
import "./Button.scss";
import "./Textarea.scss";

const Write = () => {
  const nav = useNavigate();
  const id = sessionStorage.getItem("mid");
  const [data, setData] = useState({
    btitle: "",
    bmid: id,
    bcontent: "",
  });

  //전송 데이터와 파일을 담을 멀티파트 폼 생성
  let formData = new FormData();
  const { btitle, bcontent } = data;

  //작성한 내용(글, 파일들) 전송 함수
  const onWrite = useCallback(
    (e) => {
      e.preventDefault();
      //console.log(data);
      //전송 시 파일 이외의 데이터를 폼데이터에 추가
      formData.append(
        "data",
        new Blob([JSON.stringify(data)], { type: "application/json" })
      );

      axios
        .post("/writeProc", formData, {
          headers: { "Content-Type": "multipart/form-data" },
        })
        .then((res) => {
          if (res.data === "ok") {
            alert("작성 성공");
            sessionStorage.removeItem("pageNum");
            nav("/main");
          } else {
            alert("작성 실패");
            //formData = new FormData();
          }
        })
        .catch((error) => console.log(error));
    },
    [data]
  );
  const onChange = useCallback(
    (e) => {
      const dataObj = {
        ...data,
        [e.target.name]: e.target.value,
      };
      //console.log(dataObj);
      setData(dataObj);
    },
    [data]
  );
  //console.log(data);
  //파일 선택 시 폼데이터에 파일 목록 추가(다중파일)
  const onFileChange = useCallback(
    (e) => {
      const files = e.target.files;
      //console.log(files);
      for (let i = 0; i < files.length; i++) {
        formData.append("files", files[i]);
      }
    },
    [formData]
  );

  return (
    <div className="Main">
      <form className="Content" onSubmit={onWrite}>
        <h1>Board Write</h1>
        <input
          className="Input"
          name="btitle"
          value={btitle}
          placeholder="제목"
          onChange={onChange}
          autoFocus
          required
        />
        <textarea
          className="Textarea"
          name="bcontent"
          onChange={onChange}
          placeholder="게시글을 작성하세요."
          value={bcontent}
        ></textarea>
        <input type="file" name="files" onChange={onFileChange} multiple />
        <div className="Buttons">
          <Button wsize="s-10" color="gray" outline onClick={() => nav(-1)}>
            B
          </Button>
          <Button type="submit" wsize="s-30">
            WRITE
          </Button>
        </div>
      </form>
    </div>
  );
};

export default Write;
