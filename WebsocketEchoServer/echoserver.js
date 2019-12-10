const WebSocket = require('ws');

var echoserver = {};


echoserver.log = function(...msgs) {
    console.log(msgs.join(" "));
}


echoserver.startServer = function(opts, logfunction) {
    if(typeof(opts) !== "object" || !("port" in opts)) { 
        var opts = { port: 8080 }
    }

    logfunction("SERVER: starting server...");

    echoserver.wss = new WebSocket.Server(opts);


    echoserver.wss.on('connection', function connection(ws) {
        logfunction("SERVER: someone connected to us!");
        ws.on('message', function incoming(data) {
            logfunction("Rebroadcasted data: "+ data);
            echoserver.wss.clients.forEach(function each(client) {
                if(client.readyState === WebSocket.OPEN) {
                    if (client !== ws) {
                        // send only to different clients
                        logfunction("SERVER: sent data to: "+ client);
                        client.send(data);
                    }  
                    //   client.send("DEBUG: some data was broadcast by somebody!"); //comment this line out normally
                }
            });
        });


        ws.on('close', function (ws) {
            logfunction("SERVER: someone disconnected!");
        });

    });

}


module.exports = echoserver;


//echoserver.startServer({}, echoserver.log);
