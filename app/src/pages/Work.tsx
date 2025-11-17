import React from "react";

const Work = () => {
  const showNOtification = () => {
    new Notification("heyo", {
      body: "This is the notif here you gooooo",
      icon: "assets/wolf.png",
    });
  };
  return (
    <div>
      this is the work page
      <button onClick={showNOtification}>NOtify</button>
    </div>
  );
};

export default Work;
