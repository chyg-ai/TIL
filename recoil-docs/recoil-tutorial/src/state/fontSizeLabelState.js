import { selector } from "recoil";
import fontSizeState from "./fontSizeState";

const fontSizeLabelState = selector({
  key: "fontSizeLabelState",
  get: ({ get }) => {
    const fontSize = get(fontSizeState);
    const unit = "px";

    return `${fontSize}${unit}`;
  },
});

export default fontSizeLabelState;
