## DimensionalityReduction

(These tools are not my coded tools per se, but rather examples of GH_C_Python and numpy so that PCA (Principal Component Analysis) and other techniques can be done in Grasshopper. 
I take zero credit for the libraries, just the 'wiring'/setup process that makes this possible.)

While libraries such as [Accord](http://accord-framework.net/intro.html) exist for C#, 
I'm using Python because 
1) There's a larger ML, statistics, scientific computing community for Python than in C#, which equals to more examples, documentation, and help
2) I like Python better. :)

### Concept / reasons:
More resources here: https://are.na/dan-taeyoung/machine-muses-learning-resources
An interactive introduction to PCA: http://setosa.io/ev/principal-component-analysis/


### Getting started

Installation instructions are below.

As for example, I recommend trying out `PCA_example_3d.gh` first. 

It uses some of the car data from [this PCA introduction](https://rstudio-pubs-static.s3.amazonaws.com/182884_e3952c98230b4f789d1224eee70df3d4.html) or [from here](https://feliperego.github.io/blog/2016/05/31/Intro-To-Principal-Component-Analysis).

![pca_example_3d](https://github.com/dantaeyoung/GrasshopperArsenal/blob/master/DimensionalityReduction/images/example_PCA_example_3d.png)


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
- Locate the Python.exe executable from the directory in the previous step above. (The directory I asked you to remember.)
![locatepython](https://github.com/dantaeyoung/GrasshopperArsenal/blob/master/DimensionalityReduction/images/installation_3_locatePython.png)

#### 4. [GH_Python](http://www.food4rhino.com/app/ghpython)
- This is the standard Python component in Grasshopper currently necessary to 'broker' data trees between GH_CPython and Grasshopper. (Potentially not needed in future versions of GH_CPython.)
- Install this component!

5. With this, you should be done with installation. Any Python libraries needed in the future can be installed with `pip install XXXX`, where `XXXX` is the name of the library.

### Troubleshooting

#### DLL unblock:
If you have problems opening GH_CPython, you may have to 'unblock' the DLL:
- Open the libraries folder from Grasshopper:
- ![ghlibraries](https://github.com/dantaeyoung/GrasshopperArsenal/blob/master/DimensionalityReduction/images/grasshopper_libraries.png)
- Right-click on the `FastColoredTextBox.dll` file,
- ![rightclick](https://github.com/dantaeyoung/GrasshopperArsenal/blob/master/DimensionalityReduction/images/dll_right_click.png)
- And clicking the 'unblock' button if it exists.
- ![unblock](https://github.com/dantaeyoung/GrasshopperArsenal/blob/master/DimensionalityReduction/images/dll_unblock.jpg)
