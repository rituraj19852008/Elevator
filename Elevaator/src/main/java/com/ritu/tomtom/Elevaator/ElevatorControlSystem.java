package com.ritu.tomtom.Elevaator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ElevatorControlSystem {
	
	public static final int MAX_REGULAR_ELEVATORS = 27;
	public static final int MAX_VIP_ELEVATORS = 3;
	  Integer numberOfElevators = 0;
	  Integer numberOfFloors = 0;
	  ArrayList<Elevator> elevators;
	  Queue<Integer> pickupLocations;
	  
	  public ElevatorControlSystem(Integer numberOfElevators, Integer numberOfFloors)  {
		    
		    this.numberOfElevators = (numberOfElevators > MAX_REGULAR_ELEVATORS)?MAX_REGULAR_ELEVATORS:numberOfElevators;
		    this.numberOfFloors = numberOfFloors;
		    initializeElevators();
		    pickupLocations = new LinkedList<Integer>();
		  }

	  private void initializeElevators(){
		    elevators = new ArrayList<Elevator>();
		    for (int idx=0;idx<this.numberOfElevators;idx++){
		      elevators.add(new Elevator(1));
		    }
		  }
	  public ArrayList<Elevator> getElevators(){
		    return elevators;
		  }
	  public void pickUp(Integer pickUpFloor) {
		    pickupLocations.add(pickUpFloor);
		  }
	  public void destination(Integer elevatorId, Integer destinationFloor) {
		    elevators.get(elevatorId).addNewDestination(destinationFloor);
		  }
	  
	  public void step() {
		    // Loop though every elevator
		    for (Elevator currElevator : elevators){
		      // Check to figure out which ones are unoccupied and update call
		      switch (currElevator.status()){
		        case ELEVATOR_EMPTY:
		          if (!pickupLocations.isEmpty())
		            currElevator.addNewDestination(pickupLocations.poll());
		          break;
		        // Move occupied Elevators one step closer to next closest destination in direction
		        case ELEVATOR_OCCUPIED:
		          switch (currElevator.direction()){
		            case ELEVATOR_UP:
		              currElevator.moveUp();
		              break;
		            case ELEVATOR_DOWN:
		              currElevator.moveDown();
		              break;
		            case ELEVATOR_HOLD:
		              currElevator.removeDestination();
		              break;
		          }
		          if (currElevator.direction() == ElevatorDirection.ELEVATOR_UP) {
		        	  break;
		          }
		      }
		    }
		  }

}
