import { Outlet } from "react-router-dom";
import { Box, HStack, Link, List, ListItem } from "@chakra-ui/react";
const Layout = () => {
  return (
    <Box>
      <HStack pt="0.5rem" pl="0.5rem">
        <Link href="/work">Work</Link>
        <Link href="/home">Home</Link>
      </HStack>
      {/* <Outlet /> is needed to provide nested routes inside of x route */}
      <Outlet />
    </Box>
  );
};

export default Layout;
