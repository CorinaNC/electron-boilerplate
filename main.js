const { app, BrowserWindow } = require("electron");
const url = require('url')
const path = require('path')

const createWindow = () => {
    const mainWindow = new BrowserWindow({
        title: 'Electron',
        width: 1000,
        height: 600,
        
    })

    mainWindow.webContents.openDevTools()

    const startUrl = url.format({
        pathname: path.join(__dirname, './app/dist/index.html'),
        protocol: 'file',
    })

    mainWindow.loadURL("http://localhost:5174") // change this to stratUrl when deploying
}

app.whenReady().then(createWindow)
