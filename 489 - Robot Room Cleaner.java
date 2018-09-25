/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {

    public void cleanRoom(Robot robot) {
        // A number can be added to each visited cell
        // use string to identify the class
        Set<String> set = new HashSet<>();
        int dir = 0;   // 0: up, 90: right, 180: down, 270: left
        backtrack(robot, set, 0, 0, dir);
    }

    public void backtrack(Robot robot, Set<String> set, int i, int j, int dir) {
    	String tmp = i + "->" + j;
    	if (set.contains(tmp)) {
            return;
        }
        
    	robot.clean();
    	set.add(tmp);

    	for (int n = 0; n < 4; n++) {
        // the robot can to four directions, we use right turn
    		if (robot.move()) {
    			// can go directly. Find the (x, y) for the next cell based on current direction
    			int x = i, y = j;
    			switch (dir) {
    				case 0:
    					// go up, reduce i
    					x = i - 1;
    					break;
    				case 90:
    					// go right
    					y = j + 1;
    					break;
    				case 180:
    					// go down
    					x = i + 1;
    					break;
    				case 270:
    					// go left
    					y = j - 1;
    					break;
    				default:
    					break;
    			}

    			backtrack(robot, set, x, y, dir);
                // go back to the starting position
			    robot.turnLeft();
    			robot.turnLeft();
    			robot.move();
    			robot.turnRight();
    			robot.turnRight();

    		} 
    		// turn to next direction
    		robot.turnRight();
    		dir += 90;
    		dir %= 360;
    	}

    }
    
}