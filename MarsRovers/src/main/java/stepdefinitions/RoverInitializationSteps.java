package stepdefinitions;

import cucumber.api.java.en.*;

import rovermethod.Rover;

import static org.junit.Assert.*;


public class RoverInitializationSteps {
    private Rover rover;
    private int initialX;
    public int initialY;
    private char initialDirection;
    private String instructions;
    public String processOutput;

    @Given("^a Rover is ready to land$")
    public void initializeRover() {
        rover = new Rover();
    }

    @When("^NASA sets the Rover's position to x=(-?\\d+), y=(-?\\d+), and direction to (\\w+)$")
    public void setRoversPositionDirection(int x, int y, String direction) {
        initialX = x;
        initialY = y;
        initialDirection = direction.charAt(0);
        Integer finalDirection;
        switch (direction) {
            case "N":
                finalDirection = Rover.N;
                break;
            case "E":
                finalDirection = Rover.E;
                break;
            case "S":
                finalDirection = Rover.S;
                break;
            case "W":
                finalDirection = Rover.W;
                break;
            default:
                throw new IllegalArgumentException("Invalid direction: " + direction);
        }
        rover.setPosition(initialX, initialY, finalDirection);
    }

    @Then("the Rover's position and direction should be '(.*)'$")
    public void verifyPositionAndDirection(String expectedDirection) {
        assertEquals(expectedDirection, rover.printPosition());

    }

    @And("^NASA gives '(\\w+)' as instructions to the Rover$")
    public void giveRoverInstructions(String instructions) {
        this.instructions = instructions;
        rover.process(instructions);
    }

    @When("^NASA moves the Rover forward$")
    public void moveRoverForward() {
        rover.move();
    }

    @When("^NASA turns the Rover right$")
    public void turnRoverRight() {
        rover.turnRight();
    }

    @When("^NASA turns the Rover left$")
    public void turnRoverLeft() {
        rover.turnLeft();
    }
}

