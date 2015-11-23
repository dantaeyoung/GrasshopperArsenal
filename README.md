# GrasshopperArsenal

Grasshopper GHXs to share / play with.

## ROBUST:

* **MetaDataWriter**: Writing and reading metadata into Rhino geometry
* **SlackNotifier**: Posting to Slack with Grasshopper & Slack Web API
* **TimerLocker**: Enable/Disable timers with Grasshopper Boolean values
* **GeometrySelector**: Select Geometry with the mouse and send that info to others

## Experimental:

* **CameraTracer**: Turns scribbles, captured via the webcam, into polylines


#### Troubleshooting:

* Run 'EditPythonScript' in Rhino; under Tools > Options, and in the 'Script Engine' tab, make sure that 'Frames Enabled' is checked.

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
