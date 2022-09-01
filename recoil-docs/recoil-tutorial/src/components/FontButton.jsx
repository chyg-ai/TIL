import React, { useEffect } from "react";
import { useRecoilState, useRecoilValue } from "recoil";
import fontSizeLabelState from "../state/fontSizeLabelState";
import fontSizeState from "../state/fontSizeState";

const FontButton = () => {
  const [fontSize, setFontSize] = useRecoilState(fontSizeState);
  const fontSizeLabel = useRecoilValue(fontSizeLabelState);

  useEffect(() => {
    console.log("FontButton rendered!!");
  }, [fontSize]);

  return (
    <>
      <div>Current font size: {fontSizeLabel}</div>
      <button
        onClick={() => setFontSize((size) => size + 1)}
        style={{ fontSize }}
      >
        Click to Enlarge
      </button>
    </>
  );
};

export default FontButton;
