This project is a simple standalone website used for the Frequent Flyer tests. You can either deploy it to your own web server or run it as a standalone website. One simple way to do this is to use Node.js, which is a lightweight JavaScript platform used to build and run JavaScript-based server-side applications. You don’t need to know anything about Node.js to run the sample site: just follow the instructions.
First, you’ll need to install Node.js, which you can download from the Node.js website (http://nodejs.org/). Once this is done, install the Node.js http-server tool from the command line as follows:
npm install –g http-server
Now go into the flying-high directory of the chapter 8 sample code, and start up the website with the following command:
http-server app
To view the running application, open up a web browser and go to http://localhost:8080