import React, { useState } from "react";
import { useSetRecoilState } from "recoil";
import todoListState from "../state/todoListState";

const TodoItemCreator = () => {
  const [inputValue, setInputValue] = useState("");
  const setTodoList = useSetRecoilState(todoListState);

  const addItem = () => {
    setTodoList((oldTodoList) => [
      ...oldTodoList, // 이전 상태 값 유지
      {
        // 새로운 항목 추가
        id: getId(),
        text: inputValue,
        isComplete: false,
      },
    ]);
    setInputValue("");
  };

  const onChange = ({ target: { value } }) => {
    setInputValue(value);
  };

  return (
    <div>
      <input type="text" value={inputValue} onChange={onChange} />
      <button onClick={addItem}>Add</button>
    </div>
  );
};

let id = 0;
function getId() {
  return id++;
}

export default TodoItemCreator;
