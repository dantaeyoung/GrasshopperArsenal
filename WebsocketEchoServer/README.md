# WebsocketEchoServer

This is an Electron app that creates a Websocket echo server. The goal of the server is simple; it creates a Websocket server on port 8080 that echoes and rebroadcasts any message it receives. The primary goal of this server is to ferry messages between a website and Grasshopper -- for example, between a Teachable Machine model and Grasshopper.

Download v0.1 Windows x64 binary for Websocket Echo Server:
https://drive.google.com/open?id=1fDdt-cb1uCWdAxWY4Vnz-bHosD1dYfXX

Websocket server location: `ws://127.0.0.1:8080`

For more info on how to use this, go to https://github.com/dantaeyoung/GrasshopperArsenal/blob/master/TeachableMachine/README.md

### Building WebsocketEchoServer from source:

Use [`electron-packager`](https://github.com/electron/electron-packager).
- `npm install electron-packager -g` 
- `electron-packager .`
