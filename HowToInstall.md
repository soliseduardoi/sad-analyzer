Setup

SADAnalyzer is composed of several Eclipse plugins. These plugins have been implemented using the latest version of Eclipse, and for this reason, a few steps are necessary to setup the SADAnalyzer environment.

First Step

Download a clean version of Eclipse Luna, and install the following "dependant" plugins. To do that, in Eclipse, click Help > Install New Software.

First, install the following plugins:

EMF (Eclipse Modeling Framework)
EMF Query
The plugins above can be found at the Eclipse Luna Update Site, included with eclipse.

Then, add the following Update Sites and install them.

UIMA - http://www.apache.org/dist/uima/eclipse-update-site/
EMF Query2 - https://hudson.eclipse.org/hudson/job/tycho-query2-nightly/lastSuccessfulBuild/artifact/targetPlatform/
AJDT - http://download.eclipse.org/tools/ajdt/37/update
WindowBuilder Pro - http://dl.google.com/eclipse/inst/d2wbpro/latest/3.7
Second Step

Copy SADAnalyzer plugin jars (downloaded from the Downloads page) to the plugins folder of Eclipse.

Third Step

Download the SADAnalyzer models. One part of the models are available in the Git, and the other is available separately (due to its size) from the following link in GoogleDrive: SADAnalyzerModel.zip. Uncompress the zip into a folder, merge the contents with the SVN models and modify the eclipse.ini file adding the following environment variable:

MODELS_PATH=C:/Your/Path/SadAnalyzerModels/ at eclipse.ini
This way, we link the variable to the models folder.

That's all!, you can now execute and use SADAnalyzer in your computer.

