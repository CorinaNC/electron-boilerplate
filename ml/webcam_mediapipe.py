import cv2
import mediapipe as mp
import numpy as np
from flask import Flask
from flask_socketio import SocketIO
from flask_cors import CORS
import base64
import threading

# Flask socket connection
app = Flask(__name__)
socketio = SocketIO(app, cors_allowed_origins="*", async_mode='threading')

# usage python read.py, quit with 'q'
mp_drawing = mp.solutions.drawing_utils
mp_pose = mp.solutions.pose
mp_hands = mp.solutions.hands

def video_stream():
    # Use both Pose and Hands together
    with mp_pose.Pose(min_detection_confidence=0.5, min_tracking_confidence=0.5) as pose, \
        mp_hands.Hands(static_image_mode=False, max_num_hands=2, min_detection_confidence=0.5, min_tracking_confidence=0.5) as hands:
        # video feed
        cap = cv2.VideoCapture(0)
        while cap.isOpened():
            ret, frame = cap.read()
            if not ret:
                break

            # recolor image to RGB for MediaPipe
            image = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
            image.flags.writeable = False
            
            # Make detections
            pose_results = pose.process(image)
            hands_results = hands.process(image)
            
            # recolor back to BGR for OpenCV rendering
            image.flags.writeable = True
            image = cv2.cvtColor(image, cv2.COLOR_RGB2BGR)

            # Render pose detection (if any)
            if pose_results.pose_landmarks:
                mp_drawing.draw_landmarks(image, pose_results.pose_landmarks, mp_pose.POSE_CONNECTIONS)

            # Render hand detections (if any)
            if hands_results.multi_hand_landmarks:
                for hand_landmarks in hands_results.multi_hand_landmarks:
                    mp_drawing.draw_landmarks(image, hand_landmarks, mp_hands.HAND_CONNECTIONS)
            
            _, buffer = cv2.imencode('.jpg', image)
            frame_b64 = base64.b64encode(buffer).decode()
            socketio.emit('frame', {'data': frame_b64})
            
            cv2.imshow('Mediapipe feed', image)
            if cv2.waitKey(10) & 0xFF == ord('q'):
                break
        cap.release()
        cv2.destroyAllWindows()

@socketio.on('connect')
def handle_connect():
    print('Client connected')

@socketio.on('disconnect')
def handle_disconnect():
    print('Client disconnected')

if __name__ == '__main__':
    # Start video stream in background thread
    video_thread = threading.Thread(target=video_stream, daemon=True)
    video_thread.start()
    
    socketio.run(app, host='0.0.0.0', port=5001, debug=False)