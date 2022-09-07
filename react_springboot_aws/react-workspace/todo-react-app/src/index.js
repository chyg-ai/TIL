import React from "react";
import ReactDOM from "react-dom/client";
import AppRouter from "./AppRouter";

const root = ReactDOM.createRoot(document.getElementById("root")); // 루트 엘리먼트 지정
// 루트 엘리먼트에 컴포넌트 추가
root.render(<AppRouter />);
