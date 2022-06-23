# Upgrade Development Training

That training had goal to develop java code that create web pages with Upgrade Process Framework. The main point about upgrade process is automate process. 

You need to create a upgrade step that will add  a set about three public pages (with 2, 3, 4 sub pages respectively)  and one hidden page.

## Project setup
1. Create a new GitHub repository and clone it into your local environment.
2. On this repository, create a DXP 7.4 Liferay Workspace
     `blade init -v dxp-7.4-u26 [WORKSPACENAME]`
3. Create a module content-setup using API template with the structure below:


	modules
    |-- content-setup
        |--site-startup
            |-- constants
            |-- helper
            |-- upgrade
    SiteSetupRegistrator.java
 
## Requirements: 

 - Blade CLI
 - Java JDK 8+
 - MySQL Server (or any other preferred database)
