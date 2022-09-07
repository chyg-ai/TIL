import React from "react";
import { RecoilRoot } from "recoil";
import CurrentUserInfo from "./components/CurrentUserInfo";

const MyApp = () => {
  return (
    <RecoilRoot>
      <ErrorBoundary>
        <React.Suspense fallback={<div>Loading...</div>}>
          <CurrentUserInfo />
        </React.Suspense>
      </ErrorBoundary>
    </RecoilRoot>
  );
};

export default MyApp;
