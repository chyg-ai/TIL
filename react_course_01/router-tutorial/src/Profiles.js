import React from "react";
import { Link, Routes, Route } from "react-router-dom";
import Profile from "./Profile";
import WithRouterSample from "./WithRouterSample";

const Profiles = () => {
  return (
    <div>
      <h3>사용자 목록:</h3>
      <ul>
        <li>
          <Link to="/profiles/velopert">velopert</Link>
        </li>
        <li>
          <Link to="/profiles/gildong">gildong</Link>
        </li>
      </ul>

      <Routes>
        <Route
          path="/profiles"
          render={() => <div>사용자를 선택해 주세요.</div>}
        />
        <Route path="/profiles/:username" element={<Profile />} />
      </Routes>

      <WithRouterSample />
    </div>
  );
};

export default Profiles;
