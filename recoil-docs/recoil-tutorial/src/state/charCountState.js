import { selector } from "recoil";
import textState from "./textState";

const charCountState = selector({
  key: "charCountState",
  get: ({ get }) => {
    const text = get(textState); // atom as input
    return text.length; // selector output
  },
});

export default charCountState;
