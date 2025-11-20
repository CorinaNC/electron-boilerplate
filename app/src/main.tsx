import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./index.css";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Layout from "./components/Layout.tsx";
import Work from "./pages/Work.tsx";
import Main from "./pages/Main.tsx";
import { ChakraProvider } from "@chakra-ui/react";
import { extendTheme } from "@chakra-ui/react";

// define global styles here :) 
const theme = extendTheme({
  styles: {
    global: {
      // global theme shit lol
      body: {
        bg: "tan",
        minHeight: '100vh'
      },
    },
  },
});

createRoot(document.getElementById("root")!).render(
  <StrictMode>
    <ChakraProvider theme={theme}>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Layout />}>
            <Route path="/" element={<Main />} />
            <Route path="/home" element={<Main />} />
            <Route path="/work" element={<Work />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </ChakraProvider>
  </StrictMode>
);
