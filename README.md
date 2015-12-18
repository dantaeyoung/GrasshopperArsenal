# GrasshopperArsenal

Grasshopper GHXs to share / play with.

If you'd like to add, please send a pull request.

## ROBUST:

* **MetaDataWriter**: Writing and reading metadata into Rhino geometry
* **SlackNotifier**: Posting to Slack with Grasshopper & Slack Web API
* **TimerLocker**: Enable/Disable timers with Grasshopper Boolean values
![TimerLocker.gif](https://raw.githubusercontent.com/provolot/GrasshopperArsenal/master/TimerLocker/TimerLocker.gif)
* **GeometrySelector**: Select Geometry with the mouse and send that info to others
* **SwivelFigures**: Place scale figures and rotate them to align with camera, Sketchup-Style
![SwivelFigures.gif](https://raw.githubusercontent.com/provolot/GrasshopperArsenal/master/SwivelFigures/SwivelFigures.gif)
* **JsonReader**: Read JSON data from web APIS (and display lat/long info)
![JsonReader.gif](https://github.com/provolot/GrasshopperArsenal/raw/master/JsonReader/JsonReader.gif)
* **GisReader**: Read GIS shapefiles as Rhino geometry (using [localcode/finches](https://github.com/localcode/finches))
* **SnippetTransferer**: Using Andrew Heumann's [Create Snippets](http://www.grasshopper3d.com/profiles/blogs/create-snippets-with-grasshopper) code, send snippet as data
![SnippetTransferer.gif](https://raw.githubusercontent.com/provolot/GrasshopperArsenal/master/SnippetTransferer/SnippetTransferer.gif)
* **FunctionalReduce**: Reduce/Foldl in Grasshopper
![FunctionalReduce.PNG](https://raw.githubusercontent.com/provolot/GrasshopperArsenal/master/FunctionalReduce/FunctionalReduce.PNG)

## Experimental:

* **CameraTracer**: Turns scribbles, captured via the webcam, into polylines

#### Setup:

Before running the scripts,
* Install IronPython: http://ironpython.net/
* Run 'EditPythonScript' in Rhino; under Tools > Options, and in the 'Script Engine' tab, make sure that 'Frames Enabled' is checked.

#### Troubleshooting:

* If you get the error: ` 'ScopeStorage' object has no attribute 'scriptcontext' `, Restart Rhino.

#### Note for future self about using libraries

Put this code at the start of your Python code to import libraries in '_LIBRARIES'.
```
## MAKE LIBRARIES IMPORTABLE ##
import sys, os
libraryPath = os.path.dirname(sys.path[0]) + "\_LIBRARIES"
if not libraryPath in sys.path:
    sys.path.append(libraryPath)
################################
```
