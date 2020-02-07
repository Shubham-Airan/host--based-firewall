# host--based-firewall

a. Testing
  I created individual test cases using Junit4 for testing individual modules.
  I also created CSV files of 100k records, so that I can see response time of my code in huge records
  I also tried to put variation in firewall rules in my own CSV file, so that I can varify whether it is working as per my requirement.


b. Coding, Design or algorithm choice

 Design:
  I have created Rules class for individual Rules present in each line of our CSV file.
  It has all attribues as given by each firewall rule from our CSV file.

 Coding: 
  I have created arraylist of Rules so that all Rules object are added line by line from CSV file to this arraylist.
  I sorted rules present in arraylist based on the startPort using comparators.

 Algorithm Choice:
  TO reduce time complexity of accept_packet() function, I sorted all rules present in arraylist based on startPort.
  The benefit of sorting in this way is, it will remove maximum rules whose start port is greater than port of our packet from our search.
  In this way, I am able to reduce time complexity of accept_packet() function from O(n) to somewhere between O(n)-O(log(n)).

c. any refinements or optimizations that you would’ve implemented if you had more time
 If I had more time, I would have tried to encorporate the information of end port in some way, that number of searched could be further reduced.
 If I had more time, I would have created more better CSV files of Rules, which would have tested my code more thouroughly, instead of copy pasting rules to create large CSV files.

d. anything else you’d like the reviewer to know
 I have done some projects, similar to this one in my Object-Oriented software devlopment class in last semester.
 I would be really glad to enhance my skills in this field, if I get chance to work on some real world project in Illumio



Attributions:
I took reference from below link to check whether a IPaddress is in given range or not.
//https://gist.github.com/madan712/6651967


I will be glad to work in any team in Illumio, however I have my ranking also.
1. Platform team
2. Data team
3. Policy team