# TETRIS
A simple game where we apply what we learnt in class to practice the concept of OOP.

In this project, we use the Apache Net Bean IDE thanks to its beginner friendly GUI design. Though you can use others IDE.

# To do list
 1. Create the board game
 2. Draw block on the board
 3. Add block color
 4. Make the block fall down
 5. Spawn new block
 6. Moving, rotating block on key press
 7. Clear complete rows and add score
 
 # Team member
 
| Name | ID | Task | Contribution |
| :---: | :---: | :---: | :---: |
| Phan Quoc Khoi | ITDSIU18028 | 5-7, UI, Readme | 33% |
| Le Van| ITITIU19242 | 3-4, Cleaning, Debug | 33% |
| Pham Ngoc Tuan Anh | ITITIU19074 | 1-2, Ppt | 33% |
 
# Requirements
 * Java
 * Java Swing
 ---
 # Board game
 First, we create the game board by using JPanel, then we divided it into smaller cells base on the formula below.
 
 ![image](https://user-images.githubusercontent.com/52684784/170531720-a78f9f77-d865-4352-a5c3-d117951f5b68.png)
 # Drawing Block 
 After creating the board, now we need to draw the shape(tetrominoes) inside it.
 There are 7 tetrominoes in total, each of them will have different shape and color to distinguish.
 
 ![image](https://user-images.githubusercontent.com/52684784/170532176-af0e42d7-e8be-4d5b-827c-bd0361053e7c.png)
 
 Each tetrominoes will be stored in a 2d array with values 0, 1 where 1 is colored cell and otherwise.
 
 ![image](https://user-images.githubusercontent.com/52684784/170536852-7fd7791d-2aae-4706-9948-4323bbec6fc0.png)
 
 The output is something similar like this 
 
 ![image](https://user-images.githubusercontent.com/52684784/170541897-8541c3e1-042b-4b1d-b70c-f8e175f17076.png)
 # Make block fall down
 With the block spawning at the middle top of game board, now we need to make them fall down by 
 printing its postion after a fixed timestep and delete the previous one.
 
 So the process is: **print-wait-delete-print**
 
# Rotate block
![image](https://user-images.githubusercontent.com/52684784/170737184-b2143150-c182-4f1b-b2c6-7dccdaeaee07.png)

# Line removal
* First we need to find the completed line
* Remove it
* Shift down the lines above

# Demo
![image](https://user-images.githubusercontent.com/52684784/173118292-a971527f-5367-440f-bc9d-a14da3c67d6f.png)

# Deployment
* Download the source code
* Run Tetris.java 

# Ref
* [Discussion of the Tetris Applet](http://www.geom.uiuc.edu/java/tetris/explanation.html)
* [Tetris Explanation](https://www.iodraw.com/en/blog/211243890)
