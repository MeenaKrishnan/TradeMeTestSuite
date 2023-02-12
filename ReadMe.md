<b><i>Solution Documentation </i></b><br/>

<p>This Solution uses selenium Web Driver and TetstNg for the autoamtion of UI .This uses Page Object Model and PAge Factory pattern <br/>
Rest Assured for the automation of API.<br/><br/></p>
<b><i>UI Automation</i></b><br/>
<p>The Configuration properties like the url and the browser to run etc are added in the test.properties and this will be loaded as part of the set up</p>
<P>The Drivers are located in the driver folder located in the root directory.The tests can run in Chrome,Firefox and Edge browsers.</P><br/>
<P>This has a base class that does all the set up like getting the right browser handle and running it.</P><br/>
<P>The driver folder consists of driver Manager Factory and all the driver managers </P> 
<P>The Pages folder consists of the Pages and Tabs ( Web element locators and methods to drive the UI for the particular page or tab)</P><br/>
<P>The utils folder consists of all utilities like Test Config loader for loading the test config properties and the wait helper to add all different sort of wait related methods</P><br/>
<P>Test folder consists of the Test (CarSearchTest) </P>
<P>Resources consists of hte TestNG config ( Tests can be parallelly run ) , test properties </P>
<P>Since we are using the live site, the results might vary from time to time.So the tests might fail.Hence the The test output folder is also uploaded so that it can show the results at the time it was submitted.Check out the index.html for the reuslts of the suite..Check inside TradeMe Test Suite to check out the individual results . You can run the tests and testng report will be automatically created ( just need to set the default reporting on in your IDE)</P>
<br/>
<br/>
<p> <b><i>********The Logger is not implemented yet and also optimising the tests by adding the setup of loading to the url just once is not implemented due to the time constraint .The trade Me Api url given in the test is giving a 403 for me . So haven't automated the API tests but the REST Helper is added to the Utils .**********</i> </b></p>





