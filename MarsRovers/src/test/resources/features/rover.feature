Feature: Move the Rover's X and Y Position


  Scenario: Rover with Custom Position and Direction
    Given a Rover is ready to land
    When NASA sets the Rover's position to x=2, y=6, and direction to N
    Then the Rover's position and direction should be '2 6 N'

  Scenario: Rover with Negative Coordinates and Direction
    Given a Rover is ready to land
    When NASA sets the Rover's position to x=-1, y=-2, and direction to N
    Then the Rover's position and direction should be '-1 -2 N'

  Scenario: Rover with x and y position and location
    Given a Rover is ready to land
    And NASA sets the Rover's position to x=2, y=3, and direction to N
    When NASA moves the Rover forward
    Then the Rover's position and direction should be '2 4 N'
    When NASA turns the Rover right
    Then the Rover's position and direction should be '2 4 E'
    When NASA turns the Rover left
    Then the Rover's position and direction should be '2 4 N'

  Scenario: Rover with custom inputs for direction and set of instructions
    Given a Rover is ready to land
    When NASA sets the Rover's position to x=1, y=2, and direction to N
    And NASA gives 'LMLMLMLMM' as instructions to the Rover
    Then the Rover's position and direction should be '1 3 N'


