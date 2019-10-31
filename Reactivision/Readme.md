# reacTIVision

## reacTIVision.exe

  - Download Reactivision from (http://reactivision.sourceforge.net/#files)[here]; this is a direct link to the Windows binary: (http://prdownloads.sourceforge.net/reactivision/reacTIVision-1.5.1-win64.zip?download)[reacTIVision-1.5.1-win64.zip]
  - Unarchive the file!
  - In the `reacTIVision-1.5.1-win64/` folder, run `reacTIVision.exe`. You should see a screen pop up, showing a processed black-and-white view of the webcam.
  - If Windows alerts you that reactivision wants to communicate over the network, let it do so.
  - Print out a sheet of fiducial markers from (http://reactivision.sourceforge.net/data/fiducials.pdf), or load it on your phone, and test to see if Reactivision recognizes it. You should see small green numbers in the middle of each marker.
  - Great!
  
##  Grasshopper Plugins

  - This example uses the plugins (https://www.food4rhino.com/app/telepathy)[Telepathy] and (https://www.food4rhino.com/app/ghowl)[gHowl].

## Grasshopper

  - Open `Paperhopper_Simple_CameraOnly_TEMPLATE.gh` in Grasshopper.
  - The `Find Tags` component will let you, given a fiducial marker tag ID, detect whether or not it exists, and retrieve its location and rotation. 
  
## More info

For a more developed system that uses reacTIVision, see (https://github.com/dantaeyoung/PaperHopper)[PaperHopper].
