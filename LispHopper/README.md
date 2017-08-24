## LispHopper 

Lisp (Hy), Python, and Grasshopper. What's not to like?

![LispHopper.gif](https://raw.githubusercontent.com/provolot/GrasshopperArsenal/master/LispHopper/LispHopper.gif)

### Requirements
- Mahmoud M. Abdelrahman's wonderful [GH_CPython](https://github.com/MahmoudAbdelRahman/GH_CPython)
- [Hy](https://github.com/hylang/hy)
- GH_Python

### How this works

1. A hy file is loaded and parsed (in GH_CPython) as (unevaluated) Python code.
2. Some additional code to enable library loading and processing list output as GH Datatrees is added.
3. The final code is parsed by a GH_Python component (IronPython). From the perspective of the last component, it's just Python.

Importing libraries can be done with `(import collections)`
This means that you can also do `(import [rhinoscriptsyntax :as rs])`
or even `(import [ghpythonlib.components :as ghcomp])`. Whoa.

### Hello world

```
(import [rhinoscriptsyntax :as rs])
(print "hello world")

(setv result_ [])       # result_ is an output defined in GH_Python component
(result_.append
  (rs.AddPoint 0 0 0))  
```

### Thoughts:

- The dataflow structure of GH feels nice for a functional language. Threading macros such as `->`, `->>`, or `at-pip` make it even better.
- Related is [Arcadia](https://github.com/arcadia-unity/Arcadia), for Unity.
- Not sure if this will be helpful, or more productive, but it sure is fun!
