// from https://github.com/dantaeyoung/dantaeyoung.com/blob/master/js/Events.js
//
//
//
var Events = {};
const _ = require('lodash')

Events.interestedN = 0;

Events.randPastelVars = function() {

    var difference = 0.6;  // 0 ~ 1; 0 = same, 1 = different colors
    var spread = 0.4; // 0 ~ 1: 0 = always same/different, 1 = total randomness

    var hue1 = _.random(0, 360);
    var hue2 = (hue1 + _.random((180 * difference) - (180 * spread), (180 * difference) + (180 * spread))) % 360;

    if(window.darkmode == true) {
        var lightness = _.random(10, 30);
    } else {
        var lightness = _.random(60, 90);
    }

    return [hue1, hue2, lightness]
}


Events.pastelPairFromVars = function(vars) {
    var hue1 = vars[0];
    var hue2 = vars[1];
    var lightness = vars[2];

    var pastel1 = 'hsl(' + hue1 + ', 100%, ' + lightness + '%)';
    var pastel2 = 'hsl(' + hue2 + ', 100%, ' + lightness + '%)';
    return [pastel1, pastel2];
}

Events.randPastelPair = function() {
    var vars = Events.randPastelVars();
    return Events.pastelPairFromVars(vars);
}

function scrollPoints(n) {
	return _.map(_.range(n), function(x) { return x * (100 / (n - 1)); })
}

Events.setRandomGradient = function() {
    var rpp = Events.randPastelPair();
    var dir = _.random(0, 360);
    var backgroundString = "linear-gradient(" + dir + "deg, " + rpp[0] + ", " + rpp[1] + ")";
    document.body.style.background = backgroundString;
    return backgroundString;
}


Events.setRandomGradient();

module.exports = Events;
