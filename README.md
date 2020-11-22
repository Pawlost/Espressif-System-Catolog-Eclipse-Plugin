# Espressif Systems Catalog Eclipse Plugin
Espressif Systems Catalog Eclipse Plugin is an assignment from Espressif Systems company. 

## Table of Contents
* [Goal](#goal)
* [Features](#features)
* [Prerequisites](#prerequisites)
    * [Tool Preparation](#tool-preparation)
* [Contribution](#contribution)
    * [Test Plugin](#test-plugin)
* [Usage](#usage)
* [Export Plugin](#export-plugin)
    * [Installing plugin to Eclipse](#installing-plugin-to-eclipse)
* [License](#license)

## Goal
The goal of the exercise is to design and implement a simple application that captures Espressif products.
The products are customer made and are persistently saved in JSON files.

## Features
* User can enter and submit Espressif product.
* User can search and view certain Espressif product. 
    * (Refer to products section from https://www.espressif.com/)

## Prerequisites
Please install:
* JAVA SE 14
You can install Java SE 14 using one of 2 options:
    *  Download Java JDK 14 from [AdoptOpenJDK](https://adoptopenjdk.net/)
    *  Select JRE 14.0.2 http://download.eclipse.org/justj/jres/14/updates/release/14.0.2 in Java 11+ VM when installing Eclipse
![JRE Eclipse](https://github.com/Pawlost/Espressif-Systems-Catolog-Eclipse-Plugin/blob/main/screenshots/eclipsejre.png)
* [Eclipse](https://www.eclipse.org/downloads/)
    * Install *Eclipse IDE for Java Developers* 
* [Git](https://git-scm.com/downloads)

### Tools Preparation
If your eclipse does not have **Eclipse PDE (Plug-in Development Environment) plugin**, please follow these steps:
1)   Launch the Eclipse
2)   Go to *Help* -> *Eclipse Marketplace...*
3)   Type **PDE** to find field and **search**
4)   Press the **Install** button on *Eclipse PDE (Plug-in Development Environment)* item
5)  Press **Next**
6)  Accept licence terms and press **Finish**
7)  **Wait** until PDE is installed
8) **Restart** the Eclipse. 

## Contribution
If you wish to contribute to this project, please make sure, you meet all prerequisites and follow these steps:

1)  First clone this project from github by copyiing this command to a console.
```
git clone git@github.com:Pawlost/Espressif-Systems-Catolog-Eclipse-Plugin.git
```
2) Open Eclipse
3) *File* -> *Open Projects from File System...*
4) *Directory...* -> open your cloned repository -> *Select Folder*
5) *Finish* and wait for the repository to open
6) Right click in project explorer on main folder -> *Plug-in Tools* -> *Update Classpath...*
8) Now you can contribute

### Test Plugin
If you wish to test your changes follow next steps:
1) *Run* menu -> *Run Configurations...*
2) Double click *Eclipse Application*
3) Press *Run* -> *Continue*

## Usage
This plugin adds special menu *Espressif Catalog* to the Eclipse toolbar.
Selecting this menu gives user two options

![Menu](https://github.com/Pawlost/Espressif-Systems-Catolog-Eclipse-Plugin/blob/main/screenshots/catalogMenu.png)

*  *Add Espressif Item*
![Add Item](https://github.com/Pawlost/Espressif-Systems-Catolog-Eclipse-Plugin/blob/main/screenshots/addItem.PNG)

This option creates a new window, where you can specify name, type and description of a new Espressif item.

After you specified all neccessary information, you can click submit and new item will be saved to a json file after closing the window.

* *Browse Espressif Catalog*

This option creates new dialog where you can search for specific Espressif item added before. It also shows all currently saved Espressif items.
![Catalog](https://github.com/Pawlost/Espressif-Systems-Catolog-Eclipse-Plugin/blob/main/screenshots/Catalog.PNG)

To search simply type name of product you are looking for and press *Go*.
Be aware that searching is case sensitive!
![Searching](https://github.com/Pawlost/Espressif-Systems-Catolog-Eclipse-Plugin/blob/main/screenshots/Searching.PNG)

## Export plugin
To use finished plugin you can either download build from [github](https://github.com/Pawlost/Espressif-Systems-Catolog-Eclipse-Plugin/releases) or follow these steps:
1) Right click on main folder *Espressif Systems Catalog Eclipse Plugin* in *Package Explorer* -> *Export...*

![Export](https://github.com/Pawlost/Espressif-Systems-Catolog-Eclipse-Plugin/blob/main/screenshots/export.png)

2) *Plug-in Development* -> *Deplayable plug-ins and fragments*
3) By clicking *Directory* select folder for plugin output
    * Optionaly if you wish to skip plugin installation as a destination select *Install into host* option
4) *Finish*

### Installing plugin to Eclipse
If you have ZIP file, uncompress it to a JAR file and:
1) Go to your *eclipse* folder -> *dropins*
2) Copy and paste the plugin JAR file to the folder

## Licence
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details