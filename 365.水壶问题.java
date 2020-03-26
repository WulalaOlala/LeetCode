import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=365 lang=java
 *
 * [365] 水壶问题
 */

// @lc code=start
class Solution {
    public boolean canMeasureWater(int x, int y, int z) {

        // Queue<State> states = new LinkedList<>();
        // Set<State> visited = new HashSet<>();
        // State initState = new State(0,0);
        // states.offer(initState);
        // visited.add(initState);
        // while(!states.isEmpty()){
        //     State current = states.poll();
        //     if(current.getX() + current.getY() == z){
        //         return true;
        //     }
        //     List<State> nextStatus = generateNextStatus(current.getX(),current.getY(),x,y);
        //     for(State s : nextStatus){
        //         if(!visited.contains(s)){
        //             states.offer(s);
        //             visited.add(s);
        //         }
        //     }
        // }
        // return false;
        if(x+y < z) return false;
        if(x==0 || y==0) return z == 0 || x+y ==z;
        int xy = gcd(x,y);
        return z % xy == 0;

    }

    private int gcd(int x, int y) {
        int result = x > y ? y : x;
        for(;result > 1; result--){
            if(x%result == 0 && y%result == 0){
               break;
            }
        }
        return result;
    }

    private List<State> generateNextStatus(int currentX, int currentY, int x, int y) {
        List<State> nextStates = new ArrayList<>(6);
        State stateAFull = new State(x,currentY);
        State stateBFull = new State(currentX,y);
        State stateAEmpty = new State(0,currentY);
        State stateBEmpty = new State(currentX,0);

        State stateA2B = (currentX > y-currentY)?new State(currentX+currentY-y,y):new State(0,currentX+currentY);
        State stateB2A = (currentY > x-currentX)?new State(x,currentX+currentY-x):new State(currentX+currentY,0);
        nextStates.add(stateAFull);
        nextStates.add(stateBFull);
        nextStates.add(stateAEmpty);
        nextStates.add(stateBEmpty);
        nextStates.add(stateA2B);
        nextStates.add(stateB2A);
        return nextStates;
    }

    public class State {
        int x;
        int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            State other = (State) obj;
            if (x != other.x)
                return false;
            if (y != other.y)
                return false;
            return true;
        }

        public State(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}
// @lc code=end
