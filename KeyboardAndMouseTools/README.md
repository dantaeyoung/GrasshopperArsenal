# Keyboard and Mouse Tools

## Data Dam and streams

The component called `Data Dam` can be incredibly helpful when working with rapidly changing data.

`Data Dam` *buffers* input, or slows down the rate of input, by checking the input every once in a while (i.e. once every second) and setting that as output. By right-clicking on `Data Dam`, you can set the rate of change to go from 0.25 seconds to 10 seconds.

![datadam.gif](gifs/datadam.gif)

This is incredibly helpful when you are working with data coming from a constantly-changing input source -- such as keyboards, mice, cameras, audio streams, Kinects, Leap Motion, etc. In the example below, you can see what happens when you use `Data Dam` to buffer mouse input. 

The mouse input component (`mouse`) is from the plugin `InteracTool`, downloadable at ![Food4Rhino](https://www.food4rhino.com/app/interactool).

![datadam_mouse.gif](gifs/datadam_mouse.gif)

`Data Dam` is helpful in a lot of ways. For example, you can use it to detect whether a value has changed, by comparing a value and its output. Since `Data Dam` 'lags' behind a bit behind the changed value, the comparison will answer the question: "is data changing?"

![isdatachanging.gif](gifs/isdatachanging.gif)

`Stream Filter` can operate like a switch -- given an input 'gate' command, it can distribute data to one of many different outputs. Think of it like a railroad track switch, able to send lots of data to many different directions.

If you zoom into `Stream Filter`, you can edit the number of outputs so that the component can distribute data to four different outputs, for example.

![streamfilter.gif](gifs/streamfilter.gif)

Using the `Stream Filter` component with `Data Dam`, you can pass data through only when it's changed. This is helpful when you want to record data (using `Record Data`, or `Data Log` from the `Firefly` plugin), or you want to trigger something only when new data is received.

![dataonlywhenchanging.gif](gifs/dataonlywhenchanging.gif)


![custom_preview_1.gif](gifs/custom_preview_1.gif)
![custom_preview_2_viewport_filter.gif](gifs/custom_preview_2_viewport_filter.gif)
![display_geometry_names.gif](gifs/display_geometry_names.gif)
![final_example.gif](gifs/final_example.gif)
![flounder_camera_1_get.gif](gifs/flounder_camera_1_get.gif)
![flounder_camera_2_sync.gif](gifs/flounder_camera_2_sync.gif)
![geometry_pipeline.gif](gifs/geometry_pipeline.gif)
![get_attributes.gif](gifs/get_attributes.gif)
![keyboard_input_toggle_select.gif](gifs/keyboard_input_toggle_select.gif)
![keyboardinput.gif](gifs/keyboardinput.gif)
![mouse_click_update.gif](gifs/mouse_click_update.gif)
![saving_keystrokes_to_names.gif](gifs/saving_keystrokes_to_names.gif)
![selobj_intro.gif](gifs/selobj_intro.gif)
![selobj_with_mouseclick.gif](gifs/selobj_with_mouseclick.gif)
![set_name_attributes.gif](gifs/set_name_attributes.gif)
![timer_constant_refresh_example.gif](gifs/timer_constant_refresh_example.gif)
![wallmaker_with_keyboard.gif](gifs/wallmaker_with_keyboard.gif)
