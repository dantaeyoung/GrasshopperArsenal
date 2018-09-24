# Keyboard and Mouse Tools

This document is an example-based introduction to Keyboard and Mouse tools -- as well as a few tricks/hacks for using these tools!

## Data Dam and streams

The component called `Data Dam` can be incredibly helpful when working with rapidly changing data.

`Data Dam` *buffers* input, or slows down the rate of input, by checking the input every once in a while (i.e. once every second) and setting that as output. By right-clicking on `Data Dam`, you can set the rate of change to go from 0.25 seconds to 10 seconds.

![datadam.gif](gifs/datadam.gif)

This is incredibly helpful when you are working with data coming from a constantly-changing input source -- such as keyboards, mice, cameras, audio streams, Kinects, Leap Motion, etc. In the example below, you can see what happens when you use `Data Dam` to buffer mouse input. 

The mouse input component (`mouse`) is from the plugin `InteracTool`, downloadable at ![Food4Rhino](https://www.food4rhino.com/app/interactool). The component outputs the location of the mouse pointer on the xy plan, an infinitely long line that passes through the camera and the mouse pointer, among other nifty outputs.

![datadam_mouse.gif](gifs/datadam_mouse.gif)

`Data Dam` is helpful in a lot of ways. For example, you can use it to detect whether a value has changed, by comparing a value and its output. Since `Data Dam` 'lags' behind a bit behind the changed value, the comparison will answer the question: "is data changing?"

![isdatachanging.gif](gifs/isdatachanging.gif)

`Stream Filter` can operate like a switch -- given an input 'gate' command, it can distribute data to one of many different outputs. Think of it like a railroad track switch, able to send lots of data to many different directions.

If you zoom into `Stream Filter`, you can edit the number of outputs so that the component can distribute data to four different outputs, for example.

![streamfilter.gif](gifs/streamfilter.gif)

Using the `Stream Filter` component with `Data Dam`, you can pass data through only when it's changed. This is helpful when you want to record data (using `Record Data`, or `Data Log` from the `Firefly` plugin), or you want to trigger something only when new data is received.

![dataonlywhenchanging.gif](gifs/dataonlywhenchanging.gif)

## Selecting objects with the mouse, and on Timers

`Objects by Selection` (or `SelObj` to be short)  is a component that's part of the [`Human` plugin suite ](https://www.food4rhino.com/app/human). It will reference any geometry that is currently being selected in Rhino.

However, by default, the component will only run once, even if you select different things. This is because nothing 'upstream' of the component has expired. 

A quick note on how solution expiration in Grasshopper works: each component in Grasshopper only recomputes/re-runs when one of its inputs has changed. When the component runs, it will update its outputs. Anything connected to it's outputs will then recompute also, updating outputs again, and so on and so forth. 

![change_propagate.gif](gifs/change_propagate.gif)

When a component's input changes, Grasshopper declares that the component's solution has 'expired' -- that is, the solution that the component was holding until now is now longer valid, since now the component input has changed. For example, if the 'x^2' component had an input of `7`, then the component's output would be `49`. But if the input changes to something else, say, `11`, then the component declares that its solution is expired, recalculates its solution (`121`), and pushes it to the output. 

For the `SelObj` component -- since its inputs are not affected by what happens in Rhino, a solution expiration will not be triggered even if new things are selected in Rhino, and the component's outputs will not change. 

To solve this, you can attach a `Timer` object to the `SelObj` component. The `Timer` is a special component that tells the components it's attached to continually expire its solution every X seconds. Everything 'downstream' of the component -- that is, everything that's connected to the component's output, will also thus refresh every X seconds. Using the `Timer`, you can get objects that are selected!

![selobj_intro.gif](gifs/selobj_intro.gif)

However, one of the downsides of the `Timer` is its upside: Everything refreshes often, which is great, and everything refreshes often, which can make your script run slow. Imagine if your script takes 500ms to run, and the Timer tries to run every 250ms. This can lead to some major slowdowns.

![timer_constant_refresh_example.gif](gifs/timer_constant_refresh_example.gif)

So - one trick/hack/solution is to use other inputs other than the `Timer` to trigger a solution expiration, and thus a refresh. 

In the example below, the output of the mouse click is plugged into a `Boolean` component, and then plugged into a `Data Dam` so we can see what's going on. The `Boolean` component stores either True or False, but when it receives data other than the two, 0 is interpreted as False, and anything other than 0 will be considered to be True. 

So, since the output of the `mouse` component's point will pretty much never by exactly zero, this is quick hack to generate a 'True' value that will update each time you click. We've created an output that will always be True, but will just 'refresh' its' value whenever you click.

![mouse_click_update.gif](gifs/mouse_click_update.gif)

This means that we can harness this refreshing 'True' value and plug it into the `SelObj` component. Since selecting objects with the mouse involves a mouse click, every time you select an object in Rhino with the mouse, the mouse click will also trigger a scan by the `SelObj` component.

We do need to add a `Data Dam` so that the `SelObj` component scanned for selected objects a tiny bit after you've already selected an object, so the order of operations goes like this:

- You start selecting an object in Rhino, which triggers a click
- The click enters the data dam
- You finish selecting an object in Rhino
- The click exits the data dam, and triggers `SelObj`
- `SelObj` scans for selected objects, and finds the object that you newly selected.

![selobj_with_mouseclick.gif](gifs/selobj_with_mouseclick.gif)




![display_geometry_names.gif](gifs/display_geometry_names.gif)
![get_attributes.gif](gifs/get_attributes.gif)
![keyboard_input_toggle_select.gif](gifs/keyboard_input_toggle_select.gif)
![keyboardinput.gif](gifs/keyboardinput.gif)
![saving_keystrokes_to_names.gif](gifs/saving_keystrokes_to_names.gif)

![set_name_attributes.gif](gifs/set_name_attributes.gif)
![wallmaker_with_keyboard.gif](gifs/wallmaker_with_keyboard.gif)
