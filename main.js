const { app, BrowserWindow } = require("electron");
const url = require("url");
const path = require("path");
const { Notification } = require("electron/main");
const { start } = require("repl");

const createWindow = () => {
  const mainWindow = new BrowserWindow({
    title: "Electron",
    width: 1000,
    height: 600,
  });

  mainWindow.webContents.openDevTools();
  if (process.platform === "win32") {
    app.setAppUserModelId(app.name);
  }

  const startUrl = url.format({
    pathname: path.join(__dirname, "./app/dist/index.html"),
    protocol: "file",
  });

//   const notif = new Notification({
//     icon: "assets/wolf.png",
//     body: "notif for when it runs",
//     title: "Title for when it runs",
//   });

//   notif.show()

  mainWindow.loadURL("http://localhost:5173"); // does not work with npm run buidl anymore :(
};

app.whenReady().then(createWindow);
