import React, { useEffect } from "react";
import { useRecoilState } from "recoil";
import fontSizeState from "../state/fontSizeState";

const Text = () => {
  const [fontSize, setFontSize] = useRecoilState(fontSizeState);
  useEffect(() => {
    console.log("Text rendered!!");
  }, [fontSize]);

  return <p style={{ fontSize }}>This text will increase in size too.</p>;
};

export default Text;
