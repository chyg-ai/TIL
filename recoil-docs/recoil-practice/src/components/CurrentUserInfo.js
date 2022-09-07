import React from "react";
import { useRecoilValue } from "recoil";
import currentUserNameQuery from "../state/currentUserNameQuery";

const CurrentUserInfo = () => {
  const userName = useRecoilValue(currentUserNameQuery);
  return <div>{userName}</div>;
};

export default CurrentUserInfo;
