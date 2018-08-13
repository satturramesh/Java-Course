  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
 <!DOCTYPE html>
  <html lang="en">
  
    <head>
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">


   
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
 
<nav id= "Nav">
        <a href="#" class="brand-logo">MALLET Text Mining</a>
        <ul id="nav-mobile" class="right hide-on-med-and-down">
     	
        <li><a href="/MalletTextMining/maxent">MaxEnt</a></li>
        <li><a href="/MalletTextMining/naive">NaiveBayes</a></li>
        <li><a href="/MalletTextMining/decision">DecisionTree</a></li>
      </ul>
</nav>
  
  <style>  
body{
  background:#f1f2f3;
  font-size:62%;
  color:#262626;
  font-family:'Arial',sans-serif;
}
img{ 
  max-width:100%;
}
#wrap{
  width:90%;
  margin:20px auto;
}
#Nav {

  margin-top: 10px;
 
  background-color: skyblue;
  color: #f2f2f2;
  font-size: 4.4em;
  font-family: "Calibri";
  text-align: left;
  }


#product_layout_3 .product_image{
  display:block;
  box-sizing:border-box;
  width:40%;
  float:left;
}
#product_layout_3 .product_image .main_image img{
  margin:0 auto;
  border:1px solid #808080;
  border-radius:2px;
}
#product_layout_3 .product_desc{
  width:50%;
  float:left;
  margin-left:10%;
  min-height:660px;
}
#product_layout_3 .product_desc h1{
  font-size:4.6em;
  font-weight:500;
}


#product_layout_3 .product_desc .description{
  font-size:1.7em;
  display:block;
  width:100%;
  clear:both;
}

#product_layout_3 .tabular{
  display:block;
  margin-top:20px;
  width:100%
}
#product_layout_3 .tabular ul.tabs {
	width: 50%;
	height: 50px;
	list-style: none;
	overflow: hidden;
  padding: 0;
}
#product_layout_3 .tabular ul.tabs li {	
	float: left;
	width: 32%;
  margin-right:1%;
}
#product_layout_3 .tabular ul.tabs li a {
	position: relative;
	display: block;
	height: 80px;
	width: 320%;
	margin-top: 0px;
	padding: 0 0 0 0;
	font-size: 3.4em;
	text-align: center;	
	text-decoration: none;
	color: #ffffff;
	background: skyblue;
	transition: padding 0.2s ease, margin 0.2s ease;
  margin-bottom:-10px;
  border-top-left-radius: 3px;
  border-top-right-radius: 3px;
}

#product_layout_3 .tabular #content {
  width: 100%;
  min-height: 200px;
  background: #545f60;
  border-bottom-right-radius: 3px;
  border-bottom-left-radius: 3px;
  border-top-right-radius:3px;
  padding:2em;
  float:left;
  margin-top:-10px;
  border:1px solid #808080;
  border-top:0;
  margin-bottom:30px;
  box-sizing:border-box;
  -moz-box-sizing:border-box;
}
#product_layout_3 .tabular #content p{
  color: #ffffff;
  font-weight:500;
  font-size: 1.7em;
  margin: 10px;
}


#product_layout_3 .tabular #content #three .details{
  width:53%;
  float:left;
  margin-left:23.5%;
  height:auto;
}
@media (max-width:500px){
  #product_layout_3 .product_image{
    width:100%;
    margin-left:0;
    margin-right:0;
  }
  #product_layout_3 .tabular #content #three{
     height:auto;
    display:block;
  }
 
	</style>

    </head>

    
<body>

<div id="wrap">
  <div id="product_layout_3">
    <div class="product_image">
      <div class="main_image">
        <img src="/MalletTextMining/resources/images/text.png" width="500" height="300"/>
      </div>
    </div>
    <div class="product_desc">
      <h1>Text Mining</h1>
      
<%--    
      
      <div class="product_options">
        <div class="select">
                 <select id="size">
                   <option href = "max.html">MaxEnt</option>
                   <option href = "naive.html">NaiveBayes</option>
                   <option href = "decision.html">Decision Tree</option>
               
                 </select>
                 </div>
          </div>
           --%>  
          <div class="description">
            <p align="justify">Text mining, which is sometimes referred to text analytics is one way to make qualitative or unstructured data usable by a computer.</P>
            <p align="justify">Qualitative data is descriptive data that cannot be measured in numbers and often includes qualities of appearance like color, texture, and textual description. Quantitative data is numerical, structured data that can be measured. However, there is often slippage between qualitative and quantitative categories. For example, a photograph might traditionally be considered qualitative data but when you break it down to the level of pixels, which can be measured.</p>
            <p align="justify">Did you know?<br>
			<ul style="list-style-type:disc">
  <li align="justify">An estimated 80% of data is unstructured?</li>
  <li align="justify">This includes emails, newspaper or web articles, internal reports, transcripts of phone calls, research papers, blog entries, and patent applications, to name a few.</li>
  <li align="justify">Thanks to the web and social media, More than 7 million web pages of text are being added to our collective repository, daily</li>
</ul>
</p>
			<p align="justify">You can now begin to see the usefulness of software that can read between 15,000- 250,000 pages an hour, compared to a mere sixty pages for humans.</p>
       <p align="justify">what is text mining?<br><br>
	   The Oxford English Dictionary defines text mining as the process or practice of examining large collections of written resources in order to generate new information, typically using specialized computer software. It is a subset of the larger field of data mining. Guernsey explains that “to the uninitiated, it may seem that Google and other Web search engines do something similar, since they also pore through reams of documents in split-second intervals. But, as experts note, search engines are merely retrieving information, displaying lists of documents that contain certain keywords. They do not suggest connections or generate any new knowledge. Text-mining programs go further, categorizing information, making links between otherwise unconnected documents and providing visual maps.</p>
	   

	   </div>
         
      </div>
      <div class="tabular">
        <ul class="tabs group">
       
          <li><a class="active" href="#/three">MALLET Overview</a></li>
        </ul>
          <div id="content">

            <aside id="three">
             
              <div class="details">
              <p align="justify">MALLET is a Java-based Open Source package for statistical natural language processing, document classification, clustering, topic modeling, information extraction, and other machine learning applications to text.</p>
              <p align="justify">MALLET includes sophisticated tools for document classification: efficient routines for converting text to "features", a wide variety of algorithms (including Naive Bayes, Maximum Entropy, and Decision Trees), and code for evaluating classifier performance using several commonly used metrics.</p>
              <p align="justify">Many of the algorithms in MALLET depend on numerical optimization. MALLET includes an efficient implementation of Limited Memory BFGS, among many other optimization methods.</p>
			  <p align="justify">In addition to sophisticated Machine Learning applications, MALLET includes routines for transforming text documents into numerical representations that can then be processed efficiently. This process is implemented through a flexible system of "pipes", which handle distinct tasks such as tokenizing strings, removing stopwords, and converting sequences into count vectors.</p>
			  </div>
              </aside>
	
          </div>

      </div>
    </div>
  </div>
<!-- </div> -->
    </body>
  </html>