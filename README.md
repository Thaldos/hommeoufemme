# Homme ou femme

# Installation of JDK

Download the JDK 25 of adoptium : `https://adoptium.net/fr/temurin/releases`

Install the JDK 25 in `C:\Program Files\Eclipse Adoptium\jdk-25.0.2.10-hotspot`

<br >

# Installation of project's files
Open a terminal, go to your folder's destination project and type :
```
git clone https://github.com/Thaldos/hommeoufemme.git
```
<br >

# Configure your project in Visual Studio Code
Download Visual Studio Code : `https://code.visualstudio.com/`.

Install it.


Open VS Code and install the below extensions :
```
- Extension Pack for Java
- Git Graph
- Gemini Code Assist (if you have a Google One account to use Gemini pro in your project)
- Checkstyle for Java
- Codachi (optional)
```

In `C:\Users\Thaldos\AppData\Roaming\Code\User` open the file `settings.json` and add :
```
    "java.jdt.ls.java.home": "C:\\Program Files\\Eclipse Adoptium\\jdk-25.0.2.10-hotspot",
    "java.import.gradle.java.home": "C:\\Program Files\\Eclipse Adoptium\\jdk-25.0.2.10-hotspot"
```


Open your project in VS Code : `File > Open folder`

<br >

# Run the project 
In VS Code, in the left menu, clic on the "elephant" Gradle icon > html > gwt > superdev
or
Type in your terminal :
```
.\gradlew.bat html:superDev
```

In the VS Code terminal, the compilation start, and will give you a link `http://127.0.0.1:8080/index.html` to visit your local web server. Clic on stop buton or type Ctrl + C to close the local web server.

The folder `html\build\dist` succesfully received the html,js and css code to be deployed in production web server.

# Develop the project

When the local web server run, edit and save the files in `core > src` and refresh you browser page to see immediatly your result.

