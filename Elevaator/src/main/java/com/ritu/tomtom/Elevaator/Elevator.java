package com.ritu.tomtom.Elevaator;

import java.util.LinkedList;
import java.util.Queue;

public class Elevator {

	private int currentFloor;
	private Queue<Integer> destinationFloors;

	public int nextDestination() {
		return this.destinationFloors.peek();
	}
	
	public Elevator(Integer currentFloor) {
	    this.currentFloor = currentFloor;
	    this.destinationFloors = new LinkedList<Integer>();
	  }
	
	public void removeDestination(){
	    this.destinationFloors.remove();
	  }
	
	public void addNewDestination(Integer destination) {
	    this.destinationFloors.add(destination);
	  }
	public ElevatorDirection direction() {
	    if (destinationFloors.size() > 0){
	      if (currentFloor < destinationFloors.peek()){
	        return ElevatorDirection.ELEVATOR_UP;
	      } else if (currentFloor > destinationFloors.peek()) {
	        return ElevatorDirection.ELEVATOR_DOWN;
	      }
	    }
	    return ElevatorDirection.ELEVATOR_HOLD;
	  }

	public int currentFloor() {
		return this.currentFloor;
	}

	public ElevatorStatus status() {
	    return (destinationFloors.size() > 0)?ElevatorStatus.ELEVATOR_OCCUPIED:ElevatorStatus.ELEVATOR_EMPTY;
	  }
	
	public void moveUp() {
		currentFloor++;
	}

	public void moveDown() {
		currentFloor--;
	}


}
