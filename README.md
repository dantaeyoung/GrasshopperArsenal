# grasshopperArsenal

Snippets of Grasshopper GHXs to share / play with.



###Troubleshooting:

* Run 'EditPythonScript' in Rhino; under Tools > Options, and in the 'Script Engine' tab, make sure that 'Frames Enabled' is checked.

* If you get the error: ` 'ScopeStorage' object has no attribute 'scriptcontext' `, Restart Rhino.


Put this code at the start of your Python code to import libraries in '_LIBRARIES'.
```
## MAKE LIBRARIES IMPORTABLE ##
import sys, os
libraryPath = os.path.dirname(sys.path[0]) + "\_LIBRARIES"
if not libraryPath in sys.path:
    sys.path.append(libraryPath)
################################
```
