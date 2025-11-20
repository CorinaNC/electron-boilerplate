import { Box, Button } from "@chakra-ui/react"

const Work = () => {
  const showNotification = () => {
    new Notification("heyo", {
      body: "This is the notif here you gooooo",
      icon: "assets/wolf.png",
    });
  };
  return (
    <Box>
      <Button onClick={showNotification}>Notify</Button>
    </Box>
  );
};

export default Work;
