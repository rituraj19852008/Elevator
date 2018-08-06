package com.ritu.tomtom.Elevaator;


import static junit.framework.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElevatorTest {
  public static final int TENTH_FLOOR = 10;
  public static final int SECOND_FLOOR = 2;
  public static final int BASEMENT_TWO = -2;

  private Elevator elevator;

  @BeforeMethod
  public void initializeElevator(){
    elevator = new Elevator(0);
  }

  @Test
  public void testAddingDestination(){
    elevator.addNewDestination(TENTH_FLOOR);
    assertEquals(TENTH_FLOOR, elevator.nextDestination());
  }

  @Test
  public void checkCurrentFloor(){
    // Move to floor 2
    elevator.moveUp();
    elevator.moveUp();
    assertEquals(SECOND_FLOOR, elevator.currentFloor());
  }

  @Test
  public void checkMoveDown(){
    elevator.moveDown();
    elevator.moveDown();
    assertEquals(BASEMENT_TWO, elevator.currentFloor());
  }

  @Test
  public void checkDirectionUp(){
    elevator.addNewDestination(SECOND_FLOOR);
    assertEquals(ElevatorDirection.ELEVATOR_UP, elevator.direction());
  }

  @Test
  public void checkDirectionDown(){
    elevator.addNewDestination(BASEMENT_TWO);
    assertEquals(ElevatorDirection.ELEVATOR_DOWN, elevator.direction());
  }

  @Test
  public void checkDirectionHold(){
    assertEquals(ElevatorDirection.ELEVATOR_HOLD, elevator.direction());
  }

  @Test
  public void checkStatusEmpty(){
    assertEquals(ElevatorStatus.ELEVATOR_EMPTY, elevator.status());
  }

  @Test
  public void checkStatusOccupied(){
    elevator.addNewDestination(TENTH_FLOOR);
    assertEquals(ElevatorStatus.ELEVATOR_OCCUPIED, elevator.status());
  }
}
