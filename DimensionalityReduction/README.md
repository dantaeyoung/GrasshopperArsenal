## DimensionalityReduction

(These tools are not hand-coded tools per se, but rather examples of GH_C_Python and numpy so that PCA can be done in Grasshopper. 
I take zero credit for the libraries, just the wiring that makes this analysis possible.)

While libraries such as [Accord](http://accord-framework.net/intro.html) exist for C#, 
I'm using Python because 
1) There's a larger ML, statistics, scientific computing community for Python than in C#
2) I like Python better. :)

### Requirements:
- [Python 3](https://www.python.org/downloads/) - This runs a 'real' implementation of Python, rather than IronPython, which is Python for the primarily Windows-based .NET framework.
- [GH_CPython](http://www.food4rhino.com/app/ghcpython) - This Grasshopper component lets you choose and run the Python interpreter you choose -- so you can run 'real' Python inside GH.
- [GH_Python](http://www.food4rhino.com/app/ghpython) - This is the standard Python component in Grasshopper currently necessary to 'broker' data trees between GH_CPython and Grasshopper. Potentially not needed in future versions of GH_CPython.

### How-to / install
1. Install [Python 3](https://www.python.org/downloads/).
![python_install](https://github.com/dantaeyoung/GrasshopperArsenal/blob/master/DimensionalityReduction/images/installation_1_python.png)
You can do this even if you do not have admin access; make sure you click the 'just me' button:

![python_local_install](https://github.com/dantaeyoung/GrasshopperArsenal/blob/master/DimensionalityReduction/images/installation_1.5_python_local.png)

2. [GH_CPython](http://www.food4rhino.com/app/ghcpython)
This Grasshopper component lets you choose and run the Python interpreter you choose -- so you can run 'real' Python inside GH. Install the component.

3. [GH_Python](http://www.food4rhino.com/app/ghpython) - This is the standard Python component in Grasshopper currently necessary to 'broker' data trees between GH_CPython and Grasshopper. Potentially not needed in future versions of GH_CPython.



