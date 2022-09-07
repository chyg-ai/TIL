import React, { Component } from "react";
// import "./index.css";
import App from "./App";
import Login from "./Login";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";

function Copyright() {
  return (
    <Typography variant="body2" color="textSecondary" align="center">
      {"Copyright "}
      fsoftwareengineer, {new Date().getFullYear()}
      {"."}
    </Typography>
  );
}
class AppRouter extends Component {
  render() {
    return (
      <div>
        <BrowserRouter>
          <div>
            <Routes>
              <Route path="/login" element={<Login />} />
              <Route path="/" element={<App />} />
            </Routes>
          </div>
          <Box mt={5}>
            <Copyright />
          </Box>
        </BrowserRouter>
      </div>
    );
  }
}

export default AppRouter;
