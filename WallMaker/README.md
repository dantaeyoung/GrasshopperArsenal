# WallMaker

### Description 

![final_example.gif](https://github.com/dantaeyoung/GrasshopperArsenal/blob/master/WallMaker/gifs/final_example.gif)

This is an example of a tool/interface in Grasshopper. 
The actual 'computation' that this tool is doing is straightforward - it extrudes lines. However, other aspects of the tool, created by `Geometry Pipeline`, `Custom Preview`, and `Flounder Camera Plugin`, create an interface where the tool is used with Grasshopper fully minimized.

Part of the point of this tool is about thinking how the interface changes how we interact with the tool and how we design. 

You can download the files here:
- ![WallMaker.gh](WallMaker.gh)
- ![WallMaker_Rhino.3dm](WallMaker_Rhino.3dm) (Rhino 6)


### Geometry Pipeline

![geometry_pipeline.gif](https://github.com/dantaeyoung/GrasshopperArsenal/blob/master/WallMaker/gifs/geometry_pipeline.gif)

The Geometry Pipeline is a very convenient to use component that can grab/reference many different types of geometry in Rhino based on the layer, or name, or geometry type. You can edit it by double-clicking, or by right-clicking. When you edit the layer, be sure to make sure that you're respecting layer capitalization and that you're not introducing accidental spaces.

The layer and name filters can take wildcards such as `*`, so `*Persepective` will match both `ModelPerspective` and `ViewPerspective`.

### Custom Preview

![custom_preview_1.gif](https://github.com/dantaeyoung/GrasshopperArsenal/blob/master/WallMaker/gifs/custom_preview_1.gif)

Custom Preview is a helpful componenent in two ways. First, you can change the color (and transparency) of how things are presented, which can have an incredible effect on how your tool feels. 

![custom_preview_2_viewport_filter.gif](https://github.com/dantaeyoung/GrasshopperArsenal/blob/master/WallMaker/gifs/custom_preview_2_viewport_filter.gif)

Second, however, you can create a 'viewport filter' by right-clicking. This means that the custom preview will only be visible on that viewport. Like the Geometry Pipeline, the Custom Preview component will also take an asterisk as a wild card.

### Flounder Camera Control

This is a simple plugin to get and set the location of the Rhino camera, by viewport. 

![flounder_camera_1_get.gif](https://github.com/dantaeyoung/GrasshopperArsenal/blob/master/WallMaker/gifs/flounder_camera_1_get.gif)

In the above example, we have to use a `Timer` component. This is because, in Grasshopper, components recalculate their results only when their inputs (what's plugged in on the left of each component) change. When we move the camera around, even though it changes, in Grasshopper, the GetFlounderCamera component technically doesn't have any of its input changes, so its outputs also do not change.

The `Timer` component solves this by 'forcing' a component to recalculate its results, no matter what, for every 1 second / 500 milliseconds / 20 milliseconds, etc. This is helpful because it will make our component update! It can be dangerous when you connect it to other components, since it will make the components recalculate constantly. If part of your Grasshopper program takes 1 second to run, and you ask it to recalculate every 500 ms... you can cause Grasshopper to slow down massively. 

![flounder_camera_2_sync.gif](https://github.com/dantaeyoung/GrasshopperArsenal/blob/master/WallMaker/gifs/flounder_camera_2_sync.gif)

By connecting a 'getFlounderCamera' component with a 'setFlounderCamera' component, you can effectively synchronize viewports! (note that the plugin has a bug, and 'setFlounderCamera appears to say 'syncFlounderCamera'.

### Final Example.

![final_example.gif](https://github.com/dantaeyoung/GrasshopperArsenal/blob/master/WallMaker/gifs/final_example.gif)

What does it feel like to use Grasshopper without the Grasshopper window visible? How is this an environment? 

What other kind of things can you do to change not "what the tool does", but how you interact with the tool, and thus how you can think with the tool?
