# TeachableMachine

This repo lets you connect between Google's [Teachable Machine](https://teachablemachine.withgoogle.com/) model and Rhino/Grasshopper.

## Setup

- Download and unzip the binary for [WebsocketEchoServer](https://github.com/dantaeyoung/GrasshopperArsenal/blob/master/WebsocketEchoServer/).
- Download and install [Bengesht](https://www.food4rhino.com/app/bengesht), a Grasshoopper plugin.

## Usage

1. Create and train a [Teachable Machine](https://teachablemachine.withgoogle.com/) model. Upload it to Google's servers. You should end up with a URL that looks like `https://teachablemachine.withgoogle.com/models/3z88PdTy/`.

2. Run `WebsocketEchoServer.exe` (the binary you downloaded). This program creates a websocket server at `ws://127.0.0.1:8080`.

3. Use https://teachable-machine-socket.glitch.me/ to load the trained Teachable Machine model, using the model URL that you received in step 1. (Make sure that you're using HTTPS, not HTTP!)

4. Open the `ListenToTeachableMachine.gh` file - this uses `Bengesht` to listen on `ws://localhost:8080` and receive data from the Teachable Machine model.
