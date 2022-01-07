# Conway-s-Game-Of-Life-GUI-Simulator-using-Java-Swing
A MVC simulator with GUI for John Conway's Game of Life

This project implements the Model-View-Controller architectural pattern for a Conway's Game of Life Simulation.

# Description:
  
  Conway's Game of Life is a cellular automaton represented by an "infinite" (in our case max board size is 100 x 100) 2D grid of squares, each of which called a cell. Each cell will have one of two states, alive or dead. The state is determined by the cell's 8 neighbors (horizontally, vertically, or diagonally adjacent). See the RULES section for rules determining the state for the next generation of cells.
  
  Models
  
    ICellModel & CellModel - represents a single cell in the board
    
    IBoard, Board, & AbsBoard - represents the 2D board of cells and determines the state of each cell   
    
  Views

    GameSetupGUIView - JFrame simulation setup page, allows for different board sizes (5x5, 10x10, 25x25, 50x50, 100x100)
    
    RulesGUIView - JFrame rules page, allows users to view the rules for how the next generation is determined
  
    sgGUIView - JFrame creator information page, allows users to view information about the creator (me) and contact information

    SimulationGUIView - JFrame simulation page, this is the page that will show the different generations being computed and updated state of the board

  Controllers
  
    ConwaysGameOfLifeGUI - Main method
  
    GameSetupGUIController - controls the logic behind starting the simulation, viewing the rules page, and viewing the creator information page

    SimulationGUIController - controls the logic behind the actual simulation by determining a single generation at a time and updating the view after each generation
  
  
  
# Rules:
  
  Rules for Determining Cell State:
    
    1. Any Live Cell with fewer than 2 live neighbors dies (underpopulation)
    2. Any live cell with 2 or 3 live neighbors lives on to the next generation
    3. Any live cell with more than 3 live neighbors dies (overpopulation)
    4. Any dead cell with exactly 3 live neighbors becomes a live cell (reproduction)
    
  

# Known Problems:

  When using the 100x100 sized board, the generation count and start/pause button at the top of the screen gets smushed together, making this panel slightly hard to view
  
  
