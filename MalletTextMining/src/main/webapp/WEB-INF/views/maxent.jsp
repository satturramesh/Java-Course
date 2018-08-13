 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mallet View</title>
</head>
<body>
<h1>Mallet Result</h1>

Accuracy while training:  ${training} <br><br>
Accuracy while testing: ${testing} <br><br>
Precision: ${presicision} <br><br>

</body>
</html> --%>
 <!DOCTYPE html>
  <html>
    <head>
     
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">


   
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
      
            <style type="text/css">
      body{
  background:#f1f2f3;
  font-size:100%;
  color:#262626;
  font-family:'Arial',sans-serif;
}
#Nav {

  margin-top: 10px;
 
  background-color: skyblue;
  color: #f2f2f2;
  font-size: 4.4em;
  font-family: "Calibri";
  text-align: left;
  }
      </style>
    </head>
 <nav id="Nav">
    <div class="nav-wrapper">
      <a href="#" class="brand-logo">MAXENT ALGORITHM</a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
      <li><a href="/MalletTextMining/home">Home</a></li>
      </ul>
    </div>
  </nav>
    <body>	
	<!-- <script type="text/javascript">
function performClick(elemId) {
   var elem = document.getElementById(elemId);
   if(elem && document.createEvent) {
      var evt = document.createEvent("MouseEvents");
      evt.initEvent("click", true, false);
      elem.dispatchEvent(evt);
   }
}
</script>
<a href="#" onclick="performClick('theFile');"></a>
<input type="file" id="theFile" />
	</body>    

 -->
    <body>

<div class="container">

<div class="row">
    <form class="col s12">
 <br><br>

The training accuracy is	:${	training} <br><br>
The testing accuracy is		:${	testing} <br><br>
Precision while training	:${	precisiontrain} <br><br>
Precision while testing		:${	precisiontest} <br><br>
Average Rank while training	:${	trainrank} <br><br>
Average Rank while testing	:${	testrank} <br><br>


      <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
 <!-- <footer class="page-footer">
          <div class="container">
            <div class="row">
              <div class="col l6 s12">
                <h5 class="white-text">Footer Content</h5>
                <p class="grey-text text-lighten-4">You can use rows and columns here to organize your footer content.</p>
              </div>
             
            </div>
          </div>
          <div class="footer-copyright">
            <div class="container">
            © 2014 Copyright GeorgeJenifer
            <a class="grey-text text-lighten-4 right" href="#!">More</a>
            </div>
          </div>
        </footer> -->
    </body>
  </html>