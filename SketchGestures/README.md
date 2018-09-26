# SketchGestures

Here's a simple example of using 'gestures' to control a tool -- effectively embedding control into the geometry.

![counting_intersections.gif](gifs/counting_intersections.gif)
![counting_intersections_mouse_gestures.gif](gifs/counting_intersections_mouse_gestures.gif)

This is incredibly helpful when you are working with data coming from a constantly-changing input source -- such as keyboards, mice, cameras, audio streams, Kinects, Leap Motion, etc. In the example below, you can see what happens when you use `Data Dam` to buffer mouse input. 

The mouse input component (`mouse`) is from the plugin `InteracTool`, downloadable at ![Food4Rhino](https://www.food4rhino.com/app/interactool). The component outputs the location of the mouse pointer on the xy plan, an infinitely long line that passes through the camera and the mouse pointer, among other nifty outputs.
