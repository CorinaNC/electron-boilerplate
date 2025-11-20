import { Heading, Box } from "@chakra-ui/react";
// @ts-ignore
import WebCam from "../components/WebCam.jsx";

const Main = () => {
  return (
    <Box>
      <Heading>The Main Page</Heading>
      <WebCam />
    </Box>
  );
};

export default Main;
