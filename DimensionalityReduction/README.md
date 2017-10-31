## DimensionalityReduction

(These tools are not my coded tools per se, but rather examples of GH_C_Python and numpy so that PCA can be done in Grasshopper. 
I take zero credit for the libraries, just the 'wiring'/setup process that makes this possible.)

While libraries such as [Accord](http://accord-framework.net/intro.html) exist for C#, 
I'm using Python because 
1) There's a larger ML, statistics, scientific computing community for Python than in C#
2) I like Python better. :)

### Requirements:
- [Python 3](https://www.python.org/downloads/) - This runs a 'real' implementation of Python, rather than IronPython, which is Python for the primarily Windows-based .NET framework.
- [GH_CPython](http://www.food4rhino.com/app/ghcpython) - This Grasshopper component lets you choose and run the Python interpreter you choose -- so you can run 'real' Python inside GH.
- [GH_Python](http://www.food4rhino.com/app/ghpython) - This is the standard Python component in Grasshopper currently necessary to 'broker' data trees between GH_CPython and Grasshopper. Potentially not needed in future versions of GH_CPython.

### How-to / install
#### 1. Install [Python 3](https://www.python.org/downloads/).
![python_install](https://github.com/dantaeyoung/GrasshopperArsenal/blob/master/DimensionalityReduction/images/installation_1_python.png)
- You can do this even if you do not have admin access; make sure you click the 'just me' button:
![python_local_install](https://github.com/dantaeyoung/GrasshopperArsenal/blob/master/DimensionalityReduction/images/installation_1.5_python_local.png)

####  2. Install Python libraries
- Open Windows Powershell or Command Prompt. (You can do this by hitting the start button in Windows 8 and up, typing in 'powershell' and pressing enter).
- For PCA, we need to install the `numpy` and `matplotlib` libraries. Type:
- Type `pip install numpy matplotlib`
- You should the installation complete successfully.
![pip installation](https://github.com/dantaeyoung/GrasshopperArsenal/blob/master/DimensionalityReduction/images/installation_4_pip_install.png)

#### 3. [GH_CPython](http://www.food4rhino.com/app/ghcpython)
- This Grasshopper component lets you choose and run the Python interpreter you choose -- so you can run 'real' Python inside GH. 
- Install the component.
- Add the component to the Grasshopper canvas and double-click on the component to bring up the Python code window.
- Click on the 'Python' menu item > 'Choose Interpreter' button.
![choose interpreter](https://github.com/dantaeyoung/GrasshopperArsenal/blob/master/DimensionalityReduction/images/installation_2_choose_interpreter.png)
- Locate the Python.exe executable from the directory in the previous step above.
![locatepython](https://github.com/dantaeyoung/GrasshopperArsenal/blob/master/DimensionalityReduction/images/installation_3_locatePython.png)

#### 4. [GH_Python](http://www.food4rhino.com/app/ghpython)
- This is the standard Python component in Grasshopper currently necessary to 'broker' data trees between GH_CPython and Grasshopper. (Potentially not needed in future versions of GH_CPython.)
- Install this component!

5. With this, you should be done with installation. Any Python libraries needed in the future can be installed with `pip install XXXX`, where `XXXX` is the name of the library.

### Getting started

I recommend trying out `PCA_example_3d.gh` first.
![pca_example_3d](https://github.com/dantaeyoung/GrasshopperArsenal/blob/master/DimensionalityReduction/images/example_PCA_example_3d.png)
