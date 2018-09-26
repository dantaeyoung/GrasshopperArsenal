# SketchGestures

Here's a simple example of using 'gestures' to control a tool -- effectively embedding control into the geometry.

Using the `Curve | Self` intersection tool, you can calculate all the times each curve intersects itself. Because Grasshopper will count each intersection point twice, we can use `List Length` to get the number of items in a list -- that is, how many intersection points there are per line, and divide it by 2 to get the 'number of intersections' per line.

![counting_intersections.gif](gifs/counting_intersections.gif)

Using this 'number of intersections', we can use the `Sift Pattern` component to separate or 'sift' out the geometry and do different operations in it! In the below example, for curves with two or three intersections, the tool will create a cone or a stack of spheres.

The cone or stack of spheres will also change radius depending on how long the curve is. A short curve that intersects itself once will make a small cone; a long curve that intersects itself will make a large cone!

![counting_intersections_mouse_gestures.gif](gifs/counting_intersections_mouse_gestures.gif)

It kind of feels like 'casting magic'.

![counting_intersections_mouse_gestures.gif](gifs/gesture_magic.gif)
