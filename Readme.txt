1- This Branch: dev-branch1 will contain developments before merging to master

2- To run the program: you have to run main class: MainApp.java
  in package: pkgmain

3- I used pattern factory to create several beans.

4- I used pattern "strategy" to use several algorithms to implement robot processing
  you can find theses strategies in package : implement.strategy
  and the interface of startegy pattern is in : interfaces.strategy package
  
5-the optimal algorithm is in the class: OptimalSizeStrategy
the other algorithms are just alternatives, they can be used for greater data
I tested with small size of data , I din't check wich algorithm is better in performance for huge data

6- You can change the size of data in input chain, by changing the value of : MAX_ARTICLES_INPUT_LENGTH

in interface : AbstractInputChainFactory

7- enjoy ! 