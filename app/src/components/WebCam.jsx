import React, { useEffect, useRef } from "react";
import io from "socket.io-client";

const Work = () => {
  const canvasRef = useRef(null);
  const socketRef = useRef(null);

  useEffect(() => {
    socketRef.current = io("http://localhost:5001");
    
    socketRef.current.on("connect", () => {
      console.log("Connected to video stream");
    });

    socketRef.current.on("frame", (data) => {
      const canvas = canvasRef.current;
      if (!canvas) return;
      
      const ctx = canvas.getContext("2d");
      const img = new Image();
      img.onload = () => {
        ctx.drawImage(img, 0, 0);
      };
      img.src = `data:image/jpeg;base64,${data.data}`;
    });

    socketRef.current.on("disconnect", () => {
      console.log("Disconnected from video stream");
    });

    return () => {
      if (socketRef.current) socketRef.current.disconnect();
    };
  }, []);

  return (
    <div>
      <canvas 
        ref={canvasRef} 
        width={640} 
        height={480} 
      />
    </div>
  );
};

export default Work;